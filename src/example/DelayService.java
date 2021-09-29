package example;

import java.util.Random;
import java.util.concurrent.DelayQueue;

/**
 * @Author: Urey
 * @Date: 2021/8/31
 */
public class DelayService {

    static DelayQueue<OrderMessage> delayQueue = new DelayQueue();

    static long duration = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0;i <= 10;i++){
                long current = System.currentTimeMillis();
                int delayLevel = (new Random().nextInt(10) + 1);
                delayQueue.offer(new OrderMessage(i,current + delayLevel * duration,delayLevel,current));
                System.out.println("add task success!current is " + current + " and delayLevel is " + delayLevel);
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            for (;;) {
                if (delayQueue.isEmpty()){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    if (delayQueue.peek().getExpiredAt() <= System.currentTimeMillis()) {
                        OrderMessage message = delayQueue.poll();
                        System.out.println("message is " + message.toString() + " and time is pass " + (System.currentTimeMillis() - message.getCreatedAt()));
                    }
                }
            }
        });
        thread2.start();
        Thread.sleep(1);
        while (true){
            if (delayQueue.isEmpty()) {
                System.out.println("任务完成！退出任务！");
                break;
            }
        }
        System.exit(0);
    }
}
