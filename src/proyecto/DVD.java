package proyecto;

public class DVD extends Product {


    public DVD(int id, String name, int quantity, double price) {
        super(id, name, quantity, price);
      
    }
 
    public double calculateInventoryValue() {
        double value = super.calculateInventoryValue();
        value += value * 0.05;
        return value;
    }
}