package com.yupi.maker.template.model;

import lombok.Data;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/5/12 13:35
 * @description
 * @since 5.0.0
 */
@Data
public class TemplateMakerOutputConfig {
    // 从未分组文件中移除组内的同名文件
    private boolean removeGroupFilesFromRoot = true;
}
