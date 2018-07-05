package view;

import javax.swing.*;

import java.awt.*;

import javax.swing.*;

import common.Student;
import dao.Impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StudentEditDialog extends  JInternalFrame {
	
	
		private JPanel panel1,panel2,panel3,panel4,panel5;
		private JLabel jl_sno, jl_sname,jl_sex, jl_dept,jl_record,jl_flag,jl_nationality,jl_age,jl_year,jl_political,jl_address;
		private JTextField jt_sno,jt_sname,jt_record,jt_flag,jt_sex, jt_dept,jt_age,jt_nationality,jt_year,jt_political,jt_address;
		private JButton ok;
		private JButton cancel;
		private Student stu;
		private Impl impl=new Impl();
		StudentEditDialog(){
			super("学生信息修改",true,true,false,true);
		jl_sno=new JLabel("ID");
		jt_sno=new JTextField(15);
		jl_sname=new JLabel("姓 名");
		jt_sname=new JTextField(15);
		jl_sex=new JLabel("性别");
		jt_sex=new JTextField(15);
		jl_dept=new JLabel("系");
		jt_dept=new JTextField(15);
		jl_age=new JLabel("年龄");
		jt_age=new JTextField(15);
		jl_political=new JLabel("政治面貌");
		jt_political=new JTextField(15);
		jl_address=new JLabel("地区");
		jt_address=new JTextField(15);		
		jl_year=new JLabel("学制");
		jt_year=new JTextField(15);				
		jl_nationality=new JLabel("民族");
		jt_nationality=new JTextField(15);	
		jl_record=new JLabel("奖惩记录");
		jt_record=new JTextField(15);	
		jl_flag=new JLabel("休复转退标记");
		jt_flag=new JTextField(15);	
		panel1=new JPanel(new GridLayout(11,1));
		panel1.add(jl_sno);		
		panel1.add(jl_age);
		panel1.add(jl_sname);
		panel1.add(jl_sex);
		panel1.add(jl_year);
		panel1.add(jl_address);
		panel1.add(jl_dept);
		panel1.add(jl_political);
		panel1.add(jl_nationality);
		panel1.add(jl_record);
		panel1.add(jl_flag);

		
		panel2=new JPanel(new GridLayout(11,1));
		panel2.add(jt_sno);		
		panel2.add(jt_age);
		panel2.add(jt_sname);
		panel2.add(jt_sex);
		panel2.add(jt_year);
		panel2.add(jt_address);
		panel2.add(jt_dept);
		panel2.add(jt_political);
		panel2.add(jt_nationality);
		panel2.add(jt_record);
		panel2.add(jt_flag);

		panel3=new JPanel(new GridLayout(1,2));
		panel3.add(panel1);
		panel3.add(panel2);
		
		ok=new JButton("确定");
		ok.addActionListener((e)->{
			stu=new Student();
			
			
			
				stu.setId(jt_sno.getText().trim());	
				stu.setAge(Integer.parseInt(jt_age.getText().trim()));
				stu.setName( jt_sname.getText().trim());
				stu.setSex(jt_sex.getText().trim());
				stu.setYear(Integer.parseInt(jt_year.getText().trim()));
				stu.setAddress(jt_address.getText().trim());
				stu.setDept(jt_dept.getText().trim());
				stu.setPolitical(jt_political.getText().trim());
				stu.setNationality(jt_nationality.getText().trim());
				stu.setRecord(jt_record.getText().trim());
				stu.setFlag(jt_flag.getText().trim());
				
				
				
				if (impl.modify(stu) == false) {
					JOptionPane.showMessageDialog(null, "修改失败", "Edition",
							JOptionPane.ERROR_MESSAGE);
					jt_sno.setText(null);
					jt_age.setText(null);
					jt_sname.setText(null);
					jt_sex.setText(null); 
					jt_year.setText(null);
					jt_address.setText(null);
					jt_dept.setText(null);
					jt_political.setText(null);
					jt_nationality.setText(null);
					jt_record.setText(null);
					jt_flag.setText(null);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "修改成功", "Edition",
							JOptionPane.PLAIN_MESSAGE);
					this.dispose();
				}
		});
		cancel=new JButton("取消");
		cancel.addActionListener((e)->{
			jt_sno.setText(null);
			jt_sname.setText(null);
			jt_sex.setText(null);
			jt_age.setText(null);
			jt_dept.setText(null);	
		});
		panel4=new JPanel();
		panel4.add(ok);
		panel4.add(cancel);
		this.setLayout(new BorderLayout());
		this.add(panel3,BorderLayout.CENTER);
		this.add(panel4,BorderLayout.SOUTH);

		this.setSize(600, 400);
		this.setVisible(true);
		}
}

