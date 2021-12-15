import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JuryMemberLogin{
    public JuryMemberLogin(){

        JFrame loginWindow = new JFrame("Jury Member Login");
        loginWindow.setSize(400,500);
        loginWindow.getContentPane().setBackground(Color.DARK_GRAY);
        loginWindow.setVisible(true);
        loginWindow.setLayout(null);
        loginWindow.setResizable(false);
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel heading1=new JLabel("INVENTION MANAGEMENT SYSTEM");
        heading1.setForeground(Color.WHITE);
        heading1.setFont(new Font("Serif", Font.BOLD, 19));
        heading1.setBounds(20,-30,400,100);
        loginWindow.add(heading1);

        JLabel heading2=new JLabel("Jury Member Login ");
        heading2.setForeground(new Color(32,178,170));
        heading2.setFont(new Font("Serif", Font.BOLD, 17));
        heading2.setBounds(110,6,400,100);
        loginWindow.add(heading2);

        JLabel jmidHeading=new JLabel("JM - ID");
        jmidHeading.setForeground(Color.WHITE);
        jmidHeading.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jmidHeading.setBounds(80,93,100,100);
        loginWindow.add(jmidHeading);

        JTextField jmid=new JTextField(15);
        jmid.setBorder(new LineBorder(Color.BLACK));
        jmid.setFont(new Font("Times New Roman", Font.BOLD,18));
        jmid.setBounds(150,130,132,27);
        loginWindow.add(jmid);

        JLabel passHeading=new JLabel("Password");
        passHeading.setForeground(Color.WHITE);
        passHeading.setFont(new Font("Times New Roman", Font.BOLD, 16));
        passHeading.setBounds(80,180,100,100);
        loginWindow.add(passHeading);

        JPasswordField password=new JPasswordField(10);
        password.setBounds(150,215,132,27);
        password.setFont(new Font("Times New Roman", Font.BOLD,18));
        password.setBorder(new LineBorder(Color.BLACK));
        loginWindow.add(password);

        JButton submitButton=new JButton("Login");
        submitButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        submitButton.setBounds(30,310,100,30);
        submitButton.setBackground(new Color(193, 225, 193));
        loginWindow.add(submitButton);

        JButton clearButton=new JButton("Clear");
        clearButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        clearButton.setBounds(230,310,100,30);
        clearButton.setBackground(new Color(193, 225, 193));
        loginWindow.add(clearButton);

        JButton backButton = new JButton("Back <--");
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        backButton.setBackground(new Color(220,20,60));
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(130,390,100,30);
        loginWindow.add(backButton);


        ActionListener clearEventListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jmid.setText("");
                password.setText("");
            }
        };
        clearButton.addActionListener(clearEventListener);

        ActionListener backButtonEvent =new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginWindow.setVisible(false);
                 //AdminLoginScreen();
            }
        };backButton.addActionListener(backButtonEvent);

        ActionListener loginButtonEvent =new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int data =Integer.parseInt(jmid.getText());
                    String pass = String.valueOf(password.getPassword());
                    Database db = new Database();
                    boolean result = db.loginVerify(data,pass);
                    while(result) {

                        loginWindow.setVisible(false);
                        Database obj6 = new Database();

                        new JLoginInfo(obj6.login());
                    }

                }

            }
        };submitButton.addActionListener(loginButtonEvent);
    }




















































    public static void main(String[] args) {
        new JuryMemberLogin();
    }
}