package proyecto;

import java.text.DecimalFormat;
import java.util.Scanner;

public class InventoryTest {
    static DecimalFormat formatter = new DecimalFormat("$##,###.00");

	public static void main(String args[]) {
    	
    	  	// Crea algunos productos
               // Crea un art�culo de inventario para almacenar nuestros productos
		
	    
		Inventory myWishList = new Inventory();

        Product item1 = new Product(1, "Jacket", 3, 20);
        Product item2 = new Product(2, "Hackers (Blu Ray)", 10, 19);
        Product item3 = new Product(3, "BMW", 2, 45);

        myWishList.addProduct(item1);
        myWishList.addProduct(item2);
        myWishList.addProduct(item3);

        myWishList.printInventory();
        
        //System.out.println(myWishList.toString());
 
        // Crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        
        // Muestra el men� hasta que el usuario elija salir
        while (true) {
        	
		    
        	System.out.println("╔══════════════════════════════════════════╗");
        	System.out.println("║           JAVA FUNDAMENTALS              ║");
    	    System.out.println("║1. Añadir producto                        ║");
    	    System.out.println("║2. Calcular valor total del inventario    ║");
    	    System.out.println("║3. Imprimir inventario                    ║");
    	    System.out.println("║4. Explorar items                         ║");
    	    System.out.println("║5. Add CD al inventario                   ║");
    	    System.out.println("║6. Add DVD                                ║");
    	    System.out.println("║7. Exit                                   ║");
    	    System.out.println("║Elige una opción:                         ║");
    	    System.out.println("║                                          ║");
    	    System.out.println("╚══════════════════════════════════════════╝");
        	
            // Para revisar si el numero es un entero
    	    try {
    	    if (scanner.hasNextInt()) {
                int option = scanner.nextInt();

			switch (option) {
            	case 1:
                // A�adir producto
                System.out.print("Introduce el ID del producto que quieres añadir: ");
                int newId = scanner.nextInt();
                scanner.nextLine();  
                System.out.print("Introduce el nombre del producto: ");
                String name = scanner.nextLine();
                System.out.print("Introduce la cantidad de este producto: ");
                int quantity = scanner.nextInt();
                System.out.print("Introduce el precio del producto: ");
                double price = scanner.nextDouble();

                Product item4 = new Product(newId, name, quantity, price);
                myWishList.addProduct(item4);

                System.out.println("Producto añadido con Exito.");
                break;
            	case 2:
            		double totalValue = myWishList.calculateInventoryValue();
            		System.out.println("El valor total del inventario es " + formatter.format(totalValue));
            	break;	
            	 case 3:
                     // Imprimir productos
            		 
                     System.out.println(myWishList.toString());


                     break;

            	 case 4:
            		    // Explorar items
            	          		 
            		 
            		 System.out.print("Introduce el ID del producto que quieres explorar: ");
            		    int id = scanner.nextInt();

            		    Product product = myWishList.getProductById(id);
            		    if (product != null) {
            		    	 System.out.println(product.toString());
                        } else {
                           
            		        System.out.println("No se encontró ningún producto con ese ID.");
            		    }
            		    break;
            		    
            	 case 5:
                     // Add CD 
            		 System.out.print("Please enter the item number: ");
                     int newId1 = scanner.nextInt();
                     scanner.nextLine();
            		 System.out.print("Nombre del CD: ");
                     String name1 = scanner.nextLine();
                     System.out.print("Introduce la cantidad de este producto: ");
                     int quantity1 = scanner.nextInt();
                     System.out.print("Introduce el precio del producto: ");
                     double price1 = scanner.nextDouble();
                     
                     Product item5 = new Product(newId1, name1, quantity1, price1);
                     myWishList.addProduct(item5);
                     System.out.println("CD añadido!");
                     break;

                 case 6:
                     // Add DVD
                	 System.out.println("Please enter the item number: ");
                	 int dvdId = scanner.nextInt();
                	 scanner.nextLine();
                	 System.out.println("Nombre del  DVD : ");
                	 String dvdName = scanner.nextLine();
                	 System.out.println("Introduce la cantidad de este producto: ");
                	 int dvdQuantity = scanner.nextInt();
                	 System.out.println("Introduce el precio del producto: ");
                	 double dvdPrice = scanner.nextDouble();
                	 
                	 Product item6 = new Product(dvdId, dvdName, dvdQuantity, dvdPrice);
                     myWishList.addProduct(item6);
                	 System.out.println("DVD added successfully!");
                     break;
                 case 7:
                     // Salir del programa
                     System.out.println("Saliendo del programa.");
                     return;
                    

                 default:
                     System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
	        }
            }
    	    } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                scanner.nextLine();
                
            }
        }
	}
}

    


