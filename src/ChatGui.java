
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    public static void main (String args[]){
        ChatGui gui = new ChatGui();
        gui.go();
    }
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
        
        JTextField textfield = new JTextField(20);
        textfield.setBounds(100, 20, 160, 25);
        panel.add(textfield);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 80, 25);
        panel.add(passwordLabel);
        
        JPasswordField passwordfield = new JPasswordField(20);
        passwordfield.setBounds(100, 60, 160, 25);
        panel.add(passwordfield);
        
        JButton login_button = new JButton("Login");
        login_button.setBounds(20, 100, 80, 30);
        panel.add(login_button);
        login_button.addActionListener(new ColorListner()); 
        
        JButton register_me_button = new JButton("New User");
        register_me_button.setBounds(150, 100, 100, 30);
        panel.add(register_me_button);
        
        frame.setVisible(true);
    }

    private class ColorListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.repaint();
        }
    }
}
