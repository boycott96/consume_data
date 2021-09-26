package com.jrhl.constant;

public enum ApiEnum {

    GET_CONSUME_DATA("https://agent.oceanengine.com/agent/settlement/adv/cost/");

    /**
     * 属性
     */
    private final String api;

    ApiEnum(String api) {
        this.api = api;
    }

    public String getApi() {
        return api;
    }
}
