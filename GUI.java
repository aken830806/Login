import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI{
	JFrame f;
	public static void main(String args[]) {
			new GUI();
	    }
	GUI(){
	    final int ID_y = 80;
	    final int ps_y = ID_y + 40;
	    final int btn_y = ps_y + 40;
		JFrame.setDefaultLookAndFeelDecorated(true);//?
	    JDialog.setDefaultLookAndFeelDecorated(true);//?
		f = new JFrame("Login");
		f.setBounds(0,0,400,300); 
		f.setVisible(true); 
		Container cp=f.getContentPane();
		cp.setLayout(null);  //�����w�]�� BorderLayout
		//�b��
		JLabel ID_l = new JLabel("�b��");
		ID_l.setBounds(120,ID_y,100,40);
		JTextField ID = new JTextField("");//�w�]��r
		ID.setBounds(150,ID_y,100,40);
		cp.add(ID_l);
		cp.add(ID);
		//�K�X
		JLabel ps_l = new JLabel("�K�X");
        ps_l.setBounds(120,ps_y,100,40);
		JPasswordField pw = new JPasswordField();
		pw.setBounds(150,ps_y,100,40);
		cp.add(ps_l);
		cp.add(pw);
		//�n�J
		JButton loginBtn=new JButton("�n�J");
		loginBtn.setBounds(150,btn_y,100,40);  //�ۦ�M�w�����m�P�j�p(x,y,w,h)
		cp.add(loginBtn); 
		//��������
		f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {//��������Event
		        int result=JOptionPane.showConfirmDialog(
		                f,     
		                "�T�w�n�����{����?",//���e
		                "�T�{�T��",//���D
		                JOptionPane.YES_NO_OPTION,//Yes
		                JOptionPane.WARNING_MESSAGE);//no
		        if (result==JOptionPane.YES_OPTION) {
		            System.exit(0);
		            }
		        }    
		    });
		
	}
}