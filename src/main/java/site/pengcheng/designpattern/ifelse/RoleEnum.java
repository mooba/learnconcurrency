package site.pengcheng.designpattern.ifelse;

public enum RoleEnum implements RoleOperation {
    /** 系统管理员 */
    ROLE_ROOT_ADMIN {
        @Override
        public String op() {
            return "ROLE_ROOT_ADMIN:" + " has AAA permission";
        }
    },

    ROLE_ORDER_ADMIN {
        @Override
        public String op() {
            return "ROLE_ORDER_ADMIN:" + " has BBB permission";
        }
    },

    ROLE_NORMAL {
        @Override
        public String op() {
            return "ROLE_NORMAL:" + " has CCC permission";
        }
    }

}
