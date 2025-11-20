import java.sql.*;

public class DBConnect {

    public static void insertStudent(String name, String father, int age, 
                                     String roll, String dept, String course,
                                     String gender, String address, String phone) {

        try {
            // LOAD DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");
            // CONNECTION
            String url="jdbc:mysql://localhost:3306/studentdb";
            String user="root";
            String password="1234";
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO students (name, father_name, age, roll_no, department, course, gender, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);
            pst.setString(2, father);
            pst.setInt(3, age);
            pst.setString(4, roll);
            pst.setString(5, dept);
            pst.setString(6, course);
            pst.setString(7, gender);
            pst.setString(8, address);
            pst.setString(9, phone);

            pst.executeUpdate();
            pst.close();
            con.close();

            System.out.println("Data inserted successfully!");

        } catch (Exception e) {
            System.out.println("Error while inserting: " + e.getMessage());
        }
    }
}
