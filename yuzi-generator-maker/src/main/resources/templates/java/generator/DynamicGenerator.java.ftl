package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;
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
 * @since 3.0.0
 */
public class DynamicGenerator {

    /**
     * 生成文件
     *
     * @param inputPath  模版文件输入路径
     * @param outputPath 输出路径
     * @param model      数据模型
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

        // 文件不存在则创建文件和父目录
        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }
        // 指定生成的文件
        Writer out = new FileWriter(outputPath);
        template.process(model, out);

        // 生成文件后记得关闭
        out.close();
    }
}
