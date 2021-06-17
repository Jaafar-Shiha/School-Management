package main.db;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//This class will be used as the low-level interface with the database
public class BasicDB 
{
    /**
     * Represents the MySQL driver name.
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    /**
     * Represents the URL of the database which the application will connect to.
     */
    private static final String DATABASE_URL = "jdbc:mysql://localhost/library";
    
    /**
     * Represents the username of the database account.
     */
    private static final String DATABASE_USER = "root";
    
    /**
     * Represents the password of the database account.
     */
    private static final String DATABASE_PASSWORD = "";
    
    /**
     * Represents the connection object that will be used to initialize a new 
     * database session.
     */
    private static Connection connection = null;
    
    //Functionality
    /**
     * Returns a connection/session to/with a database in MySQL database server.
     * @return 
     */
    public static void connect()
    {
        //Create the connection with mysql server 
        try
        {
            //Register the driver
            Class.forName( DRIVER );
            
            //Initilaise the connection
            connection = DriverManager.getConnection( DATABASE_URL, 
                                                      DATABASE_USER, 
                                                      DATABASE_PASSWORD );
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Closes the connection with the database server.
     */
    public static void disconnect()
    {
        try
        {
            connection.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    /**
     * Call a specific Stored Procedure in the database.
     * @param query
     * @return 
     */
    public static ResultSet call( String query )
    {
        //First connect to the database server
        connect();
        
        try
        {
            //Create the Statement object
            CallableStatement callableStatement = connection.prepareCall( query );
			
            callableStatement.execute();
			
//            ResultSet resultSet = callableStatement.getResultSet();
            
            //Execute the query
            CachedRowSetImpl result = new CachedRowSetImpl();
            
            //Save the result as a cached result 
            result.populate( callableStatement.getResultSet() );
			
            //Close the connection
            disconnect();
            
            return result;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Call a specific Stored Procedure in the database.
     * @param query
     * @return 
     */
    public static void callVoid( String query )
    {
        //First connect to the database server
        connect();
        
        try
        {
            //Create the Statement object
            CallableStatement callableStatement = connection.prepareCall( query );
			
            callableStatement.execute();
			
            //Close the connection
            disconnect();
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
