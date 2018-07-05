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
import common.Student;
import common.TableUtil;
import dao.Impl;

public class CourseView extends JInternalFrame{
	JTable detail;
	DefaultTableModel model;
	JPanel Jbutton;
public CourseView(){
		super("课程信息",true,true,false,true);
		Impl impl = new Impl();
		List<Object[]> ls = impl.selectClass();
		String[] title = {"课程号","课程名","学分"};
		JPanel tablePanel = TableUtil.setTableData(detail, ls,title);
		model = TableUtil.getModel();
		getContentPane().add(tablePanel);
		setButton();
		getContentPane().setLayout(new GridLayout(2,1));
		this.setSize(600, 500);
		this.setVisible(true);
		
	}

	private void setButton() {
		JButton addButton = new JButton("添加课程");
		addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				Object[] rowdata = new Object[model.getColumnCount()];
				model.addRow(rowdata);
			}
		});

		JButton delButton = new JButton("删除课程");
		delButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				JTable table=TableUtil.getTable();
				int selectRow=table.getSelectedRow();
				Impl impl=new Impl();
				String id=(String)model.getValueAt(selectRow, 0);			
				if(impl.deleteClass(id)){
					model.removeRow(selectRow);
					model.fireTableDataChanged();
					JOptionPane.showMessageDialog(null, "删除课程信息成功", "Addition",
							JOptionPane.PLAIN_MESSAGE);
					int oldrow = TableUtil.getOldrow();
					TableUtil.setOldrow(oldrow-1);
					}
				else {
					JOptionPane.showMessageDialog(null, "删除课程信息失败", "Addition",
							JOptionPane.WARNING_MESSAGE);
				
			}
				
				

			}});	
		JButton confirmAddButton = new JButton("确定");
		confirmAddButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				int oldrow = TableUtil.getOldrow();
				int newrow = model.getRowCount();	
				List<Course> ls = new ArrayList<Course>();
				for (int i = oldrow;i<newrow;i++){
					Course c=new Course();
					c.setCno((String)model.getValueAt(i, 0));
					c.setCname((String)model.getValueAt(i, 1));
					String credit=(String)model.getValueAt(i, 2);
					c.setCredit(Integer.parseInt(credit));
					
					ls.add(c);
					Impl impl = new Impl();
					if(impl.insertClass(ls)){
						JOptionPane.showMessageDialog(null, "添加课程信息成功", "Addition",
								JOptionPane.PLAIN_MESSAGE);
					TableUtil.setOldrow(oldrow+1);}
					else {
						JOptionPane.showMessageDialog(null, "添加课程信息失败", "Addition",
								JOptionPane.WARNING_MESSAGE);
						JTable table=TableUtil.getTable();
						model.removeRow(table.getRowCount()-1);
					}
					
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
