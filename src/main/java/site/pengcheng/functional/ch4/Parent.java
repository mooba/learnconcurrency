package site.pengcheng.functional.ch4;

/**
 * @author pengchengbai
 * @description
 * @date 2020/1/18 5:48 下午
 */
public interface Parent {
    public void message(String body);

    public default void welcome() { message("Parent: Hi!");
    }

    public String getLastMessage();
}
