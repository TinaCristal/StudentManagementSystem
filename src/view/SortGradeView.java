package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;

import common.TableUtil;
import dao.Impl;
class Major{
	
	String major=new String();
	int[] level=new int[5];
}
public class SortGradeView extends JInternalFrame {
	private JTable detail_1;
	private JTable detail_2;
	public SortGradeView(){
		super("统计成绩",true,true,false,true);
		String cno = JOptionPane.showInputDialog("输入课序号");
		Impl impl = new Impl();
		List<Object[]> ls = impl.groupGrade(cno);
		String[] title = {"学号","姓名","系","成绩"};
		JPanel tablePanel = TableUtil.setTableData(detail_1, ls,title);
		 HashSet<String> hs=new HashSet<String>();
	  for(Object[] o:ls)
		{
		  if(!hs.contains((String)o[2]))
			hs.add((String)o[2]);
		}
	 Major[] m=new Major[hs.size()];

	
	 int i=0;
Iterator<String> it=hs.iterator();
while(it.hasNext())
{
	  m[i]=new Major();
	String s=it.next();
	m[i].major=s;
	for(int j=0;j<5;j++)
	m[i].level[j]=0;
	i++;	
}

	  for(Object[] o:ls)
			{
			String major=(String)o[2];
			for(Major mj:m){
				if(major.equals(mj.major)){
				int grade=Integer.valueOf((String)o[3]);
				
				if(grade>=90&&grade<=100)
					mj.level[0] +=1;
				else if(grade>=80&&grade<90)
					mj.level[1]+=1;
				else if((grade>=70&&grade<80))
					mj.level[2]+=1;
				else if(grade>=60&&grade<70)
					mj.level[3]+=1;
				else if(grade<60)
					mj.level[4]+=1;		
				}
			}
			}

	  List<Object[]> li=new ArrayList<Object[]>();
	  
	  for(Major mj:m)
	  {
		  String[] nums=new String[6];
	  nums[0]=mj.major;
			for(int j=1;j<6;j++)
				nums[j]=String.valueOf(mj.level[j-1]);
			li.add(nums);
	  }
		String[] name = {"   ","90-100","80-90","70-80","60-70","<60"};
		JPanel Panel = TableUtil.setTableData(detail_2, li,name);
		JPanel mainPanel=new JPanel(new GridLayout(2,1));
		 mainPanel.add(tablePanel);
		 mainPanel.add(Panel);
		 this.getContentPane().add(mainPanel);
		 this.setVisible(true);
		 this.setSize(600, 400);
	 
	
	
	
	}
	
}
