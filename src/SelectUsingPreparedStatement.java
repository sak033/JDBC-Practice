import java.sql.*;

public class SelectUsingPreparedStatement
{
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
            String q="SELECT MARKS FROM STUDENTS WHERE ID=?"; //general query
            PreparedStatement preparedStatement=connection.prepareStatement(q); //compilation

            //adding parameters
            preparedStatement.setDouble(1,1);

            //Output of SELECT is Resultset
            ResultSet resultSet=preparedStatement.executeQuery();

            //Resultset have method resultSet.next() gives index---in boolean value

            if(resultSet.next()){
                Double marks=resultSet.getDouble("MARKS");
                System.out.println("Marks:" +marks);
            }
            else {
                System.out.println("Marks not found");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
