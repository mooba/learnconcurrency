package site.pengcheng.functional.ch4;

public interface Child extends Parent{
    @Override
    default void welcome() {
        message("Child: Hi!");
    }
}
