package com.example.abstartChain;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author :zlq
 * @date : 2024/2/7
 */
@Component
public class AbstractChainContext<T> implements CommandLineRunner {

    @Autowired
    ApplicationContext applicationContext;
    private final Map<String, List<AbstractChainHandler>> abstractChainHandlerContainer = Maps.newHashMap();
    /**
     * 责任链组件执行
     *
     * @param requestParam 请求参数
     */
    public void handler(String mark, T requestParam) {
        abstractChainHandlerContainer.get(mark).stream().forEach(each -> each.handler(requestParam));
    }
    @Override
    public void run(String... args) throws Exception {
        Map<String, AbstractChainHandler> beans = applicationContext.getBeansOfType(AbstractChainHandler.class);
        beans.forEach(
                (key,chain)->{
                    List<AbstractChainHandler> abstractChainHandlers = abstractChainHandlerContainer.get(chain.mark());
                    if (CollectionUtils.isEmpty(abstractChainHandlers)) {
                        abstractChainHandlers = new ArrayList<>();
                    }
                    abstractChainHandlers.add(chain);
                    abstractChainHandlerContainer.put(chain.mark(), abstractChainHandlers);
                }
        );
        System.out.println(JSON.toJSONString(abstractChainHandlerContainer));

    }
}
