package com.yupi.maker.generator.main;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/25 14:51
 * @description 生成代码生成器
 * @since 3.0.0
 */
public class MainGenerator extends GenerateTemplate {

    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("不要给我输出 dist 啦！");
    }
}
