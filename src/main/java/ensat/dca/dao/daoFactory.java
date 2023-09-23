package ensat.dca.dao;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class daoFactory {
    private static Connection connexion = null;
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/gesetudiants" ;
    private static final String user="root" ;
    private static final String password="" ;
    private static void seConnecter()
    {
        try {
            System.out.println("Start of Connection, Loading Driver ... ");
            Class.forName(driver);
            System.out.println(" Driver upload successful");
            connexion= DriverManager.getConnection(url,user,password);
            System.out.println("Connection established .. ");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Driver loading problem");
        }
        catch(SQLException ex)
        {
            System.out.println("Connection problem URL Login or Password incorrect, Connection Failure !!!");
        }
    }
    public static Connection getConnection(){
        if(connexion == null)
            seConnecter();
        return connexion;
    }
}
