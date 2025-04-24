package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 13:22
 * @description 动态文件生成
 * @since 1.0.0
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    /**
     * 生成文件
     *
     * @param inputPath 模版文件输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // 新建 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        // 指定模版文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);
        // 设置模版文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");
        // 创建模版对象，加载指定模版
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);
        // 指定生成的文件
        Writer out = new FileWriter(outputPath);
        template.process(model, out);
        // 生成文件后记得关闭
        out.close();
    }
}
