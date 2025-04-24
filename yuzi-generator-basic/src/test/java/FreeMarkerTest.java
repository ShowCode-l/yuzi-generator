import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 10:49
 * @description
 * @since 1.0.0
 */
public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {
        // 新建 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        // 指定模版文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        // 设置模版文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");
        // 创建模版对象，加载指定模版
        Template template = configuration.getTemplate("myweb.html.ftl");
        // 创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2025);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://codefather.cn");
        menuItem1.put("label", "编程导航");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://laoyujianli.com");
        menuItem2.put("label", "老鱼简历");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems", menuItems);
        // 指定生成的文件
        FileWriter out = new FileWriter("myweb.html");
        template.process(dataModel, out);
        // 生成文件后记得关闭
        out.close();
    }
}
