import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.DARK_GRAY;

public class JLoginInfo extends JFrame implements ActionListener {
    JFrame f;

    JButton JB = new JButton("Nominate Invention");
    JTextField JT = new JTextField();

    JLoginInfo(String[][] info) {
        f = new JFrame();
        String column[] = {"Invention_ID", "Invention_Name", "Invention_Category", "Invention_Year", "Story_Behind"};
        JTable jt = new JTable(info, column);
        JLabel JL = new JLabel("INVENTION ID");
        f.setBackground(DARK_GRAY);


        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(30, 40, 500, 400);
        sp.setBackground(DARK_GRAY);


        f.add(sp);

        f.setSize(600, 600);
        f.setLayout(null);

        f.setVisible(true);
        f.setResizable(false);


        JL.setBounds(60, 465, 100, 25);
        JL.setForeground(Color.darkGray);
        JL.setFont(new Font("Times New Roman", Font.BOLD, 14));
        ;

        JT.setBounds(160, 450, 300, 50);


        JB.setFont(new Font("Times New Roman", Font.BOLD, 14));

        JB.setBounds(225, 510, 150, 50);

        f.add(JT);
        f.add(JB);
        f.add(JL);
        JB.addActionListener(this);


    }


    @Override

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == JB) {
            int data =Integer.parseInt(JT.getText());


            Database db = new Database();
            db.insertData(data);

        }
    }



}



