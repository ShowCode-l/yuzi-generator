package com.yupi.cli.pattern;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 16:18
 * @description 客户端
 * @since 2.0.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建接收者对象
        Device tv = new Device("TV");
        // stereo 立体声
        Device stereo = new Device("Stereo");

        // 创建具体命令对象，可以绑定不同的设备
        TurnOnCommand turnOn = new TurnOnCommand(tv);
        TurnOffCommand turnOff = new TurnOffCommand(stereo);

        // 创建调用者
        RemoteControl remote = new RemoteControl();
        // 执行命令
        remote.setCommand(turnOn);
        remote.pressButton();
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
