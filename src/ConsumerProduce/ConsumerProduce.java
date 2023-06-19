package ConsumerProduce;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProduce {
    private static Queue<Object> queue = new LinkedList<>();
    public static void main(String[] args) {
        new Thread(ConsumerProduce::Producer, "chef.1").start();
        new Thread(ConsumerProduce::Producer, "chef.2").start();

        new Thread(ConsumerProduce::Consumer, "client.1").start();
        new Thread(ConsumerProduce::Consumer, "client.2").start();

    }
    private static void Producer() {
        while (true) {
            try {
                Thread.sleep(3000);
                synchronized (queue){
                    String name = Thread.currentThread().getName();//获取线程名字
                    System.out.println(new Date() + " "+ name+" 出餐了!!!");
                    queue.offer(new Object());
                    queue.notifyAll();
                    //唤醒queue.wait的线程, 通知队列客户可以取餐
                    //因为有好几个客户线程,几个客户线程的队列都可能为空然后被wait,所以需要唤醒几个客户线程的队列
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Consumer() {
        while(true) {
            try {
                synchronized (queue){
                    while (queue.isEmpty()) {queue.wait();}
                    //需要使用while来不断循环判断队列中是否有菜, 只用if只会判断一次,队列中有可能会有很多菜品
                    queue.poll();
                    String name = Thread.currentThread().getName();
                    System.out.println(new Date() + " "+ name+" 取走了餐 正在享用!!!");
                }
                Thread.sleep(6000);//取走需要享用的等待时间
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
