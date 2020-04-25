package site.pengcheng.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.io.*;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/14 2:50 下午
 */
public class BloomFilterDemo {
    public static void main(String[] args) throws Exception{
        // 总数量
        int total = 20_000_000;
        BloomFilter<CharSequence> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);


        long startInit = System.currentTimeMillis();
        System.out.println("开始初始化...");
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }
        long initTimeInMillis = System.currentTimeMillis() - startInit;
        System.out.println("结束初始化，用时：" + initTimeInMillis);

        System.out.println("approximateElementCount:" + bf.approximateElementCount());

        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }

        System.out.println("approximateElementCount:" + bf.approximateElementCount());



//        BloomFilter<CharSequence> bf = deserializeFromFile();

        long startJudge = System.currentTimeMillis();
        // 判断值是否存在过滤器中
        int count = 0;
        System.out.println("开始判断");
        for (int i = 0; i < total + 10000; i++) {
            if (bf.mightContain("" + i)) {
                count++;
            }
        }

        serializeToFile(bf);

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

