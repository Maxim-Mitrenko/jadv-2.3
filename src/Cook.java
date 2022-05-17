public class Cook {

    private static final long TIME_COOK = 1500;

    public void cook(Order order) {
        synchronized (order) {
            try {
                System.out.println("Повар готовит!");
                Thread.sleep(TIME_COOK);
                System.out.println("Повар закончил готовить");
                order.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
