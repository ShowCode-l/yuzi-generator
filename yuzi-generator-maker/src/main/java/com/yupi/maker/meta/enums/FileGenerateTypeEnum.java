package com.yupi.maker.meta.enums;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/28 10:16
 * @description 文件生成类型枚举
 * @since 3.0.0
 */
public enum FileGenerateTypeEnum {

    DYNAMIC("动态", "dynamic"),
    STATIC("静态", "static");

    private final String text;

    private final String value;

    FileGenerateTypeEnum(String text, String value) {
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
