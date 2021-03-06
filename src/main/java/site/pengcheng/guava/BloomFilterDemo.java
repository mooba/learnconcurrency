package site.pengcheng.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.lucene.util.RamUsageEstimator;
import org.openjdk.jol.info.ClassLayout;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/14 2:50 下午
 */
public class BloomFilterDemo {
    // 总数量
    private static final int total = 20_000_000;

    public static void main(String[] args) throws Exception{
//        BloomFilterDemo demo = new BloomFilterDemo();

//        List<Long> list = new ArrayList<>(100);
//        BloomFilter<Long> bf = BloomFilter.create(Funnels.longFunnel(), total, 0.01);
//        long startInit = System.currentTimeMillis();
//        System.out.println("开始初始化...");
//        for (long i = 0; i < total; i = i + 2) {
//            bf.put(i);
//            list.add(i);
//        }
//        long initTimeInMillis = System.currentTimeMillis() - startInit;
//        System.out.println("结束初始化，用时：" + initTimeInMillis + " approximateElementCount:" + bf.approximateElementCount());


        Long a = new Long(129);
        Integer b = new Integer(129);
//        System.out.println("size1:" + RamUsageEstimator.sizeOfObject(a));
//        System.out.println("size2:" + RamUsageEstimator.sizeOfObject(b));
//        System.out.println("size3:" + RamUsageEstimator.sizeOfObject(bf));
//        System.out.println(RamUsageEstimator.sizeOfObject(bf, 0));


        Object object = new Object();
        System.err.println(ClassLayout.parseInstance(object).toPrintable());


    }



    private BloomFilter<Long> createBf() {

        BloomFilter<Long> bf = BloomFilter.create(Funnels.longFunnel(), total, 0.01);
        long startInit = System.currentTimeMillis();
        System.out.println("开始初始化...");
        for (long i = 0; i < total; i = i + 2) {
            bf.put(i);
        }
        long initTimeInMillis = System.currentTimeMillis() - startInit;
        System.out.println("结束初始化，用时：" + initTimeInMillis + "approximateElementCount:" + bf.approximateElementCount());

        return bf;
    }


    private void judgeExist(BloomFilter<Long> bf) {
        long startJudge = System.currentTimeMillis();
        // 判断值是否存在过滤器中
        int count = 0;
        System.out.println("开始判断");
        for (long i = 1; i < total; i=i +2) {
            if (bf.mightContain(i)) {
                count++;
            }
        }

        System.out.println("已匹配数量：" + count + " 用时：" + (System.currentTimeMillis() - startJudge));
    }


    //    @Bean("shopIdCache")
//    public List<Integer> getSortedShopIdList() {
//        long start = System.currentTimeMillis();
////        List<Integer> shopIdList = sellerAccountRepository.findAllShopId();
//        List<Integer> shopIdList = new ArrayList<>(20000000);
//        for (int i = 0; i < 20000000; i++) {
//            shopIdList.add(random.nextInt(200000000));
//        }
//        shopIdList.sort(Comparator.naturalOrder());
//        log.info("loaded all shopid to List cache,duration:{}, size={}", System.currentTimeMillis() - start, shopIdList.size());
//        return shopIdList;
//    }


//    @Bean("shopIdCache")
//    public int[] getSortedShopIdArr() {
//        long start = System.currentTimeMillis();
////        int[] shopIdArr = sellerAccountRepository.findAllShop();
//
//        int[] shopIdArr = new int[20000000];
//        for (int i = 0; i < shopIdArr.length; i ++) {
//            shopIdArr[i] = random.nextInt(200000000);
//        }
//        Arrays.sort(shopIdArr);
////                IntStream.generate(() -> random.nextInt(200000000)).parallel().distinct().limit(20000000).sorted().toArray();
//        log.info("loaded all shopid to array cache,duration:{}, size={}", System.currentTimeMillis() - start, shopIdArr.length);
//        return shopIdArr;
//    }


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

