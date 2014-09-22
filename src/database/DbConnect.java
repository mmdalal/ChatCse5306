/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author murtu_000
 */
public class DbConnect {
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/test";
    public DbConnect() throws SQLException{
        try {
            Class.forName(JDBC_DRIVER);
            cn = DriverManager.getConnection(JDBC_URL);
            st = cn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getData(String name_pass,char[] passwords_pass){
        String char_to_string = new String(passwords_pass);
        String sql =String.format("SELECT name,passwords FROM persons WHERE name = '%s' and passwords ='%s'",name_pass, char_to_string);
        try {
            rs=st.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("name");
                String password = rs.getString("passwords");
                    if(name.equals(name_pass) && password.equals(char_to_string)){
                        // After login-- all the chat code here
                        JOptionPane.showMessageDialog(null,"You're Connected!");
                    }
            }
             cn.close();
             rs.close();
             st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
