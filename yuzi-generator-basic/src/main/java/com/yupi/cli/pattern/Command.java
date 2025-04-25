package com.yupi.cli.pattern;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 16:09
 * @description
 *  命令模式：23种设计模式中的一种，属于行为型设计模式，最大的优点是解耦请求的发送者和接收者
 *  分为 命令、具体命令、接收者、调用者、客户端
 *  命令：抽象类或接口
 *  具体命令：继承或实现了命令接口的类
 *  接收者：执行命令的对象
 *  调用者：接收客户端的命令并执行
 *  客户端：创建命令对象并将其与接收者关联，然后将命令对象传递给调用者进行执行
 * @since 2.0.0
 */
public interface Command {
    void execute();
}
