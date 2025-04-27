package ${basePackage}.generator;

import com.yupi.model.DataModel;
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
public class MainGenerator {

    // 生成
    public static void doGenerate(Object model) throws TemplateException, IOException {

        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        String inputPath;
        String outputPath;

<#list fileConfig.files as fileInfo>
    <#if fileInfo.generateType == "static">
        inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
        outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    <#else>
        inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
        outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
    </#if>
</#list>
    }
}
