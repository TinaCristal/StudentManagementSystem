package view;


import javax.swing.*;

import java.awt.*;

import common.StudentCourse;
import dao.Impl;



public class GradeEditDialog extends  JInternalFrame {
		private JPanel panel1,panel2,panel3,panel4;
		private JLabel jl_sno, jl_cno,jl_grade;
		private JTextField jt_sno,jt_cno,jt_grade;
		private JButton ok;
		private JButton cancel;
		private StudentCourse sc;
		private Impl impl=new Impl();
		GradeEditDialog(){
			super("学生成绩修改",true,true,false,true);
		jl_sno=new JLabel("ID");
		jt_sno=new JTextField(15);
		
		jl_cno=new JLabel("课序号");
		jt_cno=new JTextField(15);	
		jl_grade=new JLabel("成绩");
		jt_grade=new JTextField(15);	
		panel1=new JPanel(new GridLayout(3,1));
		panel1.add(jl_sno);		
		panel1.add(jl_cno);
		panel1.add(jl_grade);
		

		
		panel2=new JPanel(new GridLayout(3,1));
		panel2.add(jt_sno);		
		panel2.add(jt_cno);
		panel2.add(jt_grade);

		panel3=new JPanel(new GridLayout(1,2));
		panel3.add(panel1);
		panel3.add(panel2);
		
		ok=new JButton("确定");
		ok.addActionListener((e)->{
			sc=new StudentCourse();
			
			
			
				sc.setId(jt_sno.getText().trim());	
				sc.setCno(jt_cno.getText().trim());
				
				sc.setGrade(Integer.parseInt(jt_grade.getText().trim()));
			
				
				if (impl.modify(sc) == false) {
					JOptionPane.showMessageDialog(null, "修改失败", "Edition",
							JOptionPane.ERROR_MESSAGE);
					jt_sno.setText(null);
					jt_cno.setText(null);
					jt_grade.setText(null);
					
					
					
				} else {
					JOptionPane.showMessageDialog(null, "修改成功", "Edition",
							JOptionPane.PLAIN_MESSAGE);
					this.dispose();
				}
		});
		cancel=new JButton("取消");
		cancel.addActionListener((e)->{
			jt_sno.setText(null);
			jt_cno.setText(null);
			jt_grade.setText(null);
			
		});
		panel4=new JPanel();
		panel4.add(ok);
		panel4.add(cancel);
		this.setLayout(new BorderLayout());
		this.add(panel3,BorderLayout.CENTER);
		this.add(panel4,BorderLayout.SOUTH);
		this.setSize(400, 300);
		this.setVisible(true);
		}
}

