package site.pengcheng.functional.ch4;

/**
 * @author pengchengbai
 * @description
 * @date 2020/1/18 5:56 下午
 */
public class ChildImpl implements Child {
    private String body;

    @Override
    public void message(String body) {
        this.body = body;
        System.out.println();
    }

    @Override
    public String getLastMessage() {
        return this.body;
    }
}
