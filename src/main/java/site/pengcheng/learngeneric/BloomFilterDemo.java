package site.pengcheng.learngeneric;

import com.google.common.hash.BloomFilter;

import java.io.*;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/14 2:50 下午
 */
public class BloomFilterDemo {
    public static void main(String[] args) throws Exception{
        int total = 10000000; // 总数量
//        BloomFilter<CharSequence> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);
//
//
//        long start = System.currentTimeMillis();
//        System.out.println("开始初始化...");
//        // 初始化 1000000 条数据到过滤器中
//        for (int i = 0; i < total; i++) {
//            bf.put("" + i);
//        }
//        System.out.println("结束初始化");


//        BloomFilter<CharSequence> bf = deserializeFromFile();
//
//        long start = System.currentTimeMillis();
//        // 判断值是否存在过滤器中
//        int count = 0;
//        System.out.println("开始判断");
//        for (int i = 0; i < total + 10000; i++) {
//            if (bf.mightContain("" + i)) {
//                count++;
//            }
//        }
//
//        serializeToFile(bf);
//
//        System.out.println("已匹配数量：" + count + " 用时：" + (System.currentTimeMillis() - start));

        char[] charArr = new char[10];
        for (int i = 0; i < charArr.length; i++) {
            System.out.println(charArr[i]);
        }


    }


    private static void serializeToFile(Object obj) throws IOException {
        String filePath = "BloomFilter_10000000_003.txt";
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(obj);
    }

    private static BloomFilter<CharSequence> deserializeFromFile() throws IOException, ClassNotFoundException {
        String filePath = "BloomFilter_10000000_003.txt";
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
        return (BloomFilter<CharSequence>)inputStream.readObject();
    }
}

