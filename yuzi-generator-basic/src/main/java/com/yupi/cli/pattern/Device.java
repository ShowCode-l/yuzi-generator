package com.yupi.cli.pattern;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/24 16:14
 * @description 接收者
 * @since 2.0.0
 */
public class Device {
    private String name;

    public Device(String name) {
        this.name = name;
    }

    public void turnOn(){
        System.out.println(name + "设备打开");
    }

    public void turnOff(){
        System.out.println(name + "设备关闭");
    }
}
