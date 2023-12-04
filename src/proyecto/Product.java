package proyecto;
public class Product {
    // Variables privadas
    private String name;
    private int quantity;  // Cambia esto a un array
    private double price;
    private int productid = 0;
    private int id;

        public Product(int id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        	public String toString() {
        	    return "Numero de Item  : " + getId() + "\n" +
        	           "Nombre : " + getName() + "\n" +
        	           "Cantidad in stock: " + getQuantity() + "\n" +
        	           "Precio : " + getPrice() + "\n" +
        	           "Valor Stock : " + calculateInventoryValue() + "\n" ;
        	}
        
   
    // Establece la cantidad en mano y si es negativa, se establece por defecto a cero.
//   public void setQuantityOnHand(int[] quantityOnHand) {
//        for (int i = 0; i < quantityOnHand.length; i++) {
//            if (quantityOnHand[i] > 0) {
//                quantity[i] = quantityOnHand[i];
//            }
//           else { quantity[i] = 0; }
//        }
//    }

    	public double calculateInventoryValue() {
    	    return quantity * price;
    	}
			

	public String getQuantityOnHand() {
        // TODO Auto-generated method stub
        return null;
    }  
	public int getProductId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
