
package code;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.JOptionPane;

public class Order {
    public void orderInfo(String[] order) {
        try {
            try(FileWriter newOrder = new FileWriter("tempOrder.txt")) {
                for(String a : order) {
                    String replaced = a.replace("[", "");
                    String replaced1 = replaced.replace("]", "");
                    String replacedFinal = replaced1.replace(",", "-");
                    newOrder.write(replacedFinal + ",");
                }
            }
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "The order could not be set.", "Order Errer", 0);
        }
    }
    
    public String profile() {
        File user = new File("user.txt");
        try {
           Scanner creds = new Scanner(user);
           while(creds.hasNextLine()) {
               String current = creds.nextLine();
               return current;
           }
        }
        catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Profile is not registered.", "User Error!", 0);
        }
        
        return "NULL";
    }
    
    public String orderDetails() {
        File tempOrder = new File("tempOrder.txt");
        try {
            Scanner ordReader = new Scanner(tempOrder);
            while(ordReader.hasNextLine()) {
                String order = ordReader.nextLine();
                return order;
            }
        }
        catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "The order was not set properly.", "System Error!", 0);
        }
        
        return "NULL";
    }
    
    public void confirmedOrder(String fullOrder) {
        String[] tempInfo = new String[2];
        try {
            FileInputStream userFile = new FileInputStream("user.txt");
            DataInputStream access = new DataInputStream(userFile);
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(access))) {
                String line;
                int index = 0;
                
                while((line = reader.readLine()) != null) {
                    tempInfo[index] = line;
                    index++;
                }
            }
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "The order ID could not be properly initialized.", "System Error!", 0);
        }
        
        String orderNum = tempInfo[1];
        Integer orderID = Integer.parseInt(orderNum);
        orderID++;
        
        tempInfo[1] = orderID.toString();
        
        try {
            try(FileWriter rewrite = new FileWriter("user.txt")) {
                for(String a : tempInfo) {
                    rewrite.write(a + "\n");
                }
            } 
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "The order ID could not be properly initialized.", "System Error!", 0);
        }
        
        try {
            Files.write(Paths.get("allOrders.txt"), (fullOrder + "," + orderID + "\n").getBytes(), StandardOpenOption.APPEND);
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Please check if the program has its necessary files!", "File Not Found", 0);
        }
    } 
}
