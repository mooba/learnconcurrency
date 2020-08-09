package site.pengcheng.reactive;


import java.util.concurrent.SubmissionPublisher;

/**
 * @author pengchengbai
 * @description 延时Flow的生产者和发布者，需要jdk9以上才能正常运行
 * @date 2020/6/27 5:26 下午
 */
public class FlowDemo {

    public static void main(String[] args) throws Exception{
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

//        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<Integer>();
//
//        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<Integer>() {
//            private Flow.Subscription subscription;
//
//            @Override
//            public void onSubscribe(Flow.Subscription subscription) {
//                this.subscription = subscription;
//                this.subscription.request(1);
//            }
//
//            @Override
//            public void onNext(Integer item) {
//                System.out.println("接收到数据： " + item);
//                this.subscription.request(1);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                throwable.printStackTrace();
//
//                // 告诉发布者不接受数据了
//                this.subscription.cancel();
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("处理完了");
//            }
//        };
//
//        // 发布者和订阅者建立订阅关系
//        publisher.subscribe(subscriber);
//
//        // 发布数据
//        int data = 111;
//
//        publisher.submit(data);
//
//        publisher.close();
//
//        // 主线程延迟停止，否则数据没有消费就退出
//        Thread.currentThread().join(1000);
    }
}
