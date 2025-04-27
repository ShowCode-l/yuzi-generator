package com.yupi.maker.model;

import lombok.Data;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 13:11
 * @description 动态模板配置
 * @since 3.0.0
 */
@Data
public class DataModel {
    /**
     * 是否生成循环
     */
    private boolean loop;
    /**
     * 作者注释，默认值是 yupi
     */
    private String author = "yupi";
    /**
     * 输出信息，默认值是 sum =
     */
    private String outputText = "sum = ";

}
