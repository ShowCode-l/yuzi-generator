package com.yupi.maker;

import com.yupi.maker.generator.main.MainGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/23 13:12
 * @description
 * @since 3.0.0
 */
public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }
}