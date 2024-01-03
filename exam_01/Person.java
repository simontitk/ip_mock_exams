public class Person {

    private String name;
    private String idNumber;

    public Person(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Id number: " + this.idNumber.substring(0, 6) + "XXXX";
    }
   
}
