public class Steward {

    private Restaurant restaurant;

    public Steward(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void work(Client client) {
        try {
            synchronized (client) {
                client.wait();
                System.out.println("Официант принимает заказ!");
                orderToCook(new Order(""));
                System.out.println("Официант несет еду!");
                client.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void orderToCook(Order order) {
        synchronized (order) {
            try {
                restaurant.addOrder(order);
                order.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}