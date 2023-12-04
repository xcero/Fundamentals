package proyecto;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
	public List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }



 


    // Ahora a�ade los art�culos que hemos declarado anteriormente.
    
	public void printInventory() {
		// TODO Auto-generated method stub
		
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null ;
	}

	public void addProduct(CD newCD) {
		// TODO Auto-generated method stub
		
	}

	public double calculateInventoryValue() {
	    double totalValue = 0;
	    for (Product product : products) {
	        totalValue += product.calculateInventoryValue();
	    }
	    return totalValue;
	}

    // ... other methods as needed ...
}

