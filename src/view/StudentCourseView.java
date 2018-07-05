package view;


import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import common.Course;

import common.StudentCourse;
import common.TableUtil;
import dao.Impl;

public class StudentCourseView extends JInternalFrame{
	JTable detail;
	DefaultTableModel model;
	JPanel Jbutton;
public StudentCourseView(){
		super("ѧ��ѡ����Ϣ",true,true,false,true);
		Impl impl = new Impl();
		List<Object[]> ls = impl.selectGrade();
		String[] title = {"ѧ��","�γ̺�","�ɼ�"};
		JPanel tablePanel = TableUtil.setTableData(detail, ls,title);
		model = TableUtil.getModel();
		getContentPane().add(tablePanel);
		setButton();
		getContentPane().setLayout(new GridLayout(2,1));
		this.setSize(600, 500);
		this.setVisible(true);
		
	}

	private void setButton() {
		JButton addButton = new JButton("���ѧ���ɼ�");
		addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				Object[] rowdata = new Object[model.getColumnCount()];
				model.addRow(rowdata);
			}
		});

		JButton delButton = new JButton("ɾ��ѧ���ɼ�");
		delButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				JTable table=TableUtil.getTable();
				int selectRow=table.getSelectedRow();
				Impl impl=new Impl();
				String id=(String)model.getValueAt(selectRow, 0);
				String cno=(String)model.getValueAt(selectRow, 1);
				
				if(impl.deleteGrade(id,cno)){
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
				List<StudentCourse> ls = new ArrayList<StudentCourse>();
				for (int i = oldrow;i<newrow;i++){
					StudentCourse sc=new StudentCourse();
					sc.setId((String)model.getValueAt(i, 0));
					sc.setCno((String)model.getValueAt(i, 1));
					String grade=(String)model.getValueAt(i, 2);
					sc.setGrade(Integer.parseInt(grade));
					ls.add(sc);
				}
				Impl impl = new Impl();
				
				if(impl.insertGrade(ls))
				{
					JOptionPane.showMessageDialog(null, "��ӳɼ���Ϣ�ɹ�", "Addition",
							JOptionPane.PLAIN_MESSAGE);
				TableUtil.setOldrow(oldrow+1);}
				else {
					JOptionPane.showMessageDialog(null, "��ӳɼ���Ϣʧ��", "Addition",
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
