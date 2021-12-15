import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Awards implements ActionListener {
    JFrame f;
    JButton JB = new JButton("Back");

    Awards(String[][] info) {
        f = new JFrame();
        String column[] = {"Award_ID", "Award_Name", "Sponsered_By","Award_Amount"};
        JTable jt = new JTable(info, column);
        f.setLayout(null);

        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(30, 40, 450, 450);
        f.add(sp);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setResizable(false);
        f.add(JB);
        JB.setBounds(30, 500, 100, 50);
        JB.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==JB){
            new Swing_2();

        }
        f.setVisible(false);
    }
}


