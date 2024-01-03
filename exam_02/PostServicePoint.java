import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PostServicePoint {

    private Item[] registeredItems;
    private List<Item> processedItems;
    private int maxWeight;
    private int count;


    public PostServicePoint(int maxWeight) {
        this.registeredItems = new Item[10];
        this.processedItems = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.count = 0;
    }


    public void register(Item item) {
        if (this.count > 9) {
            System.out.println("no available capacity!");
        } 
        else {
            this.registeredItems[this.count] = item;
            this.count++;
        }
    }


    public boolean checkItemAddress(String adr) {
        return adr.length() < 20;
    }


    public boolean checkItemWeight(int wgh) {
        return wgh < this.maxWeight;
    }


    public void printPrice(int i) {
        try {
            int price = (int)Math.ceil((double)this.registeredItems[i].getWeight() / (double)2) * 12;
            System.out.println("The price for sending is: " + price);    
        } 
        catch (Exception e) {}
    }


    public void printAllPrices() {
        for (int i = 0; i < this.count; i++) {
            this.printPrice(i);            
        }
    }

    // if both the address and the weight are incorrect, it prints both error messages. 
    // perhaps this is not the expected behaviour, but it made more sense this way
    public void processOne() {
        Item itemToProcess = this.registeredItems[this.count-1];
        boolean valid = true;

        if (!this.checkItemAddress(itemToProcess.getAddress())) {
            valid = false;
            System.out.println("invalid address!");
        }

        if (!this.checkItemWeight(itemToProcess.getWeight())) {
            valid = false;
            System.out.println("invalid weight!");
        }

        if (valid) {
            this.processedItems.add(itemToProcess);
        }

        this.registeredItems[this.count-1] = null;
        this.count--;
    }


    public void processAll() {
        while (this.count != 0) {
            this.processOne();            
        }
    }


    public int totalweight() {
        return this.processedItems.stream()
            .mapToInt(Item::getWeight)
            .sum();
    }


    public Map<String,Integer> checkCategories() {
        return this.processedItems.stream()
            .collect(Collectors.toMap(Item::getCategory, item -> 1, Integer::sum));
    }


    public void removeCategory(String c) {
        this.processedItems = this.processedItems.stream()
            .filter(item -> !c.equals(item.getCategory()))
            .collect(Collectors.toList());
    }  
    
}
