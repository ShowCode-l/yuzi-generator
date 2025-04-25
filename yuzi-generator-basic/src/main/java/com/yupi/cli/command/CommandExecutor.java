package com.yupi.cli.command;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 17:20
 * @description 命令执行器
 * @since 2.0.0
 */
@Command(name = "yuzi", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 -- help 查看命令提示");
    }

    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
