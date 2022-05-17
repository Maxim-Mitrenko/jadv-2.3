public class Client {

    private static final long TIME_CHOOSE_FOOD = 200;
    private static final long TIME_EAT = 1500;
    private static final long TALK = 500;

    public void goToRestaurant() {
        try {
            System.out.format("%s пришёл в ресторан\n", Thread.currentThread().getName());
            Thread.sleep(TIME_CHOOSE_FOOD);
            synchronized (this) {
                this.notify();
                System.out.format("%s разговаривает с официантом....\n", Thread.currentThread().getName());
                Thread.sleep(TALK);
                this.wait();
                System.out.format("%s приступил к еде!\n", Thread.currentThread().getName());
                Thread.sleep(TIME_EAT);
                System.out.format("%s вышел из ресторана!\n", Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}