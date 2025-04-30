package com.yupi.maker.meta.enums;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/28 10:17
 * @description 文件类型枚举
 * @since 3.0.0
 */
public enum FileTypeEnum {

    DIR("目录", "dir"),
    FILE("文件", "file"),
    GROUP("文件组", "group");

    private final String text;

    private final String value;

    FileTypeEnum(String text, String value) {
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
