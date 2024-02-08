package com.example.chain;

import org.springframework.stereotype.Component;

/**
 * @author :zlq
 * @date : 2024/2/6
 */
@Component
public class ChainHandlerExecute implements ChainHandler{
    @Override
    public void handle() {
        System.out.println("run ChainHandlerExecute");
    }
}
