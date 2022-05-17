public class Main {

    private static final int CLIENTS = 5;
    private static final long TIMEOUT = 1000;

    public static void main(String[] args) {
        final Restaurant restaurant = new Restaurant();
        for (int i = 1; i <= CLIENTS; i++) {
            Client client = new Client();
            new Thread(null, client::goToRestaurant, String.format("Клиент %d", i)).start();
            new Thread(null, () -> restaurant.work(client)).start();
            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        restaurant.close();
    }
}