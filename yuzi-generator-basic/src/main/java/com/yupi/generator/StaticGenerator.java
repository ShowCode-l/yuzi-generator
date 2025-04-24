package com.yupi.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 10:15
 * @description
 * @since 1.0.0
 */
public class StaticGenerator {

    public static void main(String[] args) {
        // 获取整个项目的根目录
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径：ACM示例代码模版目录
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径：直接输出到项目的根目录
        String outputPath = projectPath;
        copyFilesByHutool(inputPath, outputPath);
    }

    /*
        使用Hutool工具库实现目录复制功能
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
