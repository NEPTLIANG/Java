class TicketOffice implements Runnable {
    //2019.5.30.Thu 实验8（实验指导书P125，实验11.3 铁路售票程序）
    //诸神庇佑，BUG退散
    private static Integer ticketCount = 100;  //临界代码中的共享变量应定义为private型，否则其他类的方法可能直接访问操作该共享变量，这样synchromnized的保护就失去了意义

    public void run() {
        while (ticketCount > 0) {
            synchronized (ticketCount) {  //同步的资源须为对象
                System.out.println(ticketCount-- + "号票由"
                        + Thread.currentThread().getName() + "售出");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class Experiment8_11_3 {
    public static void main(String[] args) {
//        TicketOffice.ticketCount = 10;
        TicketOffice tOffice = new TicketOffice();
        Thread[] th = new Thread[4];
        int j = 0;
        for (Thread i : th) {
            i = new Thread(tOffice, (j++)+"号窗");
            i.start();
        }
    }
}