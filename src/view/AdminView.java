package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import common.Common;
import dao.Impl;


public class AdminView extends JFrame {

	JDesktopPane desk;
	public AdminView(){
	
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		JMenu menu1 = new JMenu("������Ϣ�Ǽ��޸�");
		JMenuItem item1_1 = new JMenuItem("ѧ����Ϣ");
		item1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desk.add(new StudentView());
			}
		});
		JMenuItem item1_2 = new JMenuItem("�γ���Ϣ");
		item1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desk.add(new CourseView());
			}
		});
		JMenuItem item1_3 = new JMenuItem("ѧ���ɼ���Ϣ");
		item1_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desk.add(new StudentCourseView());
			}
		});
		menu1.add(item1_1);
		menu1.add(item1_2);
		menu1.add(item1_3);
		menubar.add(menu1);
		JMenu menu2 = new JMenu("������Ϣ����");
		
		
		JMenuItem item2_1 = new JMenuItem("ѧ����Ϣ����");
		
		item2_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desk.add(new StudentEditDialog());
			}
		});
		
		
		JMenuItem item2_2 = new JMenuItem("ѧ���ɼ�����");
		
		item2_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desk.add(new GradeEditDialog());
			}
		});
		
		
		
		menu2.add(item2_1);
		menu2.add(item2_2);
		menubar.add(menu2);
		JMenu menu3 = new JMenu("������Ϣ��ѯ");
		JMenuItem item3_1 = new JMenuItem("������ͳ������");
		item3_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desk.add(new SortByAgeView());
			}
		});
		
		
		
		JMenuItem item3_2 = new JMenuItem("��������Դͳ������");
		
		item3_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desk.add(new SortByRegionView());
			}
		});
		JMenuItem item3_3 = new JMenuItem("��������òͳ������");
		item3_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desk.add(new SortByPoliticalView());
			}
		});
		
		JMenuItem item3_4 = new JMenuItem("ͳ�Ƹ�רҵĳ�ſε�ѧϰ�ɼ����");
		item3_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desk.add(new SortGradeView());
			}
		});
		
		menu3.add(item3_1);
		menu3.add(item3_2);
		menu3.add(item3_3);
		menu3.add(item3_4);
		menubar.add(menu3);
		desk = Common.setDesk("picture/2.jpg");
		getContentPane().add(desk);
		this.setTitle("����Ա��¼");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}
	
	
}
