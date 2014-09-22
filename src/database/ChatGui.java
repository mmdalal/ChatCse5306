/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

/**
 *
 * @author murtu_000
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author murtu_000
 */
public class ChatGui {
    JFrame frame;
    JLabel label;
    JPanel panel;
    JTextField textfield_user_name;
    JPasswordField passwordfield;
    
    void go (){
        frame = new JFrame("Chat Application");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel=new JPanel();
        frame.add(panel);
        
        panel.setLayout(null);
        JLabel userLabel = new JLabel("User Name:");
        userLabel.setBounds(20,20,80,25);
	panel.add(userLabel);
        
        textfield_user_name = new JTextField(20);
        textfield_user_name.setBounds(100, 20, 160, 25);
        panel.add(textfield_user_name);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 80, 25);
        panel.add(passwordLabel);
        
        passwordfield = new JPasswordField(20);
        passwordfield.setBounds(100, 60, 160, 25);
        panel.add(passwordfield);
        
        JButton login_button = new JButton("Login");
        login_button.setBounds(20, 100, 80, 30);
        panel.add(login_button);
        login_button.addActionListener(new DatabaseCheck()); 
        
        JButton new_user_button = new JButton("New User");
        new_user_button.setBounds(150, 100, 100, 30);
        panel.add(new_user_button);
        new_user_button.addActionListener(new NewUser());
        
        frame.setVisible(true);
    }

    private static class RegisterToDatabase implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }

       
    }

    public class DatabaseCheck implements ActionListener{
           String user;
           char password[];
        @Override
        public void actionPerformed(ActionEvent ae) {
            user = textfield_user_name.getText();
            password=passwordfield.getPassword();
            if ("".equals(user) || password.length == 0){
                JOptionPane.showMessageDialog(null,"Invalid User Name or Password","Alert",JOptionPane.ERROR_MESSAGE);
            }
            else{
            DbConnect connect;
               try {
                   connect = new DbConnect();
                   connect.getData(user, password);
               } catch (SQLException ex) {
                   Logger.getLogger(ChatGui.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }
    }
    
    private class NewUser implements ActionListener{
        JFrame frame1;    
        JPanel panel1;
        @Override
        public void actionPerformed(ActionEvent ae) {
        
        frame1 = new JFrame("Register Me");
        frame1.setSize(300,300);
        panel1=new JPanel();
        frame1.add(panel1);
        frame1.setVisible(true);
        
        panel1.setLayout(null);
        JLabel userLabel1 = new JLabel("User Name:");
        userLabel1.setBounds(20,20,80,25);
	panel1.add(userLabel1);
        
        JTextField textfield1 = new JTextField(20);
        textfield1.setBounds(100, 20, 160, 25);
        panel1.add(textfield1);
        
        JLabel passwordLabel1 = new JLabel("Password:");
        passwordLabel1.setBounds(20, 60, 80, 25);
        panel1.add(passwordLabel1);
        
        JPasswordField passwordfield1 = new JPasswordField(20);
        passwordfield1.setBounds(100, 60, 160, 25);
        panel1.add(passwordfield1);
        
        JLabel passwordLabel2 = new JLabel("Re-Password:");
        passwordLabel2.setBounds(20, 100, 80, 25);
        panel1.add(passwordLabel2);
        
        JPasswordField passwordfield2 = new JPasswordField(20);
        passwordfield2.setBounds(100, 100, 160, 25);
        panel1.add(passwordfield2);
        
        JButton register_button = new JButton("Register ME");
        register_button.setBounds(50, 100, 30, 30);
        panel.add(register_button);
        register_button.addActionListener(new RegisterToDatabase());
        
        String name_for_register=textfield1.getText();
        char [] pass_for_register =passwordfield1.getPassword();
        char [] re_enter_pass_register=passwordfield2.getPassword();
        
//        if(!pass_for_register.equals(re_enter_pass_register)){
//            JOptionPane.showMessageDialog(null,"Password don't match -Re-enter");
//        }
        }   
    }
}
