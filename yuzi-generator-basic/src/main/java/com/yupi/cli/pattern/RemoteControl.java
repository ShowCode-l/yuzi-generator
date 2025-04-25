package com.yupi.cli.pattern;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 16:17
 * @description 调用者
 * @since 2.0.0
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
