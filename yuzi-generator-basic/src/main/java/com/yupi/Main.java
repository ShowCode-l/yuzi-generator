package com.yupi;

import com.yupi.cli.command.CommandExecutor;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/23 13:12
 * @description
 *  如果是直接执行程序进行测试，可以将赋值args参数的任一注释解开进行测试对应的命令
 *  该类也是打成jar包后的程序执行入口，打jar包之前，应当把args的赋值语句全部注掉，让args的参数来源于执行jar包时的命令行
 * @since 2.0.0
 */
public class Main {
    public static void main(String[] args) {
//        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}