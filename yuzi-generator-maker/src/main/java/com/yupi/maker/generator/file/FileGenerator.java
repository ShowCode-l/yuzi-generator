package com.yupi.maker.generator.file;

import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 13:50
 * @description
 * @since 3.0.0
 */
public class FileGenerator {

    // 生成
    public static void doGenerate(Object model) throws TemplateException, IOException {
        // 当前项目的根路径 /Users/lml/dev/java/yuzi-generator/yuzi-generator-maker
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径 /Users/lml/dev/java/yuzi-generator
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径 /Users/lml/dev/java/yuzi-generator/yuzi-generator-demo-projects/acm-template
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        // 生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}
