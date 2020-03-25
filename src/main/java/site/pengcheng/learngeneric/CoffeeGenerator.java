package site.pengcheng.learngeneric;


import java.util.Iterator;
import java.util.Random;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/8 1:51 下午
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>{
    private Class[] types = {Cappuccion.class, Latte.class, Mocha.class, Breve.class};

    private int size = 0;

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    private static Random random = new Random(47);


    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


//    class CoffeeIterator implements Iterator<Coffee>{
//        private int count = size;
//        @Override
//        public boolean hasNext() {
//            return count>0;
//        }
//
//        @Override
//        public Coffee next() {
//            count --;
//            return CoffeeGenerator.this.next();
//        }
//
//        @Override
//        public void remove() {
//            throw new UnsupportedOperationException();
//        }
//    }
//
    @Override
    public Iterator<Coffee> iterator() {
        return null;
//        return new CoffeeIterator();
    }
    
    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
        for (int i = 0; i < 10; i ++) {
            System.out.println(coffeeGenerator.next());
        }

//        for (Coffee coffee: new CoffeeGenerator(6)) {
//            System.out.println(coffee);
//        }
    }
}
