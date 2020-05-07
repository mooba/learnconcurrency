package site.pengcheng.designpattern.factory.di;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/25 5:29 下午
 */
public class ConstructorArg {
    private String type;
    private Object value;
    private boolean idRef;

    public ConstructorArg(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public boolean isIdRef() {
        return idRef;
    }
}
