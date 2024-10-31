
package code;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Constructor {
    String[] tableHeader = {"Item", "Quantity", "Amount"};
    
    DefaultListModel listModel = new DefaultListModel();
    DefaultTableModel tableModel = new DefaultTableModel(tableHeader, 0);
    String[] data;
    
    public String[] allOrders() {
        List<String> allOrders = new ArrayList<>();
        
        try {
            FileInputStream ordInfo = new FileInputStream("allOrders.txt");
            DataInputStream access = new DataInputStream(ordInfo);
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(access))) {
                String orderID;
                
                while((orderID = reader.readLine()) != null) {
                    allOrders.add(orderID);
                }
            }
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Order ID's are missing or not found.", "Critical Error!", 0);
        }
        
        String[] orders = new String[allOrders.size()];
        orders = allOrders.toArray(orders);
        
        return orders;
    }
    
    public String[] orderInfo(String ID) {
        String[] orders = allOrders();
        
        for(String a : orders) {
            if(a.substring(a.length() - 1).contains(ID)) {
                data = a.split(",");   
            }   
        }
        String[] orderDets = new String[data.length - 6];
        
        for(int index = 1; index < data.length - 5; index++) {
            orderDets[index - 1] = data[index];
        }
        
        return orderDets;
    }
    
    public String[] ordBasicInfo(String ID) {
        String[] orders = allOrders();
        
        for(String a : orders) {
            if(a.substring(a.length() - 1).contains(ID)) {
                data = a.split(",");
            }
        }
        String[] ordBasInfo = new String[4];
        ordBasInfo[0] = data[data.length - 5];
        ordBasInfo[1] = data[data.length - 4];
        ordBasInfo[2] = data[data.length - 3];
        ordBasInfo[3] = data[data.length - 2];
        
        return ordBasInfo;
    }
    public DefaultListModel orderID() {
        String[] orders = allOrders();
        String[] ordersFiltered = new String[orders.length];
        
        int index = 0;
        for(String recs : orders) {
            String[] orderID = recs.split(",");
            ordersFiltered[index] = orderID[orderID.length - 1];
            index++;
        }
        
        for(String a : ordersFiltered) {
            listModel.addElement(a);
        }
        
        return listModel;
    }
    
    public DefaultTableModel orderDetails(String ID) {
        String[] orderData;
        
        for(String a : orderInfo(ID)) {
            orderData = a.split("-");
            tableModel.addRow(orderData);
        }
        return tableModel;
    }  
}
