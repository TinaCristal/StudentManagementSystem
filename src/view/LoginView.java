package view;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

import dao.Impl;
import common.DBConnection;

public class LoginView extends JFrame{
	
	private JPanel pasPanel;
	private JPanel idPanel;
	private JPanel buttonPanel;
	private JPanel headlinePanel;
	
	//文本框声明为成员变量的原因是在按钮单击时，需要从文本框里取值给emp
	private JTextField idText;
	private JPasswordField pasText;
	
	private Font font;

	public LoginView(){

		this.setDisplay();
		getContentPane().add(headlinePanel);
		getContentPane().add(idPanel);
		getContentPane().add(pasPanel);
		getContentPane().add(buttonPanel);
		
		
		this.setTitle("学籍管理系统");
		this.setSize(500,300);
		
		//设置网格布局 参数1代表行，参数2代表列
		getContentPane().setLayout(new GridLayout(4, 1));
		this.setResizable(false);//设置能否调整窗口大小，false不能调整大小
		
		this.setLocationRelativeTo(null);//设置窗口相对于指定组件的位置，如果组件当前未显示，或者 c 为 null，则此窗口将置于屏幕的中央
		this.setVisible(true);//当前窗口可见
		
	}
	
	//初期化各控件
	public void setDisplay(){
		this.setPanel();
		this.setFont();
		this.setLabel();
		this.setButton();
		this.setTextField();
	}
	
	//设置输入文本域
	public void setTextField(){
		// 设置文本框
		idText = new JTextField(10);
		idText.setFont(font);
		
		pasText = new JPasswordField(10);
		pasText.setFont(font);
		pasText.setEchoChar('*');
		
		pasText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ee) {
				//KeyEvent.VK_ENTER：等价于回车键按下
				if (ee.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin();//自定义方法卡号和密码是否存在
				}
			}
		});
		//JPanel里添加文本框
		idPanel.add(idText);
		pasPanel.add(pasText);
	}
	
	// 设置面板
	public void setPanel() {
		this.idPanel=new JPanel();
		this.idPanel.setLayout(new FlowLayout());
		this.pasPanel=new JPanel();
		this.pasPanel.setLayout(new FlowLayout());
		
		this.buttonPanel=new JPanel();
		this.buttonPanel.setLayout(new FlowLayout());
		
		this.headlinePanel=new JPanel();
		this.headlinePanel.setLayout(new FlowLayout());	
	}
	
	//设置字体
	public void setFont(){
		font=new Font("楷体", Font.PLAIN, 20);
	}
	
	//设置标签
	public void setLabel(){
		//设置员工标签
		JLabel idLabel=new JLabel("帐号：");
		idLabel.setFont(font);
		idPanel.add(idLabel);//标签必须要加到panel里
		
		//设置密码标签
		JLabel pasLabel=new JLabel("密码：");
		pasLabel.setFont(font);
		pasPanel.add(pasLabel);//标签必须要加到panel里
		
		//设置显示文字;
		JLabel headline = new JLabel("学籍管理系统");
		headline.setFont(new Font("楷体", Font.PLAIN, 40));
		headlinePanel.add(headline);
	}
	
	//设置按钮
	public void setButton(){
		JButton regisiter=new JButton("注册");
		JButton submit=new JButton("登录");
		regisiter.addMouseListener(new MouseAdapter() 
		{public void mouseClicked(MouseEvent e) {
			regisiter();
		}});
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkLogin();
			}
		});
		JButton exit=new JButton("退出");
		
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		buttonPanel.add(regisiter);
		buttonPanel.add(submit);
		buttonPanel.add(exit);
	}
	public 	void regisiter(){
		String id = String.valueOf(idText.getText());
		String pas = String.valueOf(pasText.getPassword());
		DBConnection db=new DBConnection();
		Connection conn =db.getConn();
		Impl impl = new Impl();
		try{
			if(impl.register(id, pas, conn)){
			
				JOptionPane.showMessageDialog(null, "注册成功", "Register",
						JOptionPane.PLAIN_MESSAGE);
				idText.setText(null);
				pasText.setText(null);
				
				} else {
					JOptionPane.showMessageDialog(null, "用户名重复", "登陆错误",
							JOptionPane.ERROR_MESSAGE);
				}

				}catch(Exception e){
					e.printStackTrace();
					}
				}


	
	// 判断员工号和密码是否正确，并且根据不同的权限跳转相应的页面
	public void checkLogin() {
		// 从输入框里取得数据设置到成员变量emp上
		String id = String.valueOf(idText.getText());
		String pas = String.valueOf(pasText.getPassword());
		DBConnection db=new DBConnection();
		Connection conn =db.getConn();
		Impl impl = new Impl();
		try{
		if(impl.check(id, pas, conn)){
		this.setVisible(false);// 当前窗口不可见
		new AdminView();
		} else {
			JOptionPane.showMessageDialog(null, "用户名不存在或密码不正确", "登陆错误",
					JOptionPane.ERROR_MESSAGE);
		}

		}catch(Exception e){
			e.printStackTrace();
			}
		}

}
