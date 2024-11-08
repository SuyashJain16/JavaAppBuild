import javax.swing.*; 
import java.awt.*; 
import java.io.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
public class Notepad extends JFrame implements ActionListener
{
JTextArea area;
JScrollPane pane;
String text;
Notepad()
{
setBounds(0,0,1950,1050);
JMenuBar menubar= new JMenuBar(); 
JMenu file= new JMenu("File");
JMenu edit= new JMenu("Edit"); 
JMenu help= new JMenu("Help"); 
menubar.add(file); 
menubar.add(edit); menubar.add(help); 
setJMenuBar(menubar);
area=new JTextArea();
area.setFont(new Font("SAN_SERIF",Font.PLAIN,20)); 
area.setLineWrap(true);
area.setWrapStyleWord(true); pane= new JScrollPane(area);
pane.setBorder(BorderFactory.createEmptyBorder()); 
add(pane,BorderLayout.CENTER);
JMenuItem New= new JMenuItem("New"); 
New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
New.addActionListener(this);
JMenuItem open= new JMenuItem("Open"); 
open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
open.addActionListener(this);
JMenuItem save=new JMenuItem("Save"); 
save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
save.addActionListener(this);
JMenuItem print=new JMenuItem("Print"); 
print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
print.addActionListener(this);
JMenuItem exit=new JMenuItem("Exit"); 
exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
exit.addActionListener(this); 
file.add(New); file.add(open); 
file.add(save); file.add(print); 
file.add(exit);
JMenuItem cut=new JMenuItem("Cut"); 
cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
cut.addActionListener(this);
JMenuItem copy=new JMenuItem("Copy");
copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
copy.addActionListener(this);
JMenuItem paste=new JMenuItem("Paste"); 
paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
paste.addActionListener(this);
JMenuItem selectAll=new JMenuItem("SelectAll"); 
selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
selectAll.addActionListener(this); 
edit.add(cut);
edit.add(copy); edit.add(paste); 
edit.add(selectAll);
JMenuItem about= new JMenuItem("About NotePad"); 
help.add(about);
about.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getActionCommand().equals("New"))
{
area.setText("");
}
else if(ae.getActionCommand().equals("Open"))
{
JFileChooser chooser =new JFileChooser(); 
chooser.setAcceptAllFileFilterUsed(false); 
FileNameExtensionFilter restrict= new FileNameExtensionFilter("only .txt file","txt"); 
chooser.addChoosableFileFilter(restrict);
int action= chooser.showOpenDialog(this); 
if(action != JFileChooser.APPROVE_OPTION)
{
return;
}
File file= chooser.getSelectedFile(); 
try {
BufferedReader reader= new BufferedReader(new FileReader(file)); 
area.read(reader, null);
}
catch(Exception e){}
}
else if(ae.getActionCommand().equals("Save"))
{
JFileChooser saveas= new JFileChooser(); 
saveas.setApproveButtonText("Save");
int action= saveas.showOpenDialog(this); 
if(action !=JFileChooser.APPROVE_OPTION)
{
return;
}
File filename= new File(saveas.getSelectedFile()+".txt"); 
BufferedWriter outfile=null;
try{
outfile= new BufferedWriter(new FileWriter(filename)); 
area.write(outfile);
}
catch(Exception e){}
}
else if(ae.getActionCommand().equals("Print"))
{
try{ area.print();
}
catch(Exception e){}
}
else if(ae.getActionCommand().equals("Exit"))
{
System.exit(0);
}
else if(ae.getActionCommand().equals("Cut"))
{
area.cut();
}
else if(ae.getActionCommand().equals("Copy"))
{
area.copy();
}
else if(ae.getActionCommand().equals("Paste"))
{
area.paste();
}
else if(ae.getActionCommand().equals("SelectAll"))
{
area.selectAll();
}
else if(ae.getActionCommand().equals("About NotePad")) new about().setVisible(true);
}
public static void main(String[] args) 
{ 
new Notepad().setVisible(true);
}
}