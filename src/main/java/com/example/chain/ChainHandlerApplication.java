package com.example.chain;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author :zlq
 * @date : 2024/2/6
 */
@Component
public class ChainHandlerApplication implements InitializingBean {

    @Autowired
    ApplicationContext applicationContext;
    private final List<ChainHandler> list = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, ChainHandler> chainHandlerMap = applicationContext.getBeansOfType(ChainHandler.class);
        chainHandlerMap.forEach((key, chain) -> list.add(chain));
    }

    void verify() {
        for (ChainHandler handler : list) {
            handler.handle();
        }
    }

}
