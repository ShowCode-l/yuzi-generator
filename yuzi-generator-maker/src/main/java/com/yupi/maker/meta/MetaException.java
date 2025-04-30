package com.yupi.maker.meta;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/28 10:02
 * @description 自定义元信息的配置异常类
 * @since 3.0.0
 */
public class MetaException extends RuntimeException {

    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
