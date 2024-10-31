
package gui;

import code.Login;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.io.IOException;

public class Credentials extends javax.swing.JFrame {

    String username, pass;
    int check;
    
    Login login = new Login();
    /**
     * Creates new form Credentials
     */
    public Credentials() {
        initComponents();
        
        btnLogin.setEnabled(false);
        btnReg.setEnabled(false);
        
        uname.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                enabler();
            }
            public void removeUpdate(DocumentEvent e) {
                enabler();
            }
            public void insertUpdate(DocumentEvent e) {
                enabler();
            }
        });
        
        jPasswordField1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                enabler();
            }
            public void removeUpdate(DocumentEvent e) {
                enabler();
            }
            public void insertUpdate(DocumentEvent e) {
                enabler();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.

     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabelUsername = new javax.swing.JLabel();
        jLablePass = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnReg = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelUsername.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelUsername.setText("Username:");

        jLablePass.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLablePass.setText("Password:");

        uname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPasswordField1.setToolTipText("");

        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin.setText("LOGIN >>");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnReg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReg.setText("REGISTER");
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        title.setText("Spiderman Online Food Services");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelUsername)
                                .addComponent(jLablePass))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(logo)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(uname)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReg)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(logo))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLablePass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnReg))
                .addGap(20, 20, 20))
        );

        pack();
    }
    
    public void enabler() {
        if((uname.getText().equals("")) || (new String(jPasswordField1.getPassword()).equals(""))) {
            btnLogin.setEnabled(false);
            btnReg.setEnabled(false);
        }
        else {
            btnLogin.setEnabled(true);
            btnReg.setEnabled(true);
        }
    }
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        username = uname.getText();
        pass = new String(jPasswordField1.getPassword());
        
        if(username.equals("Admin") && (pass.equals("admin1234"))) {
            ViewOrders view = new ViewOrders();
            view.setVisible(true);
            this.dispose();
        }
        else {
            String[] allCreds = login.LoginInfo();
            String[] temp;

            check = 0;
            for(String a : allCreds) {
                temp = a.split(",");
                if(temp[0].equals(username)) {
                    check = 1;
                    if(temp[1].equals(pass)) {
                        check = 2;
                        break;
                    }
                }
            }

            if(check == 1) {
                JOptionPane.showMessageDialog(null, "Incorrect Password. Re-ener Password!", "Invalid Login", 1);
            }
            else if(check == 2) {
                FoodMenu food = new FoodMenu();
                try {
                    food.createAndShowGUI();
                    food.setVisible(true);
                    login.activeCreds(username);
                } 
                catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Login information incorrect or account does not exist. Try again or Register!", "Invalid Login", 1);
            }
        }
                  
    }

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {
        username = uname.getText();
        pass = new String(jPasswordField1.getPassword());
        
        String[] allCreds = login.LoginInfo();
        String[] temp;
        
        check = 0;
        for(String a : allCreds) {
            temp = a.split(",");
            if(temp[0].equals(username)) {
                check = 1;
                break;
            }
        }
        if(check == 0) {
            String register = (username + "," + pass);
            String[] newCreds = new String[allCreds.length + 1];
            int i = 0;
            for(String a : allCreds) {
                newCreds[i] = a;
                i++;
            }
            newCreds[i] = register;
            login.credsAdd(newCreds);
                
            JOptionPane.showMessageDialog(null, "Your Account has been registered!.", "Welcome to Spiderman Online Food Services", 1);
            
            FoodMenu food = new FoodMenu();
            try {
                food.createAndShowGUI();
                food.setVisible(true);
            } 
            catch (IOException e1) {
                e1.printStackTrace();
            }
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "The username already exists. Please Login!", "Invalid Register", 0);
        }
    }

    public void creds(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Credentials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Credentials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Credentials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Credentials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Credentials().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnReg;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLablePass;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel title;
    private javax.swing.JTextField uname;
    
}
