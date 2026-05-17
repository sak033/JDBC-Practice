import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BatchProcessingWithStatement {
    private static final String url="jdbc:mysql://localhost:3306/jdbc_demo";
    private static final String username="root";
    private static final String password="root123";

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Drivers");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection= DriverManager.getConnection(url, username, password );
            Statement statement=connection.createStatement();
            Scanner scanner=new Scanner(System.in);
            while(true){
                System.out.println("Enter name:");
                String name=scanner.next();
                System.out.println("Enter age:");
                int age=scanner.nextInt();
                System.out.println("Enter marks:");
                double marks=scanner.nextDouble();
                System.out.println("Enter more data(Y/N):");
                String choice=scanner.next();
                String query=String.format("INSERT INTO STUDENTS(NAME, AGE, MARKS) VALUES('%s',%o, %f)", name, age, marks);
                statement.addBatch(query);

                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int[] arr=statement.executeBatch();

            for(int i=0; i<arr.length; i++){
                if(arr[i]==0){
                    System.out.println("Query" +i+ " not executed!");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
