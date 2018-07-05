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
	
	//�ı�������Ϊ��Ա������ԭ�����ڰ�ť����ʱ����Ҫ���ı�����ȡֵ��emp
	private JTextField idText;
	private JPasswordField pasText;
	
	private Font font;

	public LoginView(){

		this.setDisplay();
		getContentPane().add(headlinePanel);
		getContentPane().add(idPanel);
		getContentPane().add(pasPanel);
		getContentPane().add(buttonPanel);
		
		
		this.setTitle("ѧ������ϵͳ");
		this.setSize(500,300);
		
		//�������񲼾� ����1�����У�����2������
		getContentPane().setLayout(new GridLayout(4, 1));
		this.setResizable(false);//�����ܷ�������ڴ�С��false���ܵ�����С
		
		this.setLocationRelativeTo(null);//���ô��������ָ�������λ�ã���������ǰδ��ʾ������ c Ϊ null����˴��ڽ�������Ļ������
		this.setVisible(true);//��ǰ���ڿɼ�
		
	}
	
	//���ڻ����ؼ�
	public void setDisplay(){
		this.setPanel();
		this.setFont();
		this.setLabel();
		this.setButton();
		this.setTextField();
	}
	
	//���������ı���
	public void setTextField(){
		// �����ı���
		idText = new JTextField(10);
		idText.setFont(font);
		
		pasText = new JPasswordField(10);
		pasText.setFont(font);
		pasText.setEchoChar('*');
		
		pasText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ee) {
				//KeyEvent.VK_ENTER���ȼ��ڻس�������
				if (ee.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin();//�Զ��巽�����ź������Ƿ����
				}
			}
		});
		//JPanel������ı���
		idPanel.add(idText);
		pasPanel.add(pasText);
	}
	
	// �������
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
	
	//��������
	public void setFont(){
		font=new Font("����", Font.PLAIN, 20);
	}
	
	//���ñ�ǩ
	public void setLabel(){
		//����Ա����ǩ
		JLabel idLabel=new JLabel("�ʺţ�");
		idLabel.setFont(font);
		idPanel.add(idLabel);//��ǩ����Ҫ�ӵ�panel��
		
		//���������ǩ
		JLabel pasLabel=new JLabel("���룺");
		pasLabel.setFont(font);
		pasPanel.add(pasLabel);//��ǩ����Ҫ�ӵ�panel��
		
		//������ʾ����;
		JLabel headline = new JLabel("ѧ������ϵͳ");
		headline.setFont(new Font("����", Font.PLAIN, 40));
		headlinePanel.add(headline);
	}
	
	//���ð�ť
	public void setButton(){
		JButton regisiter=new JButton("ע��");
		JButton submit=new JButton("��¼");
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
		JButton exit=new JButton("�˳�");
		
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
			
				JOptionPane.showMessageDialog(null, "ע��ɹ�", "Register",
						JOptionPane.PLAIN_MESSAGE);
				idText.setText(null);
				pasText.setText(null);
				
				} else {
					JOptionPane.showMessageDialog(null, "�û����ظ�", "��½����",
							JOptionPane.ERROR_MESSAGE);
				}

				}catch(Exception e){
					e.printStackTrace();
					}
				}


	
	// �ж�Ա���ź������Ƿ���ȷ�����Ҹ��ݲ�ͬ��Ȩ����ת��Ӧ��ҳ��
	public void checkLogin() {
		// ���������ȡ���������õ���Ա����emp��
		String id = String.valueOf(idText.getText());
		String pas = String.valueOf(pasText.getPassword());
		DBConnection db=new DBConnection();
		Connection conn =db.getConn();
		Impl impl = new Impl();
		try{
		if(impl.check(id, pas, conn)){
		this.setVisible(false);// ��ǰ���ڲ��ɼ�
		new AdminView();
		} else {
			JOptionPane.showMessageDialog(null, "�û��������ڻ����벻��ȷ", "��½����",
					JOptionPane.ERROR_MESSAGE);
		}

		}catch(Exception e){
			e.printStackTrace();
			}
		}

}
