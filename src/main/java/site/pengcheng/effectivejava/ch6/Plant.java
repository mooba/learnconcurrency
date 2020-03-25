package site.pengcheng.effectivejava.ch6;

/**
 * @author pengchengbai
 * @description
 * @date 2020/1/17 2:16 下午
 */
class Plant {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }
    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle)
    {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}
