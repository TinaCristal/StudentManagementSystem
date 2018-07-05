package view;



import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import common.TableUtil;
import dao.Impl;

public class SortByPoliticalView extends JInternalFrame {
	JTable table=new JTable();
	public SortByPoliticalView(){
		super("按政治面貌统计人数",true,true,false,true);
		Impl impl = new Impl();
		List<Object[]> ls = impl.sortByPolitical();
		String[] title = {"政治面貌","人数"};
		JPanel tablePanel = TableUtil.setTableData(table, ls,title);
		this.getContentPane().add(tablePanel);
		this.setVisible(true);
		this.setSize(600, 400);
	}
}
