package com.yupi.maker.template.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/5/9 09:59
 * @description 文件过滤配置
 * @since 4.0.0
 */
@Data
@Builder
public class FileFilterConfig {
    /**
     * 过滤范围
     */
    private String range;

    /**
     * 过滤规则
     */
    private String rule;

    /**
     * 过滤值
     */
    private String value;
}
