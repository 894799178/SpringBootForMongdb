package com.test.demo.enums;

public enum EnumLoggingToken {
    SHCS("伤害测试","shcs");

    private String key;

    private String value;

    EnumLoggingToken(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
