package calcolatrice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Database {

    private Connection conn;
    String db;

    public Database(String name){
        db="jdbc:mysql://localhost:3306/" + name;
    }

    //Metodo Connect che ritorna true se la connessione avviene con successo
    public boolean Connect(){
        String username="root";
        String password="";
        try{
            conn=DriverManager.getConnection(db, username, password);
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(conn!=null){
            return true;
        }
        return false;
    }

    //Metodo per controllare se il login è valido
    public boolean UserExists(String username, String password) {
        try {
            if (!conn.isValid(5)) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM login WHERE username = ? AND password = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if(!rs.isBeforeFirst()){
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //Metodo per mostrare la cronologia di un dato utente
    public StringBuilder SelectFromCronologia(String username){
        StringBuilder output = new StringBuilder("");

        try {
            if (!conn.isValid(5)) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM cronologia WHERE username = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                output.append(rs.getString("espressione"));
                output.append(" = ");
                output.append(rs.getString("risultato"));
                output.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    //Metodo per inserire nuovi utenti
    public boolean InsertUser(String username, String password) {
        try {
            if (!conn.isValid(5)) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO login(username, password) VALUES(?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
           return false;
        }
        return true;
    }

    //Metodo per inserire espressioni nella cronologia
    public boolean InsertExpression(String username, String expression, int result, int id) {
        try {
            if (!conn.isValid(5)) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO cronologia(espressione, risultato, username) VALUES(?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, expression);
            statement.setInt(2, result);
            statement.setString(3, username);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
