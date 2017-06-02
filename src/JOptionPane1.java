import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JOptionPane1 implements ActionListener {
  JFrame f;
//  public static void main(String argv[]) {
//    new JOptionPane1();  
//    }
  public JOptionPane1(JFrame f , String message) {
      this.f = f;
      //Setup JFrame
      JFrame.setDefaultLookAndFeelDecorated(false);
      JDialog.setDefaultLookAndFeelDecorated(false);
      f.setLocationRelativeTo(null); 

      //Build Elements
      JOptionPane.showMessageDialog(f,message);
      //Close JFrame        
      f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
      f.addWindowListener(new WindowHandler(f));  
   }
  public JOptionPane1() {//無JFrame
    //Setup JFrame
    JFrame.setDefaultLookAndFeelDecorated(false);
    JDialog.setDefaultLookAndFeelDecorated(false);
    f=new JFrame("JOptionPane Test");
    f.setSize(400,300); 
    f.setLocationRelativeTo(null); 
    Container cp=f.getContentPane();
    cp.setLayout(null);
    f.setVisible(true); 

    //Build Elements
    JOptionPane.showMessageDialog(f,"Hello World! 您好");
    //Close JFrame        
    f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
    f.addWindowListener(new WindowHandler(f));  
    }
  public void actionPerformed(ActionEvent e) {
    //if (e.getSource()==id) {}
    }
  }
class WindowHandler extends WindowAdapter {
  JFrame f;
  public WindowHandler(JFrame f) {this.f=f;}
  public void windowClosing(WindowEvent e) {
    int result=JOptionPane.showConfirmDialog(f,
               "確定要結束程式嗎?",
               "確認訊息",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.WARNING_MESSAGE);
    if (result==JOptionPane.YES_OPTION) {System.exit(0);}
    }
  }