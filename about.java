import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class about extends JFrame implements ActionListener {
about()
{
setBounds(300,100,700,600);
setLayout(null);
JLabel L1= new JLabel("<html>Notepad is the word proccesing  program<br>which allows changing of text in computer file<br>Notepad is simple text editor for basic text editing program<br>which enable computer used to create documents<br> Developed by-<br>1) Suyash Lomte <br> 2) Kaushal Sharma<br><br> </html>");
L1.setBounds(100,30,500,300);
L1.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
add(L1);
JButton b1= new JButton("OK");
b1.setBounds(200,350,80,40);
add(b1);
b1.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getActionCommand().equals("OK"))
{
return;
}
}
public static void main(String[] args)
{
new about().setVisible(true);
}
}