import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class GUI  implements ActionListener{
	JFrame f;
	Container cp;
	JLabel ID_l;
	JTextField ID;
	JLabel pw_l;
	JPasswordField pw;
	
	JButton loginBtn;
	JButton registerBtn;
	Login login;
	public static void main(String args[]) {
			new GUI();
	    }
	GUI(){
	    final int w = 100;
        final int h = 40;
        
        final int label_x = 120;
	    final int textField_x = label_x + 30;
	    final int loginBtn_x = (textField_x + w  + label_x )/2;
	    
	    final int ID_y = 80;
	    final int pw_y = ID_y + h;
	    final int btn_y = pw_y + h;
	    
	    login = new Login();
		JFrame.setDefaultLookAndFeelDecorated(false);//Swing 主題風格
	    JDialog.setDefaultLookAndFeelDecorated(false);
		f = new JFrame("Login");
		f.setBounds(0,0,400,300);//視窗位置與大小 
		cp=f.getContentPane();
		cp.setLayout(null);  //取消預設之 BorderLayout
		//帳號
		ID_l = new JLabel("帳號");
		ID_l.setBounds(label_x,ID_y,w,h);
		ID = new JTextField("");//預設文字
		ID.setBounds(textField_x,ID_y,w,h);
		cp.add(ID_l);
		cp.add(ID);
		//密碼
		pw_l = new JLabel("密碼");
        pw_l.setBounds(label_x,pw_y,w,h);
		pw = new JPasswordField();
		pw.setBounds(textField_x,pw_y,w,h);
		cp.add(pw_l);
		cp.add(pw);
		//註冊
		registerBtn = new JButton("註冊");
		registerBtn.setBounds(loginBtn_x - (w*2/3),btn_y,w*2/3,h);
		registerBtn.addActionListener(this);
		cp.add(registerBtn); 
		//登入
		loginBtn=new JButton("登入");
		loginBtn.setBounds(loginBtn_x,btn_y,w*2/3,h);  //自行決定元件位置與大小(x,y,w,h)
		loginBtn.addActionListener(this);
		cp.add(loginBtn); 
		//視窗
		f.setLocationRelativeTo(null);//將視窗顯示在螢幕正中間
		f.setVisible(true); //顯示視窗
		//關閉視窗
		f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {//關閉視窗Event
		        int result=JOptionPane.showConfirmDialog(
		                f,     
		                "確定要結束程式嗎?",//內容
		                "確認訊息",//標題
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
        if(event.getSource()==registerBtn){
            JOptionPane.showMessageDialog(f,login.register(ID.getText(),pw.getPassword()));
        }
        if(event.getSource()==loginBtn){
            JOptionPane.showMessageDialog(f,login.login(ID.getText(),pw.getPassword()));
        }
    }
}