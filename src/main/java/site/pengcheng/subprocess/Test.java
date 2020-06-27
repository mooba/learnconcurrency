package site.pengcheng.subprocess;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author pengchengbai
 * @description
 * @date 2020/6/16 4:11 下午
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileOutputStream fOut = new FileOutputStream("/Users/pengchengbai/IdeaProjects/TestSubprocess/Test1.txt");
        fOut.close();
        System.out.println("被调用成功!");
    }
}
