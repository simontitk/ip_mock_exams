public class Item {

    private String category;
    private String address;
    private int weight;


    public Item(String category, String address, int weight) {
        this.category = category;
        this.address = address;
        this.weight = weight;
    }


    public String getCategory() {
        return this.category;
    }


    public String getAddress() {
        return this.address;
    }

    
    public int getWeight() {
        return this.weight;
    }
   
}
