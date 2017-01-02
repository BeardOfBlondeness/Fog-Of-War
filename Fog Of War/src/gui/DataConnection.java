package gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DataConnection {
	
	 static String dbFile = "data/data.db";
	private static Connection connection = null;
	
	
	  public DataConnection()
	    {
		 

			
	        try             // There are many things that can go wrong in establishing a database connection...
	        {         
	            Class.forName("org.sqlite.JDBC");                               // ... a missing driver class ...
	            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile); // ... or an error with the file.
	            System.out.println("Database connection successfully established.");
	        } 
	        catch (ClassNotFoundException cnfex)    // Catch any database driver error
	        {
	            System.out.println("Class not found exception: " + cnfex.getMessage());
	        }
	        catch (SQLException exception)          // Catch any database file errors.
	        {                        
	            System.out.println("Database connection error: " + exception.getMessage());
	        }

	    }
	  
	  
	  public static ResultSet SQLSELECTQuery(String SQL){
	        try {
	            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
	            PreparedStatement stmt = null;
	            stmt = connection.prepareStatement(SQL);
	            ResultSet rs = stmt.executeQuery();
	            return rs;
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return null;
	        }
	    }
	  
	    public static void executeUpdate(String SQLUpdate)
	    {               
	        try {            
	        	connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
	            PreparedStatement statement = null;
	        	statement = connection.prepareStatement(SQLUpdate);
	            statement.executeUpdate();
	        	
	        }
	        catch (SQLException queryexception) 
	        {
	            System.out.println("Database update error: " + queryexception.getMessage());
	        }
	    }
}
