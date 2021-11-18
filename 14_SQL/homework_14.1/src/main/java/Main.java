import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, subscription_date FROM purchaseList " +
                    "WHERE course_name = \"Веб-разработчик c 0 до PRO\" "  +
                    "ORDER BY subscription_date");
            int count = 0;
            List<Integer> months = new ArrayList<>();
            while (resultSet.next()){
                String set = resultSet.getNString("course_name");
                Date set1 = resultSet.getDate("subscription_date");
                String date = set1.toString();
                String date1 = date.substring(5, 7);
                int date2 = Integer.parseInt(date1);
                months.add(date2);
                System.out.println(set + " : " + set1);
                count++;
            }
            float totalMonth = months.get(months.size() - 1) - months.get(0);
            System.out.println(count / totalMonth);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
