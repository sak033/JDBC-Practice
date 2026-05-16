import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

    private static final String url="jdbc:mysql://localhost:3306/jdbc_demo" ;
    private static final String username="root";
    private static final String password="root123";
    public static void main(String[] args){

        //load Drivers
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //Create connection
        try{
            Connection connection=DriverManager.getConnection(url,username, password);
            Statement statement=connection.createStatement();
            String query=String.format("UPDATE STUDENTS SET MARKS=%f WHERE ID=%o", 98.5,2);
            int rowsAffected=statement.executeUpdate(query);

            if(rowsAffected>0){
                System.out.println("Updated Succesfully!");
            }
            else{
                System.out.println("Update failed");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
