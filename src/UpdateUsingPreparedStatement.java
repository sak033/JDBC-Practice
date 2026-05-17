import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CancellationException;

public class UpdateUsingPreparedStatement {
    private static final String url="jdbc:mysql://localhost:3306/jdbc_demo";
    private static final String username="root";
    private static final String password="root123";

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection= DriverManager.getConnection(url, username, password);
            String q="UPDATE STUDENTS SET MARKS=? WHERE ID=? ";
            PreparedStatement preparedStatement=connection.prepareStatement(q);
            preparedStatement.setDouble(1,45);
            preparedStatement.setInt(2, 3);

            int rowsAffected=preparedStatement.executeUpdate();

            if(rowsAffected>0){
                System.out.println("Marks updated sussecfully!");
            }
            else {
                System.out.println("Not Updated");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
