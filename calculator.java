

import java.awt.*;
import java.awt.event.*;

public class calculator extends WindowAdapter implements ActionListener {
    Frame f;
    Label l;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    Button bback,bclear,bmul,badd,bsub,bmod,bdiv,bneg,bpts,beql;
    double xd;
    double num1,num2,check;
    calculator()
    {
        f = new Frame("MY CALCULATOR");
        l = new Label();
        l.setBackground(Color.GRAY);
        l.setBounds(50,50,260,60);
        b1 = new Button("1");
        b1.setBounds(50,340,50,50);
        b2 = new Button("2");
        b2.setBounds(120,340,50,50);
        b3 = new Button("3");
        b3.setBounds(190,340,50,50);
        b4 = new Button("4");
        b4.setBounds(50,270,50,50);
        b5 = new Button("5");
        b5.setBounds(120,270,50,50);
        b6 = new Button("6");
        b6.setBounds(190,270,50,50);
        b7 = new Button("7");
        b7.setBounds(50,200,50,50);
        b8 = new Button("8");
        b8.setBounds(120,200,50,50);
        b9 = new Button("9");
        b9.setBounds(190,200,50,50);
        b0 = new Button("0");
        b0.setBounds(120,410,50,50);
        bneg = new Button("+/-");
        bneg.setBounds(50,410,50,50);
        bneg=new Button("+/-");
        bneg.setBounds(50,410,50,50);
        bpts=new Button(".");
        bpts.setBounds(190,410,50,50);
        bback=new Button("back");
        bback.setBounds(120,130,50,50);

        badd=new Button("+");
        badd.setBounds(260,340,50,50);
        bsub=new Button("-");
        bsub.setBounds(260,270,50,50);
        bmul=new Button("*");
        bmul.setBounds(260,200,50,50);
        bdiv=new Button("/");
        bdiv.setBounds(260,130,50,50);
        bmod=new Button("%");
        bmod.setBounds(190,130,50,50);
        beql=new Button("=");
        beql.setBounds(245,410,65,50);
        bclear=new Button("CE");
        bclear.setBounds(50,130,65,50);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);

        bpts.addActionListener(this);
        bneg.addActionListener(this);
        bback.addActionListener(this);

        badd.addActionListener(this);
        bsub.addActionListener(this);
        bmul.addActionListener(this);
        bdiv.addActionListener(this);
        bmod.addActionListener(this);
        beql.addActionListener(this);
        beql.addActionListener(this);

        f.addWindowListener(this);
//ADDING TO FRAME
        f.add(l);
        f.add(b1); f.add(b2); f.add(b3); f.add(b4); f.add(b5);f.add(b6); f.add(b7); f.add(b8);f.add(b9);f.add(b0);

        f.add(badd); f.add(bsub); f.add(bmod); f.add(bmul); f.add(bdiv); f.add(bmod);f.add(beql);

        f.add(bclear); f.add(bpts);f.add(bneg); f.add(bback);

        f.setSize(360,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void windowClosing(WindowEvent e)
    {
        f.dispose();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String z,w = "";
        if(e.getSource()==b1)
        {
            z=l.getText();
            z= w +"1";
            l.setText(z);

        }
        if(e.getSource()==b2)
        {
            z=l.getText();
            z= w +"2";
            l.setText(z);
        }
        if(e.getSource()==b3)
        {
            z=l.getText();
            z= w +"3";
            l.setText(z);

        }
        if(e.getSource()==b4)
        {
            z=l.getText();
            z= w +"4";
            l.setText(z);

        }
        if(e.getSource()==b5)
        {
            z=l.getText();
            z= w +"5";
            l.setText(z);

        }
        if(e.getSource()==b6)
        {
            z=l.getText();
            z= w +"6";
            l.setText(z);
        }
        if(e.getSource()==b7)
        {
            z=l.getText();
            z= w +"7";
            l.setText(z);
        }
        if(e.getSource()==b8)
        {
            z=l.getText();
            z= w +"8";
            l.setText(z);
        }
        if(e.getSource()==b9)
        {
            z=l.getText();
            z= w +"9";
            l.setText(z);
        }
        if(e.getSource()==b0)
        {
            z=l.getText();
            z= w +"0";
            l.setText(z);
        }
        if(e.getSource()==bpts)
        {
            z=l.getText();
            z= w +".";
            l.setText(z);
        }
        if(e.getSource()==bneg)
        {
            z=l.getText();
            z= w +"-";
            l.setText(z);
        }
        if(e.getSource()==bback)
        {
            w=l.getText();
            try
            {
                z= w.substring(0,w.length()-1);
            }
            catch(StringIndexOutOfBoundsException f){return ;}
            l.setText(z);
        }
        if(e.getSource()==badd)
        {
            try
            {
                num1= Double.parseDouble(l.getText());
            }catch(NumberFormatException f){l.setText("invalid format"); return ;}
            z="";
            l.setText(z);
            check=1;
        }
        if(e.getSource()==bsub)
        {
            try
            {
                num1= Double.parseDouble(l.getText());
            }catch(NumberFormatException f){l.setText("invalid format"); return ;}
            z="";
            l.setText(z);
            check=2;
        }
        if(e.getSource()==bmul)
        {
            try
            {
                num1= Double.parseDouble(l.getText());
            }catch(NumberFormatException f){l.setText("invalid format"); return ;}
            z="";
            l.setText(z);
            check=3;
        }
        if(e.getSource()==bdiv)
        {
            try
            {
                num1= Double.parseDouble(l.getText());
            }catch(NumberFormatException f){l.setText("invalid format"); return ;}
            z="";
            l.setText(z);
            check=4;
        }
        if(e.getSource()==bmod)
        {
            try
            {
                num1= Double.parseDouble(l.getText());
            }catch(NumberFormatException f){l.setText("invalid format"); return ;}
            z="";
            l.setText(z);
            check=5;
        }
        if(e.getSource()==beql)
        {
            try{
            num2 = Double.parseDouble(l.getText());
            }
            catch(Exception f)
            {
                l.setText("enter the number first");
                return ;
            }
            if(check==1)
            {
                xd=num1+num2;
            }
            if(check==2)
            {
                xd=num1-num2;
            }
            if(check==3)
            {
                xd=num1*num2;
            }
            if(check==4)
            {
                xd=num1/num2;
            }
            if(check==5)
            {
                xd=num1%num2;
            }
            l.setText(String.valueOf(xd));

        }
        if(e.getSource()==bclear)
        {
            num1=0;
            num2=0;
            xd=0;
            check=0;
            z="";
            l.setText(z);

        }







    }

    public static void main(String[] args) {
        calculator c= new calculator();

    }
}




