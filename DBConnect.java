import java.sql.*;

public class DBConnect {

    public static void insertStudent(String name, String father, int age, 
                                     String roll, String dept, String course,
                                     String gender, String address, String phone) {

        try {
            // LOAD DRIVER9
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
    public static ResultSet readStudents() {
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentdb", "root", "1234");

        String query = "SELECT * FROM students";
        PreparedStatement pst = con.prepareStatement(query);
        rs = pst.executeQuery();

    } catch (Exception e) {
        System.out.println("Read Error: " + e.getMessage());
    }
    return rs;
}
public static void updateStudent(String roll, String name, String father, int age,
                                 String dept, String course, String gender,
                                 String address, String phone) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentdb", "root", "1234");

        String query = "UPDATE students SET name=?, father_name=?, age=?, department=?, "
                     + "course=?, gender=?, address=?, phone=? WHERE roll_no=?";

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, name);
        pst.setString(2, father);
        pst.setInt(3, age);
        pst.setString(4, dept);
        pst.setString(5, course);
        pst.setString(6, gender);
        pst.setString(7, address);
        pst.setString(8, phone);
        pst.setString(9, roll);

        int rows = pst.executeUpdate();

        if (rows > 0)
            System.out.println("Record updated!");
        else
            System.out.println("Roll No not found!");

        pst.close();
        con.close();

    } catch (Exception e) {
        System.out.println("Update Error: " + e.getMessage());
    }
}
public static void deleteStudent(String roll) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentdb", "root", "1234");

        String query = "DELETE FROM students WHERE roll_no=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, roll);

        int rows = pst.executeUpdate();

        if (rows > 0)
            System.out.println("Record deleted!");
        else
            System.out.println("Roll No not found!");

        pst.close();
        con.close();

    } catch (Exception e) {
        System.out.println("Delete Error: " + e.getMessage());
    }
  }
}
