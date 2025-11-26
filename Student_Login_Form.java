import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Student_Login_Form {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Student Registration Form");

        JPanel panal = new JPanel();
        panal.setLayout(new GridLayout(0, 2, 12, 10));
        panal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font f = new Font("Arial", Font.BOLD, 13);

        JLabel StudName = new JLabel("Student Name: ");
        JLabel FathName = new JLabel("Father Name: ");
        JLabel rolNo = new JLabel("Roll No: ");
        JLabel Age = new JLabel("Age: ");
        JLabel dept = new JLabel("Department: ");
        JLabel cr = new JLabel("Course: ");
        JLabel gender = new JLabel("Gender: ");
        JLabel Address = new JLabel("Address: ");
        JLabel PhNO = new JLabel("Contact No: ");

        JTextField StdN = new JTextField();
        JTextField FathN = new JTextField();
        JTextField RolNo = new JTextField();
        JTextField age = new JTextField();
        JTextField txtPhone = new JTextField();

        StudName.setFont(f); FathName.setFont(f); rolNo.setFont(f);
        Age.setFont(f); dept.setFont(f); cr.setFont(f);
        gender.setFont(f); Address.setFont(f); PhNO.setFont(f);

        StdN.setFont(f); FathN.setFont(f); RolNo.setFont(f);
        age.setFont(f); txtPhone.setFont(f);

        JRadioButton r1 = new JRadioButton("Male");
        JRadioButton r2 = new JRadioButton("Female");
        JRadioButton r3 = new JRadioButton("Other");

        r1.setFont(f); r2.setFont(f); r3.setFont(f);
        ButtonGroup group = new ButtonGroup();
        group.add(r1); group.add(r2); group.add(r3);

        JPanel genderPanel = new JPanel();
        genderPanel.add(r1); genderPanel.add(r2); genderPanel.add(r3);

        JComboBox<String> depart;
        String[] department = {"Select", "BS CS", "BBA", "BS A&F", "BS AI", "BS SE", "BE CSE", "BE EE", "BS M&S", "Other"};
        depart = new JComboBox<>(department);
        depart.setFont(f);

        JComboBox<String> Courses;
        String[] Sub = {"Select", "DSA", "JAVA", "CPP", "C#", "DLD", "CCN", "DBMS", "Other"};
        Courses = new JComboBox<>(Sub);
        Courses.setFont(f);

        JTextArea txtAddress = new JTextArea(2, 20);
        txtAddress.setFont(f);
        JScrollPane addressScroll = new JScrollPane(txtAddress);

        JButton crt = new JButton("Create");
        JButton rd = new JButton("Read");
        JButton upd = new JButton("Update");
        JButton del = new JButton("Delete");
        JButton clr = new JButton("Clear");
        JButton exitBtn = new JButton("EXIT");

        crt.setFont(f); clr.setFont(f); exitBtn.setFont(f);rd.setFont(f);
        upd.setFont(f);del.setFont(f);

        crt.setBackground(new Color(0, 153, 76));
        crt.setForeground(Color.WHITE);
        rd.setBackground(new Color(1, 142, 76));
        rd.setForeground(Color.WHITE);
        upd.setBackground(new Color(0, 123, 76));
        upd.setForeground(Color.WHITE);
        del.setBackground(new Color(2, 102, 76));
        del.setForeground(Color.WHITE);
       
        clr.setBackground(new Color(204, 0, 0));
        clr.setForeground(Color.WHITE);
      
        exitBtn.setBackground(new Color(0, 238, 76));
        exitBtn.setForeground(Color.WHITE);

        // Adding to panel
        panal.add(StudName); panal.add(StdN);
        panal.add(FathName); panal.add(FathN);
        panal.add(Age); panal.add(age);
        panal.add(rolNo); panal.add(RolNo);
        panal.add(dept); panal.add(depart);
        panal.add(gender); panal.add(genderPanel);
        panal.add(cr); panal.add(Courses);
        panal.add(Address); panal.add(addressScroll);
        panal.add(PhNO); panal.add(txtPhone);
        panal.add(new JLabel(""));
        panal.add(new JLabel(""));
        panal.add(crt);panal.add(rd);panal.add(upd);panal.add(del);
        panal.add(exitBtn); panal.add(clr);
        panal.add(new JLabel(""));

        panal.setBackground(new Color(220, 235, 255));
        fr.add(panal);
        
        fr.setSize(700,650);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CLEAR BUTTON 
        clr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StdN.setText("");
                FathN.setText("");
                RolNo.setText("");
                age.setText("");
                txtPhone.setText("");
                txtAddress.setText("");

                depart.setSelectedIndex(0);
                Courses.setSelectedIndex(0);
                group.clearSelection();

                JOptionPane.showMessageDialog(fr, "Form cleared!");
            }
        });

         rd.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        ResultSet rs = DBConnect.readStudents();
        StringBuilder data = new StringBuilder();

        try {
            while (rs.next()) {
                data.append("Name: ").append(rs.getString("name")).append("\n");
                data.append("Father: ").append(rs.getString("father_name")).append("\n");
                data.append("Age: ").append(rs.getInt("age")).append("\n");
                data.append("Roll No: ").append(rs.getString("roll_no")).append("\n");
                data.append("Dept: ").append(rs.getString("department")).append("\n");
                data.append("Course: ").append(rs.getString("course")).append("\n");
                data.append("Gender: ").append(rs.getString("gender")).append("\n");
                data.append("Phone: ").append(rs.getString("phone")).append("\n");
                data.append("Address: ").append(rs.getString("address")).append("\n");
                data.append("-----------------------------\n");
            }

            JOptionPane.showMessageDialog(fr, new JScrollPane(new JTextArea(data.toString())));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fr, "Error: " + ex.getMessage());
        }
      }
   });

      upd.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        String roll = RolNo.getText();

        if (roll.isEmpty()) {
            JOptionPane.showMessageDialog(fr, "Enter Roll No to update!");
            return;
        }

        int ageValue;
        try {
            ageValue = Integer.parseInt(age.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fr, "Age must be number!");
            return;
        }

        String genderSelected = r1.isSelected() ? "Male" :
                                r2.isSelected() ? "Female" : "Other";

        DBConnect.updateStudent(
            roll,
            StdN.getText(),
            FathN.getText(),
            ageValue,
            depart.getSelectedItem().toString(),
            Courses.getSelectedItem().toString(),
            genderSelected,
            txtAddress.getText(),
            txtPhone.getText()
        );

        JOptionPane.showMessageDialog(fr, "Record Updated!");
      }
   });

     del.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        String roll = RolNo.getText();

        if (roll.isEmpty()) {
            JOptionPane.showMessageDialog(fr, "Enter Roll No to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to delete?",
            "Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            DBConnect.deleteStudent(roll);
            JOptionPane.showMessageDialog(fr, "Record Deleted!");
        }
       }
   });


        // SUBMIT BUTTON
        crt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // BASIC VALIDATION
                if (StdN.getText().isEmpty() || FathN.getText().isEmpty() ||
                    RolNo.getText().isEmpty() || age.getText().isEmpty() ||
                    txtPhone.getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(fr, "Please fill all fields!");
                    return;
                }

                // AGE VALIDATION
                int ageValue;
                try {
                    ageValue = Integer.parseInt(age.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(fr, "Age must be a number!");
                    return;
                }

                // GENDER VALIDATION
                if (!r1.isSelected() && !r2.isSelected() && !r3.isSelected()) {
                    JOptionPane.showMessageDialog(fr, "Please select gender!");
                    return;
                }

                String genderSelected = r1.isSelected() ? "Male" :
                                        r2.isSelected() ? "Female" : "Other";

                // COMBO VALIDATION
                if (depart.getSelectedIndex() == 0 || Courses.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(fr, "Please select Department and Course!");
                    return;
                }

                // INSERT INTO DATABASE
                DBConnect.insertStudent(
                    StdN.getText(),
                    FathN.getText(),
                    ageValue,
                    RolNo.getText(),
                    depart.getSelectedItem().toString(),
                    Courses.getSelectedItem().toString(),
                    genderSelected,
                    txtAddress.getText(),
                    txtPhone.getText()
                );

                JOptionPane.showMessageDialog(fr, "Data saved successfully!");
            }
        });
            // EXIT BUTTON
            exitBtn.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                   System.exit(0);
           JOptionPane.showMessageDialog(fr, "Window closed");
          }
      });

    }
}
