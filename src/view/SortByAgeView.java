package view;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import common.TableUtil;
import dao.Impl;
public class SortByAgeView extends JInternalFrame {
	JTable table=new JTable();
	public SortByAgeView(){
		super("按年龄统计人数",true,true,false,true);
		Impl impl = new Impl();
		List<Object[]> ls = impl.sortByAge();
		String[] title = {"年龄","人数"};
		JPanel tablePanel = TableUtil.setTableData(table, ls,title);
		this.getContentPane().add(tablePanel);
		this.setVisible(true);
		this.setSize(600, 400);
	}
}
