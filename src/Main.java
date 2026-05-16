import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String url="jdbc:mysql://localhost:3306/jdbc_demo";
    private static final String username="root";
    private static final String password="root123";
    //Load Driver
    public static void main(String[] args){

        //Load drivers
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //make Connection
        try{
            Connection connection= DriverManager.getConnection(url, username, password);
            Statement statement =connection.createStatement();
            String query="select * from students";
            ResultSet resultSet=statement.executeQuery(query);

            //Print values that are stored In resultSet---whole table store in resultSet
           while(resultSet.next()){
               int id=resultSet.getInt("id");
               String name=resultSet.getString("name");
               int age=resultSet.getInt("age");
               double marks=resultSet.getDouble("marks");

               System.out.println("ID:" +id);
               System.out.println("NAME:"+name);
               System.out.println("AGE:"+age);
               System.out.println("MARKS:"+marks);

           }



        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}