
package demo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class MySQLDatabase {
    
private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    Scanner sc = null;

    void readData() {
        try {
            connect = ApiClient.getInstance();
            sc = new Scanner(System.in);

            preparedStatement = connect.prepareStatement("SELECT name,age,education FROM employee WHERE email = ?;");

            preparedStatement.setString(1, sc.nextLine());
            result = preparedStatement.executeQuery();

            while (result.next()) {
                System.out.println("name: " + result.getString("name"));
                System.out.println("age: " + result.getString("age"));
                System.out.println("education: " + result.getString("education"));
            }

        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            
        }

    }

}
