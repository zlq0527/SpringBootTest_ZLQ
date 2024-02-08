package com.example.chain;

import org.springframework.stereotype.Component;

/**
 * @author :zlq
 * @date : 2024/2/6
 */
@Component
public class ChainHandlerExecute2 implements ChainHandler{
    @Override
    public void handle() {
        System.out.println("ChainHandlerExecute2 handle");
    }
}
