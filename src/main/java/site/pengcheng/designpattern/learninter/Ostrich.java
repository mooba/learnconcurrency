package site.pengcheng.designpattern.learninter;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/29 10:00 下午
 */
public class Ostrich implements Tweetable, EggLayable {
    /**
     * 用组合获得功能
      */
    private TweetAbility tweetAbility = new TweetAbility();
    private EggLayAbility eggLayAbility = new EggLayAbility();

    @Override
    public void layEgg() {
        // 用委托避免代码重复
        eggLayAbility.layEgg();
    }

    @Override
    public void tweet() {
        tweetAbility.tweet();
    }
}
