package code;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.FileWriter;


public class Login {
    
    public String[] LoginInfo() {
        List<String> tempCreds = new ArrayList<>();
        
        try {
            FileInputStream file = new FileInputStream("creds.csv");
            DataInputStream access = new DataInputStream(file);
            try (BufferedReader read = new BufferedReader(new InputStreamReader(access))) {
                String info;
                
                while((info = read.readLine()) != null) {
                    tempCreds.add(info);
                }
            }
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Check if all the files required are present!", "Creds file not found", 0);
        }
        
        String[] creds = new String[tempCreds.size()];
        creds = tempCreds.toArray(creds);
        
        return creds;
    }
    
    public void credsAdd(String[] reg) {
        try {
            try(FileWriter newReg = new FileWriter("creds.csv")) {
                for(String a : reg) {
                    newReg.write(a + "\n");
                }
            }
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "The master credential file is missing or corrupted.", "Critical System Error", 0);
        }
    }
    
    public void activeCreds(String info) {
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
        
        tempInfo[0] = info;
        
        try {
            try(FileWriter active = new FileWriter("user.txt")) {
                for(String a : tempInfo) {
                    active.write(a + "\n");
                }
            }
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "The current profile could not be set!", "Critical System Error", 0);
        }
    }
}
