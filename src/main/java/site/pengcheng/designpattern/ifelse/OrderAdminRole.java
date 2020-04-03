package site.pengcheng.designpattern.ifelse;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/2 10:37 上午
 */
public class OrderAdminRole implements RoleOperation{
    private String roleName;

    public OrderAdminRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String op() {
        return null;
    }
}
