package site.pengcheng.designpattern.ifelse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/2 11:28 上午
 */
public class RoleFactory {
    private static Map<String, RoleOperation> roleOperationMap = new HashMap<>();

    static {
        roleOperationMap.put("ROLE_ROOT_ADMIN", new RootAdminRole("ROLE_ROOT_ADMIN"));
        roleOperationMap.put("ROLE_ORDER_ADMIN", new OrderAdminRole("ROLE_ORDER_ADMIN"));
        roleOperationMap.put("ROLE_NORMAL", new NormalRole("ROLE_ORDER_ADMIN"));
    }

    public static RoleOperation getRole(String roleName) {
        return roleOperationMap.get(roleName);
    }
}
