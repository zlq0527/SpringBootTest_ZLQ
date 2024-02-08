package com.example.abstartChain;

import org.springframework.stereotype.Component;

/**
 * @author :zlq
 * @date : 2024/2/7
 */
@Component
public class execute1 implements AbstractChainHandler{
    @Override
    public void handler(Object requestParam) {
        System.out.println("execute1");
    }

    @Override
    public String mark() {
        return "1";
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
