import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    private static final String url="jdbc:mysql://localhost:3306/jdbc_demo";
    private static final String userName="root";
    private static final String password="root123";
    public static void main(String[] args){
        //Load Drivers
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //Create Connection
        try{
            Connection connection= DriverManager.getConnection(url,userName, password);
            Statement statement=connection.createStatement();
            String query=String.format("INSERT INTO STUDENTS(name, age, marks) VALUES('%s',%o, %f )", "Rahul", 22, 67.4);
            //this query will not return table, it gives no. of rows affected so store no. of rows in int variable
            int rowsAffected=statement.executeUpdate(query);

            //if rowsAffeted > 0 then data inserted succesfully else not
            if(rowsAffected>0){
                System.out.println("Data inserted succesfully!");
            }
            else{
                System.out.println("Data not Inserted");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
