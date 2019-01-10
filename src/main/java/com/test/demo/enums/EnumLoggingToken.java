package com.test.demo.enums;

/**
 * 存储标记的枚举类型
 */
public enum EnumLoggingToken {
    /**
     * 伤害测试的枚举数据.用于coocs客户端,匹配需要拦截的字符串所需要的标记.
     */
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
