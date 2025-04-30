package ${basePackage}.generator;

import com.yupi.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

<#macro generateFile indent fileInfo>
    ${indent}inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
    ${indent}outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
    <#if fileInfo.generateType == "static">
    ${indent}StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    <#else>
    ${indent}DynamicGenerator.doGenerate(inputPath, outputPath, model);
    </#if>
</#macro>

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 13:50
 * @description
 * @since 3.0.0
 */
public class MainGenerator {

    // 生成
    public static void doGenerate(DataModel model) throws TemplateException, IOException {

        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        String inputPath;
        String outputPath;

    <#list modelConfig.models as modelInfo>
        <#-- 有分组 -->
        <#if modelInfo.groupKey??>
        <#list modelInfo.models as subModelInfo>
        ${subModelInfo.type} ${subModelInfo.fieldName} = model.${modelInfo.groupKey}.${subModelInfo.fieldName};
        </#list>
        <#else>
        ${modelInfo.type} ${modelInfo.fieldName} = model.${modelInfo.fieldName};
        </#if>
    </#list>

    <#list fileConfig.files as fileInfo>
        <#if fileInfo.groupKey??>
        // groupKey = ${fileInfo.groupKey}
        <#if fileInfo.condition??>
        if(${fileInfo.condition}) {
            <#list fileInfo.files as fileInfo>
            <@generateFile indent="        " fileInfo=fileInfo/>
            </#list>
        }
        <#else>
        <#list fileInfo.files as fileInfo>
            <@generateFile indent="    " fileInfo=fileInfo/>
        </#list>
        </#if>
        <#else>
        <#if fileInfo.condition??>
        if(${fileInfo.condition}) {
            <#list fileInfo.files as fileInfo>
            <@generateFile indent="    " fileInfo=fileInfo/>
            </#list>
        }
        <#else>
        <@generateFile indent="    " fileInfo=fileInfo/>
        </#if>
        </#if>
    </#list>
    }
}
