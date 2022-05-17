import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {

    private static final int COOKS_COUNT = 1;
    private Cook cook = new Cook();
    private Steward steward = new Steward(this);
    private final ExecutorService executor = Executors.newFixedThreadPool(COOKS_COUNT);

    public void work(Client client) {
        steward.work(client);
    }

    public Cook getCook() {
        return cook;
    }

    public void addOrder(Order order) {
        executor.execute(() -> cook.cook(order));
    }

    public void close() {
        executor.shutdown();
    }
}