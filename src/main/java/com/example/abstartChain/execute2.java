package com.example.abstartChain;

import org.springframework.stereotype.Component;

/**
 * @author :zlq
 * @date : 2024/2/7
 */
@Component
public class execute2 implements AbstractChainHandler{
    @Override
    public void handler(Object requestParam) {
        System.out.println("execute2");
    }

    @Override
    public String mark() {
        return "2";
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
