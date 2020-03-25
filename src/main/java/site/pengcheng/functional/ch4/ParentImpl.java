package site.pengcheng.functional.ch4;

/**
 * @author pengchengbai
 * @description
 * @date 2020/1/18 5:49 下午
 */
public class ParentImpl implements Parent {
    private String body;

    @Override
    public void message(String body) {
        this.body = body;
        System.out.println(body);
    }

    @Override
    public String getLastMessage() {
        return body;
    }
}
