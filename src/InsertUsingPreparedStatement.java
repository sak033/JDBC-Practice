import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsingPreparedStatement {

   private static final String url="jdbc:mysql://localhost:3306/jdbc_demo";
   private static final String username="root";
   private static final String password="root123";
    public  static void main(String[] args){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection= DriverManager.getConnection(url, username, password);
            String query="INSERT INTO STUDENTS(NAME, AGE, MARKS) VALUES(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,"Prachi");
            preparedStatement.setInt(2, 24);
            preparedStatement.setDouble(3,45.5);
            int rowsAffected=preparedStatement.executeUpdate();

            if(rowsAffected>0){
                System.out.println("Inserted!");
            }
            else{
                System.out.println("not Inserted!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
