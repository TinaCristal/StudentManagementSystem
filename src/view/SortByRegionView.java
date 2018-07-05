package view;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import common.Course;
import common.Student;
import common.TableUtil;
import dao.Impl;

public class SortByRegionView extends JInternalFrame{
	JTable detail;
public SortByRegionView(){
		super("��������Դͳ������",true,true,false,true);
		Impl impl = new Impl();
		List<Object[]> ls = impl.sortByRegion();
		String[] title = {"����","����"};
		JPanel tablePanel = TableUtil.setTableData(detail, ls,title);
		getContentPane().add(tablePanel);
		this.setSize(600, 400);
		this.setVisible(true);
		
	}}
