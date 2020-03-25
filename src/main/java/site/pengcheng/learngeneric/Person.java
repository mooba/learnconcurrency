package site.pengcheng.learngeneric;

import java.io.*;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/4 3:04 下午
 */
public class Person implements Serializable {
    private String name;
    private int age;

    private Person() {
        throw new AssertionError();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }



    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(new StringBuilder(this.name).reverse());
        objectOutputStream.writeInt(age);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException{
        this.name = ((StringBuilder) objectInputStream.readObject()).reverse().toString();
        this.age = objectInputStream.readInt();
    }

    private Object readResolve() {
        return new Person("brady", 24);
    }
    
    public static void main(String[] args) throws Exception{
//        String fileName = "/Users/pengchengbai/IdeaProjects/learnconcurrency/person.txt";
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
//            // 序列化
//            Person person = new Person("lufei", 23);
//            oos.writeObject(person);
//            System.out.println(person);
//            System.out.println(new File(fileName).length());
//
//
//            // 反序列化
//            Person person1 = (Person) ois.readObject();
//            System.out.println(person1);
//
//        }

        Person p = new Person("bai", 34);
        System.out.println(p);
        System.out.printf("%x\n", p.hashCode());
    }
}