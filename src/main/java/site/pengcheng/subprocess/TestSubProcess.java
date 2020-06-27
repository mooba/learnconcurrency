package site.pengcheng.subprocess;

import java.io.IOException;

/**
 * @author pengchengbai
 * @description
 * @date 2020/6/12 8:47 下午
 */
public class TestSubProcess {

    public static void main(String[] args) throws IOException {
//        Runtime run = Runtime.getRuntime();
//        Process p = run.exec("java Test");
        String javaHome = System.getProperty("java.home");
        System.out.println(javaHome);
    }
}
