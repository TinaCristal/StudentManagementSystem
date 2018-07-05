package common;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableUtil {
	static DefaultTableModel model;
	static int oldrow;
	private static JTable table;
	public static JPanel setTableData(JTable detail,List<Object[]> ls,String[] title){
		model = new DefaultTableModel();
		model.setColumnIdentifiers(title);
		detail = new JTable(model);
		table=detail;
		JScrollPane jsp = new JScrollPane(detail);
		jsp.setPreferredSize(new Dimension(560, detail.getRowHeight()*20));
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new FlowLayout());
		tablePanel.add(jsp);
		for (int i = 0; i < ls.size();i++){
			model.addRow(ls.get(i));
		}
		oldrow = ls.size();
		return tablePanel;
	}
	public static DefaultTableModel getModel(){
		return model;
		
	}
public static JTable getTable()
{
	return table;
}
	public static int getOldrow(){
		return oldrow;
	}
	public static void setOldrow(int row){
		oldrow=row;
	}
	
}
