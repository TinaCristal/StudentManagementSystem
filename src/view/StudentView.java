package view;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import common.*;
import dao.Impl;


public class StudentView extends JInternalFrame {
	JTable detail;
	DefaultTableModel model;
	JPanel Jbutton;
public StudentView(){
		super("ѧ����Ϣ",true,true,false,true);
		Impl impl = new Impl();
		List<Object[]> ls = impl.selectStu();
		String[] title = {"ID","����","����","�Ա�","ѧ��","��ַ","����ϵ","������ò","����","���ͱ��","�ݸ�ת�˱��"};
		JPanel tablePanel = TableUtil.setTableData(detail, ls,title);
		model = TableUtil.getModel();
		getContentPane().add(tablePanel);
		setButton();
		getContentPane().setLayout(new GridLayout(2,1));
		this.setSize(600, 500);
		this.setVisible(true);
		
	}

	private void setButton() {
		JButton addButton = new JButton("���ѧ��");
		addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				Object[] rowdata = new Object[model.getColumnCount()];
				model.addRow(rowdata);
			}
		});

		JButton delButton = new JButton("ɾ��ѧ��");
		delButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				JTable table=TableUtil.getTable();
				int selectRow=table.getSelectedRow();
				Impl impl=new Impl();
				String id=(String)model.getValueAt(selectRow, 0);
			
				
				
				
				if(impl.deleteStu(id)){
					model.removeRow(selectRow);
					model.fireTableDataChanged();
					JOptionPane.showMessageDialog(null, "ɾ��ѧ����Ϣ�ɹ�", "Addition",
							JOptionPane.PLAIN_MESSAGE);
					int oldrow = TableUtil.getOldrow();
					TableUtil.setOldrow(oldrow-1);
					}
				else {
					JOptionPane.showMessageDialog(null, "ɾ��ѧ����Ϣʧ��", "Addition",
							JOptionPane.WARNING_MESSAGE);
				
			}
				
				
			
			}});	
		JButton confirmAddButton = new JButton("ȷ��");
		confirmAddButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				int oldrow = TableUtil.getOldrow();
				int newrow = model.getRowCount();			
				Student stu = null;
				List<Student> ls = new ArrayList<Student>();
				for (int i = oldrow;i<newrow;i++){
					System.out.println((String)model.getValueAt(i, 0));
					stu = new Student();
					stu.setId((String)model.getValueAt(i, 0));
					String age=(String)model.getValueAt(i, 1);
					stu.setAge(Integer.parseInt(age));
					stu.setName((String)model.getValueAt(i, 2));
					stu.setSex((String)model.getValueAt(i, 3));					
					String year=(String)model.getValueAt(i, 4);
					stu.setYear(Integer.parseInt(year));
					stu.setAddress((String)model.getValueAt(i, 5));
					stu.setDept((String)model.getValueAt(i, 6));
					stu.setPolitical((String)model.getValueAt(i, 7));
					stu.setNationality((String)model.getValueAt(i, 8));
					stu.setRecord((String)model.getValueAt(i, 9));
					stu.setFlag((String)model.getValueAt(i, 10));
					ls.add(stu);
					
				}
				Impl impl = new Impl();
				if(impl.insertStu(ls)){
					JOptionPane.showMessageDialog(null, "���ѧ����Ϣ�ɹ�", "Addition",
							JOptionPane.PLAIN_MESSAGE);
				TableUtil.setOldrow(oldrow+1);}
				else {
					JOptionPane.showMessageDialog(null, "���ѧ����Ϣʧ��", "Addition",
							JOptionPane.WARNING_MESSAGE);
					JTable table=TableUtil.getTable();
					model.removeRow(table.getRowCount()-1);
				}
				
			}
		});
		Jbutton = new JPanel();
		Jbutton.add(addButton);
		Jbutton.add(delButton);
		Jbutton.add(confirmAddButton);
		getContentPane().add(Jbutton);
}
	

}
