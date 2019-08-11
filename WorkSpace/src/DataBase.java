import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.mysql.jdbc.PreparedStatement;
 
public class DataBase {
	
	
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/javareporting";
	static Connection conn = null;
	static java.sql.Statement stmt = null;
	static PreparedStatement preparedStatement;
	static String sql = "INSERT INTO filiere(nom, dep, nbre,chef_f)"+"VALUES (?, ?, ?, ?)";
	static String sql_ = "INSERT INTO etudiant(Nom,Prenom,Cne,MoyG,MoyN,Filiere)"+"VALUES (?, ?, ?, ?, ?, ?)";
    static String sql__="SELECT DISTINCT nom FROM filiere";
	// Database credentials
	static final String USER = "root";
 	public static void OpenConnexion()
 	{
	 try {
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(DB_URL, USER, "");

	    } catch(SQLException se) {
	        se.printStackTrace();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }  
	     
	  }
 	public static void CloseConnexion()
 	{
 		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}
 	static public void AjouterFiliere(String nom,String dep,int nbre,String chef) throws SQLException
 	{
 	    preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
 	    preparedStatement.setString(1, nom);
		preparedStatement.setString(2, dep);
		preparedStatement.setInt(3, nbre);
		preparedStatement.setString(4, chef);
 		preparedStatement.executeUpdate(); 
 	}
 	
 	
 	static public void AjouterEtudiant(String nom,String pre,String cne,float moyg,float moyn,String fil) throws SQLException
 	{
 		  preparedStatement = (PreparedStatement) 
 		    conn.prepareStatement(sql_);
 	 	    preparedStatement.setString(1, nom);
 			preparedStatement.setString(2, pre);
 			preparedStatement.setString(3, cne);
 			preparedStatement.setFloat(4, moyg);
 			preparedStatement.setFloat(5, moyn);
 			preparedStatement.setString(6, fil);
 	 		preparedStatement.executeUpdate();
 	}
 	static public void loadComboBox(JComboBox<String> cb)
 	{
 		try {

 	          // snipping off some more code
 	          //...
 			OpenConnexion();
 			stmt = conn.createStatement();  	          
 			ResultSet rs1 = stmt.executeQuery(sql__);
 
 	           while ((rs1.next()) ) {
 	            cb.addItem(rs1.getString(1));
  	           }

 	       }  catch (SQLException e) { 
 	            e.printStackTrace();
 	       }
 	}
 	
 	
 	 
 	
}

