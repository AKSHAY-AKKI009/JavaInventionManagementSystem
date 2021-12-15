

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_2 extends JFrame  implements ActionListener {


    JPanel JP = new JPanel();

    JLabel JL = new JLabel("WELCOME");

    JButton Science = new JButton("SCIENCE");
    JButton Medicine = new JButton("MEDICINE");

    JPanel JP1 = new JPanel();

    JLabel JL1 = new JLabel("SELECT CATEGORY");

    JButton SCI_TECH = new JButton("SCIENTIFIC/TECHNOLOGICAL");
    JButton CULTURAL = new JButton("CULTURAL");
    JButton INV_PAT = new JButton("INVENTION UNDER PATENTSHIP");
    JButton INV_NOM = new JButton("INVENTION UNDER NOMINATION");
    JButton AWARDS = new JButton("AWARDS");
    JButton LOGOUT = new JButton("CLOSE");








    Swing_2(){

        this.setTitle("Invention Managment System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(600,600);
        this.getContentPane().setBackground(Color.DARK_GRAY);

        JP.setBackground(Color.white);
        JP.setBounds(0,0,600,43);

        JL.setBounds(240,0,600,20);
        JL.setForeground(Color.DARK_GRAY);
        JL.setFont(new Font("Algerian", Font.BOLD, 25));

        this.add(JP);
        JP.add(JL);

        Science.setBounds(0,80,250,60);
        Science.setFont(new Font("Algerian",Font.BOLD,25));
        Medicine.setBounds(350,80,250,60);
        Medicine.setFont(new Font("Algerian",Font.BOLD,25));
        this.add(Science);
        this.add(Medicine);

        JP1.setBackground(Color.DARK_GRAY);
        JP1.setBounds(0,190,600,43);


        JL1.setBounds(0,190,600,20);
        JL1.setForeground(Color.WHITE);
        JL1.setFont(new Font("Algerian", Font.BOLD, 25));



        this.add(JP1);
        JP1.add(JL1);

        SCI_TECH.setBounds(0,280,220,60);
        CULTURAL.setBounds(380,280,220,60);
        INV_PAT.setBounds(0,390,220,60);
        INV_NOM.setBounds(380,390,220,60);
        AWARDS.setBounds(175,470,250,30);
        LOGOUT.setBounds(200,520,200,30);

        SCI_TECH.setFont(new Font("Algerian", Font.PLAIN, 13));
        CULTURAL.setFont(new Font("Algerian", Font.PLAIN, 13));
        INV_NOM.setFont(new Font("Algerian", Font.PLAIN, 12));
        INV_PAT.setFont(new Font("Algerian", Font.PLAIN, 12));
        AWARDS.setFont(new Font("Algerian", Font.BOLD, 15));
        LOGOUT.setFont(new Font("Algerian", Font.BOLD, 15));

        this.add(SCI_TECH);
        this.add(CULTURAL);
        this.add(INV_PAT);
        this.add(INV_NOM);
        this.add(AWARDS);
        this.add(LOGOUT);


        Science.addActionListener(this);
        Medicine.addActionListener(this);
        SCI_TECH.addActionListener(this);
        CULTURAL.addActionListener(this);
        INV_PAT.addActionListener(this);
        INV_NOM.addActionListener(this);
        AWARDS.addActionListener(this);
        LOGOUT.addActionListener(this);





    }

    public static void main(String[] args) {

        new Swing_2();

    }

   @Override
    public void actionPerformed(ActionEvent ev) {


        if(ev.getSource() == Science) {
           Database obj = new Database();
            new Table(obj.fetchData("Science"));
            this.setVisible(false);

        }
        else if (ev.getSource() == LOGOUT){
            this.dispose();
        }
        else if (ev.getSource() == SCI_TECH){
            Database obj = new Database();
            new Table(obj.fetchData("SCI_TECH"));
            this.setVisible(false);

        }
        else if (ev.getSource() == Medicine){
            Database obj = new Database();
            new Table(obj.fetchData("Medicine"));
            this.setVisible(false);

        }
        else if(ev.getSource() == CULTURAL) {
            Database obj = new Database();
            new Table(obj.fetchData("CULTURAL"));
            this.setVisible(false);


        }

       else if(ev.getSource() == INV_NOM) {
            Database obj2 = new Database();
            new NomTable(obj2.invNom());
            this.setVisible(false);

        }
       else if(ev.getSource() == INV_PAT) {
            Database obj3 = new Database();
            new PatTable(obj3.invPat());
            this.setVisible(false);
     }
        else if(ev.getSource() == AWARDS) {
            Database obj4 = new Database();
            new Awards(obj4.awards());
            this.setVisible(false);
        }

    }


}
