import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ServiceCenter {

    private List<Car> serviceQueue;
    private  Map<String, Integer> carsPriority;
    private int gasPrice;


    public ServiceCenter(int gasPrice) {
        this.gasPrice = gasPrice;
        this.serviceQueue = new ArrayList<>();
        this.carsPriority = new HashMap<>();
    }

    
    public void addToServiceQueue(Car c) {
        if (this.carsPriority.containsKey(c.getPlate())) {
            this.serviceQueue.add(c);
        }
        else {
            System.out.println("Car " + c.getPlate() + " not found");
        }
    }


    public int fillGas(Car c) {
        int gasRequired = c.getTankCapacity() - c.getGasLevel();
        c.fillTank(gasRequired);
        return gasRequired * this.gasPrice;
    }


    public void updatePriority(Car c, int p) {
        this.carsPriority.put(c.getPlate(), p);
    }


    public void serviceCar(Car c) {
        int price = this.fillGas(c);
        if (c.needsService()) {
            c.service();
            price += 500;
        }
        System.out.println("Car " + c.getPlate() + " serviced for " + price + " dollars");
    }


    public void serviceAll() {
       Iterator<Car> iter = this.serviceQueue.iterator();
        while (iter.hasNext()) {
            serviceCar(iter.next());
            iter.remove();
       }    
    }


    public int findHighestPriority() {
        int maxPriority = this.carsPriority.values().stream()
            .max(Comparator.naturalOrder())
            .orElse(0);

        for (int i = 0; i < this.serviceQueue.size(); i++) {
            if (this.carsPriority.get(this.serviceQueue.get(i).getPlate()) == maxPriority) {
                return i;
            }
        }
        return -1;
    }


    public void serviceAllWithPriority() {
        Collections.sort(this.serviceQueue, Comparator.comparingInt(car -> this.carsPriority.get(((Car) car).getPlate())).reversed());
        this.serviceAll();
    }

}
