package proyecto;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;

public class InventoryTestGUI {
    static DecimalFormat formatter = new DecimalFormat("$##,###.00");

    public static void main(String args[]) {
        // Crear el inventario y agregar algunos productos iniciales
        Inventory myWishList = new Inventory();
        myWishList.addProduct(new Product(0, "Jacket", 3, 20));
        myWishList.addProduct(new Product(1, "Hackers (Blu Ray)", 10, 19));
        myWishList.addProduct(new Product(2, "BMW", 2, 45));

        // Crear la ventana principal (JFrame)
        JFrame frame = new JFrame("Gestión de Inventario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Crear el área de texto para mostrar la salida
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Crear panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 10, 10));

        // Botón: Añadir producto
        JButton addProductButton = new JButton("Añadir Producto");
        addProductButton.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog("Introduce el ID del producto:");
                String name = JOptionPane.showInputDialog("Introduce el nombre del producto:");
                String quantityStr = JOptionPane.showInputDialog("Introduce la cantidad:");
                String priceStr = JOptionPane.showInputDialog("Introduce el precio:");

                int newId = Integer.parseInt(idStr);
                int quantity = Integer.parseInt(quantityStr);
                double price = Double.parseDouble(priceStr);

                Product newProduct = new Product(newId, name, quantity, price);
                myWishList.addProduct(newProduct);
                outputArea.append("Producto añadido: " + newProduct + "\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Entrada inválida. Por favor ingresa datos correctos.");
            }
        });

        // Botón: Calcular valor total del inventario
        JButton calculateValueButton = new JButton("Calcular Valor Total");
        calculateValueButton.addActionListener(e -> {
            double totalValue = myWishList.calculateInventoryValue();
            outputArea.append("Valor total del inventario: " + formatter.format(totalValue) + "\n");
        });

        // Botón: Imprimir inventario
        JButton printInventoryButton = new JButton("Imprimir Inventario");
        printInventoryButton.addActionListener(e -> {
            outputArea.append("Inventario Actual:\n" + myWishList + "\n");
        });

        // Botón: Generar archivo de códigos de barras
        JButton generateBarcodeFileButton = new JButton("Generar Archivo Códigos de Barra");
        generateBarcodeFileButton.addActionListener(e -> {
            try {
                // Crear archivo DOC
                File file = new File("codigo_barras.doc");
                FileWriter writer = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                // Escribir solo los códigos de barras
                for (Product product : myWishList.getAllProducts()) {
                    String barcode = Code128.codeIt(String.valueOf(product.getId())); // Solo el ID para el código de barras
                    bufferedWriter.write(barcode + "\n");
                }

                bufferedWriter.close();
                outputArea.append("Archivo 'codigo_barras.doc' creado con éxito.\n");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al crear el archivo.");
            }
        });

        // Botón: Salir
        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(e -> System.exit(0));

        // Agregar botones al panel
        buttonPanel.add(addProductButton);
        buttonPanel.add(calculateValueButton);
        buttonPanel.add(printInventoryButton);
        buttonPanel.add(generateBarcodeFileButton); // Botón para generar archivo con códigos de barras
        buttonPanel.add(exitButton);

        // Agregar elementos al frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
