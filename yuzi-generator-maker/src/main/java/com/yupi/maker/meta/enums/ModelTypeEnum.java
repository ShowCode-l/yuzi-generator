package com.yupi.maker.meta.enums;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/28 10:18
 * @description 模型类型枚举
 * @since 3.0.0
 */
public enum ModelTypeEnum {

    STRING("字符串", "String"),
    BOOLEAN("布尔", "boolean");

    private final String text;

    private final String value;

    ModelTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
