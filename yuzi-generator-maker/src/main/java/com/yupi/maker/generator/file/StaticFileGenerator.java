package com.yupi.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 10:15
 * @description
 * @since 3.0.0
 */
public class StaticGenerator {

    /*
        使用Hutool工具库实现目录复制功能
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
