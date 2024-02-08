package com.example.abstartChain;

import org.springframework.core.Ordered;

/**
 * @author :zlq
 * @date : 2024/2/7
 */
public interface AbstractChainHandler<T> extends Ordered {
    /**
     * 处理器 handler
     * @param requestParam 入参
     */
    void handler(T requestParam);

    /** 责任链标识,分类
     * @return
     */
    String mark();
}
