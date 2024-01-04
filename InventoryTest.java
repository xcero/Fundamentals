package proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


public class InventoryTest extends JFrame {
	  public static void main(String[] args) {
          // Crear un objeto de la clase SwingForm
          InventoryTest form = new InventoryTest();
          PrintStream printStream = new PrintStream(new CustomOutputStream(Textfield));

        	// Redirigir la salida estándar a nuestro PrintStream personalizado
        	System.setOut(printStream);
        	System.setErr(printStream); 
        	System.out.println("           JAVA FUNDAMENTALS              ");
  	    System.out.println("1. Anadir producto                        ");
  	    System.out.println("2. Calcular valor total del inventario    ");
  	    System.out.println("3. Imprimir inventario                    ");
  	    System.out.println("4. Explorar items                         ");
  	    System.out.println("5. Add CD al inventario                   ");
  	    System.out.println("6. Add DVD                                ");
  	    System.out.println("7. Codigo de Barra                        ");
  	    System.out.println("8. Exit                                   ");
  	    System.out.println("Elige una opcion:                         ");
  	  System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	     

      }
    // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);
    static DecimalFormat formatter = new DecimalFormat("$##,###.00");
    
    Inventory myWishList = new Inventory();

   
    //System.out.println(myWishList.toString());
    
    // Crear los componentes Swing que se mostrarán en el formulario
    JLabel titleLabel = new JLabel("FUNDAMENTOS JAVA ");
    JButton addButton = new JButton("1 Añadir producto");
    JButton totalButton = new JButton("2 Calcular valor total del inventario");
    JButton printButton = new JButton("3 Imprimir inventario");
    JButton exploreButton = new JButton("4 Explorar items");
    JButton cdButton = new JButton("5 Add CD al inventario");
    JButton dvdButton = new JButton("6 Add DVD");
    JButton barcodeButton = new JButton("7 Codigo de Barra");
    JButton exitButton = new JButton("8 Exit");
    JLabel optionLabel = new JLabel("Elige una opción:");
    JTextField optionField = new JTextField();
    JLabel titleLabel1 = new JLabel("Etiqueta de Consola");
    static JTextArea Textfield = new JTextArea();
    // Crear un constructor para inicializar el formulario y los componentes
    JScrollPane scrollPane = new JScrollPane(Textfield);
    public InventoryTest() {
        // Establecer el título, el tamaño y el comportamiento de cierre del formulario
    	
    	
    	
        setTitle("Inventario");
        setSize(800, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setAlwaysOnTop(true);

                // Crear un panel para contener los componentes
        JPanel panel = new JPanel();
        // Establecer el diseño del panel como nulo para poder posicionar los componentes manualmente
        panel.setLayout(null);

        // Establecer la fuente, el color y la posición del título
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setBounds(300, 50, 250, 50);
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel1.setForeground(Color.BLUE);
        titleLabel1.setBounds(300, 650, 250, 50);
        // Establecer el tamaño y la posición de los botones
        addButton.setBounds(100, 150, 250, 50);
        totalButton.setBounds(450, 150, 250, 50);
        printButton.setBounds(100, 250, 250, 50);
        exploreButton.setBounds(450, 250, 250, 50);
        cdButton.setBounds(100, 350, 250, 50);
        dvdButton.setBounds(450, 350, 250, 50);
        barcodeButton.setBounds(100, 450, 250, 50);
        exitButton.setBounds(450, 450, 250, 50);
        Textfield.setFont(new Font ("Arial", Font.PLAIN,18));
        Textfield.setBounds(150, 690, 550, 250);
        // Establecer la fuente y la posición de la etiqueta de opción
        optionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        optionLabel.setBounds(100, 550, 150, 50);

        // Establecer el tamaño y la posición del campo de opción
        optionField.setBounds(250, 550, 50, 30);

        // Añadir los componentes al panel
        panel.add(titleLabel);
        panel.add(addButton);
        panel.add(totalButton);
        panel.add(printButton);
        panel.add(exploreButton);
        panel.add(cdButton);
        panel.add(dvdButton);
        panel.add(barcodeButton);
        panel.add(exitButton);
        panel.add(optionLabel);
        panel.add(optionField);
        panel.add(titleLabel1);
        panel.add(Textfield);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Añadir el panel al formulario
        add(panel);

        // Hacer visible el formulario
        setVisible(true);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String numero = "1"; 
                optionField.setText(numero);
            }
        });
       
        totalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String numero = "2"; 
                optionField.setText(numero);
            }
        });
        
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String numero = "3"; 
                optionField.setText(numero);
            }
        });
        exploreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String numero = "4"; 
                optionField.setText(numero);
            }
        });
        cdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String numero = "5"; 
                optionField.setText(numero);
            }
        });
        dvdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String numero = "6"; 
                optionField.setText(numero);
            }
        });
        barcodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String numero = "7"; 
                optionField.setText(numero);
            }
        });

        // Añadir un ActionListener al botón de salida para terminar el programa
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });

        // Añadir un ActionListener al campo de opción para leer la entrada del usuario y ejecutar la opción correspondiente

        optionField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear un objeto Scanner para leer la entrada del usuario
                Scanner scanner = new Scanner(System.in);

                // Obtener el texto del campo de opción y convertirlo a un número entero
                String optionString = optionField.getText();
                int option1 = Integer.parseInt(optionString);
        	                      
                // Usar una instrucción switch para ejecutar el código según la opción elegida

                        switch (option1) {
                        
                        
            	case 1:
                // Añadir producto
                    System.out.println("Introduce el ID del producto que quieres añadir: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.println("Introduce el nombre del producto: ");
                    String name = scanner.nextLine();
                    System.out.println("Introduce la cantidad de este producto: ");
                    int quantity = scanner.nextInt();
                    double price = 0;
                    boolean validPrice = false;
                    while (!validPrice) {
                        try {
                            System.out.println("Introduce el precio del producto: ");
                            price = Double.parseDouble(scanner.next());
                            validPrice = true;
                        } catch (NumberFormatException e1) {
                            System.out.println("El precio debe ser un número decimal. Inténtalo de nuevo.");
                        }
                    }
                    Product item1 = new Product(newId, name, quantity, price);
                    myWishList.addProduct(item1);
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
            		    	 System.out.println(myWishList.getProductById(id));
                        } else {
                           
            		        System.out.println("No se encontró ningún producto con ese ID.");
            		    }
            		    break;
            		    
            	 case 5:
                     // Add CD 
            		 System.out.println("Introduce el ID del Item: ");
                     int newId1 = scanner.nextInt();
                     scanner.nextLine();
            		 System.out.println("Nombre del CD: ");
                     String name1 = scanner.nextLine();
                     System.out.println("Introduce la cantidad de este producto: ");
                     int quantity1 = scanner.nextInt();
                     double price1 = 0;
                     boolean validPrice1 = false;
                     while (!validPrice1) {
                         try {
                             System.out.println("Introduce el precio del producto: ");
                             price1 = Double.parseDouble(scanner.next());
                             validPrice1 = true;
                         } catch (NumberFormatException e1) {
                             System.out.println("El precio debe ser un número decimal. Inténtalo de nuevo.");
                         }
                     }
                     Product item2 = new Product(newId1, name1, quantity1, price1);
                     myWishList.addProduct(item2);
                     System.out.println("CD añadido!");
                     break;

                 case 6:
                     // Add DVD
                	 System.out.println("Por favor ingresar el ID del item: ");
                	 int dvdId = scanner.nextInt();
                	 scanner.nextLine();
                	 System.out.println("Nombre del  DVD : ");
                	 String dvdName = scanner.nextLine();
                	 System.out.println("Introduce la cantidad de este producto: ");
                	 int dvdQuantity = scanner.nextInt();
                	 double dvdprice = 0;
                     boolean validPrice11 = false;
                     while (!validPrice11) {
                         try {
                             System.out.println("Introduce el precio del producto: ");
                             dvdprice = Double.parseDouble(scanner.next());
                             validPrice11 = true;
                         } catch (NumberFormatException e1) {
                             System.out.println("El precio debe ser un número decimal. Inténtalo de nuevo.");
                         }
                     }
                	 
                	 Product item3 = new Product(dvdId, dvdName, dvdQuantity, dvdprice);
                     myWishList.addProduct(item3);
                	 System.out.println("DVD añadido!");
                     break;
                 case 7 :
                	 String codigo = Code128.codeIt("0 PruebaCode128 20");
                  	 System.out.println(codigo);
                  	 System.out.println("Copia y pegar en un Archivo para imprimir");
                  	
             		break;
                 case 8:
                     // Salir del programa
                     System.out.println("Saliendo del programa.");
                     System.exit(0);

                     return;
                    

                 default:
                     System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
                                     
               }
            	
                    
                
                    System.out.println("Por favor ingrese un numero para la opcion.");
                    scanner.nextLine();
                  
    }
                
          
  }); 
        
        
    }
    
}




  