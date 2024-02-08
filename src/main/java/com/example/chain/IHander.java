package com.example.chain;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zlq
 * @date : 2024/2/6
 */
public class IHander {

    private static final List<ChainHandler> list = new ArrayList<>();

    void addall(List<ChainHandler> chainHandlerList) {
        list.addAll(chainHandlerList);
    }
    void handler() {
        list.forEach(ChainHandler::handle);
    }

    public static void main(String[] args) {
        IHander hander = new IHander();
        hander.addall(Lists.newArrayList(new ChainHandlerExecute(), new ChainHandlerExecute2()));
        hander.handler();
    }
}
