package com.yupi.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yupi.generator.MainGenerator;
import com.yupi.model.MainTemplateConfig;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 16:56
 * @description generate子命令，作用是接收参数并生成代码
 * @since 2.0.0
 */
@Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {

    /*
        arity: 给交互式输入的命令选项添加，0..1 表示可以在完整命令中直接给选项传递参数，也可以选择交互式输入
        interactive: 给命令选项添加该参数表示该选项支持交互输入
        echo:  用户交互式输入的内容会显示在控制行中，默认不会显示
     */
    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop;
    @Option(names = {"-a", "--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    private String author;
    @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
    private String outputText;

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(this.loop);
        mainTemplateConfig.setAuthor(this.author);
        mainTemplateConfig.setOutputText(this.outputText);
        System.out.println("配置信息：" + mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
