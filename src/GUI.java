import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class GUI{
	JFrame f;
	Container cp;
	JLabel ID_l;
	JTextField ID;
	JLabel pw_l;
	JPasswordField pw;
	
	JButton loginBtn;
	JButton registerBtn;
	JOptionPane1 message;
	Login login;
	public static void main(String args[]) {
			new GUI();
	    }
	GUI(){
	    final int w = 100;
        final int h = 40;
        
        final int label_x = 120;
	    final int textField_x = label_x + 30;
	    final int registerBtn_x = textField_x;
	    
	    final int ID_y = 80;
	    final int pw_y = ID_y + h;
	    final int btn_y = pw_y + h;
	    
	    login = new Login();
		JFrame.setDefaultLookAndFeelDecorated(false);//Swing �D�D����
	    JDialog.setDefaultLookAndFeelDecorated(false);
		f = new JFrame("Login");
		f.setBounds(0,0,400,300);//������m�P�j�p 
		cp=f.getContentPane();
		cp.setLayout(null);  //�����w�]�� BorderLayout
		//�b��
		ID_l = new JLabel("�b��");
		ID_l.setBounds(label_x,ID_y,w,h);
		ID = new JTextField("");//�w�]��r
		ID.setBounds(textField_x,ID_y,w,h);
		cp.add(ID_l);
		cp.add(ID);
		//�K�X
		pw_l = new JLabel("�K�X");
        pw_l.setBounds(label_x,pw_y,w,h);
		pw = new JPasswordField();
		pw.setBounds(textField_x,pw_y,w,h);
		cp.add(pw_l);
		cp.add(pw);
		//���U
		registerBtn = new JButton("���U");
		registerBtn.setBounds(registerBtn_x - w / 4,btn_y,w*2/3,h);
		cp.add(registerBtn); 
		//�n�J
		loginBtn=new JButton("�n�J");
		loginBtn.setBounds(registerBtn_x + w/2,btn_y,w*2/3,h);  //�ۦ�M�w�����m�P�j�p(x,y,w,h)
		cp.add(loginBtn); 
		//����
		f.setLocationRelativeTo(null);//�N������ܦb�ù�������
		f.setVisible(true); //��ܵ���
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
	public void actionPerformed(ActionEvent event)
    {
        if(event.getSource()==loginBtn)
        {
            
        }
    }
}