
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class Table {
    JFrame f;

    Table(String[][] info) {
        f = new JFrame();
        String column[] = {"Invention_ID", "Invention_Name", "Invention_Year", "Story_Behind"};
        JTable jt = new JTable(info, column);
        jt.setBounds(30, 40, 300, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setResizable(false);

    }
}
class PatTable {
    JFrame f;

    PatTable(String[][] info) {
        f = new JFrame();
        String column[] = {"Invention_ID", "Year", "Patent Type"};
        JTable jt = new JTable(info, column);
        jt.setBounds(30, 40, 300, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setResizable(false);

    }
}
class NomTable {
    JFrame f;

    NomTable(String[][] info) {
        f = new JFrame();
        String column[] = {"Invention_ID", "Nominated By", "Year of Nomination"};
        JTable jt = new JTable(info, column);
        jt.setBounds(30, 40, 300, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setResizable(false);

    }
}

class Awards {
    JFrame f;

    Awards(String[][] info) {
        f = new JFrame();
        String column[] = {"Award_ID", "Award_Name", "Sponsered By","Award Amount"};
        JTable jt = new JTable(info, column);
        jt.setBounds(30, 40, 300, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setResizable(false);

    }
}



public class Database extends Component {

    public String[][] fetchData(String Category) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Invms";
        String username = "postgres";
        String password = "Akshayakki@009";
        String[][] data = new String[100][4];

        try {
            Connection Connection = DriverManager.getConnection(jdbcURL, username, password);
            //  Statement statement = Connection.createStatement();

            String sql = "select * from Invention where Invention_Category = ? ";
            PreparedStatement preparedStatement = Connection.prepareStatement(sql);
            preparedStatement.setString(1, Category);
            ResultSet resultSet = preparedStatement.executeQuery();

            int i=0;
            while (resultSet.next()) {

                data[i][0] = "" + resultSet.getInt("Invention_ID");
                data[i][1] = resultSet.getString("Invention_Name");
                data[i][2] = "" + resultSet.getInt("Invention_Year");
                data[i][3] = resultSet.getString("Story_Behind");
                i++;

            }
            Connection.close();
        } catch (SQLException e) {
            System.out.println("error in connecting to postgresql");
            e.printStackTrace();

        }
        return data;
    }

    public String[][] invNom(){
        String URL = "jdbc:postgresql://localhost:5432/Invms";
        String Username = "postgres";
        String Password = "Akshayakki@009";
        String[][] nomInfo = new String[100][3];

        try {
            Connection Connection = DriverManager.getConnection(URL, Username, Password);
            Statement statement = Connection.createStatement();

            String sql = "select * from Nominated_Invention";


            ResultSet resultSet = statement.executeQuery(sql);


            int j=0;
            while (resultSet.next()) {

                nomInfo[j][0] = "" + resultSet.getInt("Invention_ID");
                nomInfo[j][1] = resultSet.getString("Nominated_By");
                nomInfo[j][2] = "" + resultSet.getInt("Year_Of_Nomination");
                j++;

            }
            Connection.close();
        } catch (SQLException e) {
            System.out.println("error in connecting to postgresql");
            e.printStackTrace();

        }
        return nomInfo;


    }

    public String[][] invPat(){
        String URL = "jdbc:postgresql://localhost:5432/Invms";
        String Username = "postgres";
        String Password = "Akshayakki@009";
        String[][] patInfo = new String[100][3];

        try {
            Connection Connection = DriverManager.getConnection(URL, Username, Password);
            Statement statement = Connection.createStatement();

            String sql = "select * from Patented_Invention";


            ResultSet resultSet = statement.executeQuery(sql);

            int i=0;
            while (resultSet.next()) {

                patInfo[i][0] = "" + resultSet.getInt("Invention_ID");
                patInfo[i][1] = resultSet.getString("Year");
                patInfo[i][2] =  resultSet.getString("Patent_Type");

                i++;

            }
            Connection.close();
        } catch (SQLException e) {
            System.out.println("error in connecting to postgresql");
            e.printStackTrace();

        }
        return patInfo;


    }

    public String[][] awards() {
        String URL = "jdbc:postgresql://localhost:5432/Invms";
        String Username = "postgres";
        String Password = "Akshayakki@009";
        String[][] awardInfo = new String[100][4];

        try {
            Connection Connection = DriverManager.getConnection(URL, Username, Password);
            Statement statement = Connection.createStatement();

            String sql = "select * from Awards";


            ResultSet resultSet = statement.executeQuery(sql);

            int i=0;
            while (resultSet.next()) {

                awardInfo[i][0] = "" + resultSet.getInt("Award_ID");
                awardInfo[i][1] = resultSet.getString("Award_Name");
                awardInfo[i][2] = resultSet.getString("Sponsored_By");
                awardInfo[i][3] = "" + resultSet.getInt("Award_Amount");
                i++;

            }
            Connection.close();
        } catch (SQLException e) {
            System.out.println("error in connecting to postgresql");
            e.printStackTrace();

        }
        return awardInfo;
    }

  public boolean loginVerify(int user,String pass) {
        String URL = "jdbc:postgresql://localhost:5432/Invms";
        String Username = "postgres";
        String Password = "Akshayakki@009";
        int user1 = 0;
        String pass1 = "";


        try {
            Connection connection = (Connection) DriverManager.getConnection(URL, Username, Password);

            PreparedStatement st = (PreparedStatement) connection.prepareStatement("select * from Jury_Member  where jm_id=? and password=?");

            st.setInt(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
              user1 =  rs.getInt("jm_id");
                pass1 = rs.getString("password");
            }
            if (user==user1 && pass.equals(pass1)) {
                JOptionPane.showMessageDialog(this,"correct");
                return true;

            }
            else{
                JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return  false;

        }

    }


    public String[][] login() {
        String uRL = "jdbc:postgresql://localhost:5432/Invms";
        String USsername = "postgres";
        String PasSword = "Akshayakki@009";
        String[][] loginInfo = new String[100][5];

        try {
            Connection Connection = DriverManager.getConnection(uRL, USsername, PasSword);
            Statement statement = Connection.createStatement();

            String sql = "select * from Invention";


            ResultSet resultSet = ((Statement) statement).executeQuery(sql);

            int i=0;
            while (resultSet.next()) {

                loginInfo[i][0] = "" + resultSet.getInt("Invention_ID");
                loginInfo[i][1] = resultSet.getString("Invention_Name");
                loginInfo[i][2] = resultSet.getString("Invention_Category");
                loginInfo[i][3] = "" + resultSet.getInt("Invention_Year");
                loginInfo[i][4] = resultSet.getString("Story_Behind");
                i++;
            }
            Connection.close();
        } catch (SQLException e) {
            System.out.println("error in connecting to postgresql");
            e.printStackTrace();

        }
        return loginInfo;


    }




    public void insertData(int data) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Invms";
        String username = "postgres";
        String password = "Akshayakki@009";


        try {
            Connection Connection = DriverManager.getConnection(jdbcURL, username, password);
            //  Statement statement = Connection.createStatement();

            String sql = "INSERT INTO Nominated_Invention VALUES(?) ";
            PreparedStatement preparedStatement = Connection.prepareStatement(sql);
            preparedStatement.setInt(1, data);
            int rowsaffected = preparedStatement.executeUpdate();


            Connection.close();
        } catch (SQLException e) {
            System.out.println("error in connecting to postgresql");
            e.printStackTrace();

        }

    }
    }