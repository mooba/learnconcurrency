package site.pengcheng.functional.ch4;

/**
 * @author pengchengbai
 * @description
 * @date 2020/1/18 5:48 下午
 */
public class ch4 {

    public static void main(String[] args) {
        Parent p = new ParentImpl();
        p.welcome();
        System.out.println(p.getLastMessage());


        Child c = new ChildImpl();
        c.welcome();

    }
}
