package com.yupi.cli.pattern;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 16:13
 * @description 具体命令
 * @since 2.0.0
 */
public class TurnOffCommand implements Command{

    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}
