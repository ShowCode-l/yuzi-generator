package com.yupi.maker.generator;

import java.io.*;

/**
 * @author toretto
 * @version 1.0.0
 * @date 2025/4/27 13:19
 * @description
 * @since 3.0.0
 */
public class JarGenerator {
    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        // 清理之前的构建并打包
        // 注意不同的操作系统，执行的命令是不同的
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";
        String mavenCommand = otherMavenCommand;
        // 这里一定要拆分
        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));
        Process process = processBuilder.start();
        // 读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line  =reader.readLine()) != null) {
            System.out.println(line);
        }
        // 等待执行命令完成
        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码：" + exitCode);
    }
}
