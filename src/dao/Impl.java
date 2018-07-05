package dao;

import java.sql.*;
import java.util.*;

import common.*;



public class Impl {
	public List<Object[]> groupGrade(String cno)
	{
		Connection conn=new DBConnection().getConn();
		List<Object[]> data = null;
		String sql="select student.id,name,dept,grade from student,sc where student.id=sc.id and cno=? ;";
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,cno);
			rs = pre.executeQuery();
			data = new ArrayList<Object[]>();
			while(rs.next()){
				Object[] rowData=new Object[4];
				rowData[0] = rs.getString("id");
				rowData[1] = rs.getString("name");
				rowData[2] = rs.getString("dept");
				rowData[3] = rs.getString("grade");
				conn.setAutoCommit(true);
				//加入集合
				data.add(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	
	}
	public List<Object[]> sortByAge() {
		Connection conn=new DBConnection().getConn();
		List<Object[]> data = null;
		String sql = "select age,count(*) from Student group by age";
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			rs = pre.executeQuery(sql);
			data = new ArrayList<Object[]>();
			while(rs.next()){
				Object[] rowData=new Object[2];
				rowData[0] = rs.getString("age");
				rowData[1] = rs.getString("count(*)");
				conn.setAutoCommit(true);
				//加入集合
				data.add(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	public List<Object[]> sortByRegion() {
		Connection conn=new DBConnection().getConn();
		List<Object[]> data = null;
		String sql = "select address,count(*) from Student group by address";
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			rs = pre.executeQuery(sql);
			data = new ArrayList<Object[]>();
			while(rs.next()){
				Object[] rowData=new Object[2];
				rowData[0] = rs.getString("address");
				rowData[1] = rs.getString("count(*)");
				conn.setAutoCommit(true);
				//加入集合
				data.add(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	public boolean modify(Student s)
	{
		
		Connection conn=new DBConnection().getConn();
		String sql = "update student set id=?,age=?,name=?,sex=?,year=?,address=?,dept=?,political=?,nationality=?,record=?,flag=? where id=?";
		int flag=0;
		PreparedStatement pre=null;
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,s.getId());
			pre.setInt(2,s.getAge());
			pre.setString(3,s.getName());
			pre.setString(4,s.getSex());
			pre.setInt(5,s.getYear());
			pre.setString(6,s.getAddress());
			pre.setString(7,s.getDept());
			pre.setString(8,s.getPolitical());
			pre.setString(9,s.getNationality());
			pre.setString(10,s.getRecord());
			pre.setString(11, s.getFlag());
			pre.setString(12, s.getId());
			flag=pre.executeUpdate();
		if (pre!= null)pre.close();
		if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
			if(flag!=0) return true;
			else return  false;


	}
	public boolean modify(StudentCourse sc)
	{
		
		Connection conn=new DBConnection().getConn();
		int flag=0;
		String sql = "update SC set id=?,cno=?,grade=? where id=? and cno=?";
		PreparedStatement pre=null;
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,sc.getId());
			pre.setString(2,sc.getCno());
			pre.setInt(3,sc.getGrade());
			pre.setString(4,sc.getId());
			pre.setString(5, sc.getCno());
			flag=pre.executeUpdate();
		if (pre!= null)pre.close();
		if(conn!=null) conn.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
			if(flag!=0) return true;
			else return  false;

		
	}	
	
		
		
	
	public List<Object[]> sortByPolitical() {
		Connection conn=new DBConnection().getConn();
		List<Object[]> data = null;
		String sql = "select political,count(*) from Student group by political";
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			rs = pre.executeQuery(sql);
			data = new ArrayList<Object[]>();
			while(rs.next()){
				Object[] rowData=new Object[2];
				rowData[0] = rs.getString("political");
				rowData[1] = rs.getString("count(*)");
				conn.setAutoCommit(true);
				//加入集合
				data.add(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public List<Object[]> selectStu() {
		Connection conn=new DBConnection().getConn();
		List<Object[]> data = null;
		String sql = "select * from student";
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			rs = pre.executeQuery(sql);
			data = new ArrayList<Object[]>();
			while(rs.next()){
				Object[] rowData=new Object[13];
				rowData[0] = rs.getString("id");
				rowData[1] = rs.getInt("age");
				rowData[2] = rs.getString("name");
				rowData[3] = rs.getString("sex");
				rowData[4] = rs.getInt("year");
				rowData[5] = rs.getString("address");
				rowData[6] = rs.getString("dept");	
				rowData[7] = rs.getString("political");	
				rowData[8] = rs.getString("nationality");	
				rowData[9] = rs.getString("record");	
				rowData[10] = rs.getString("flag");	
				conn.setAutoCommit(true);
				//加入集合
				data.add(rowData);
				//if (pre!= null)pre.close();
				//if(rs!=null) rs.close();
				//if(conn!=null) conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	public List<Object[]> selectClass() {
		Connection conn=new DBConnection().getConn();
		List<Object[]> data = null;
		String sql = "select * from course";
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			rs = pre.executeQuery(sql);
			data = new ArrayList<Object[]>();
			while(rs.next()){
				Object[] rowData=new Object[3];
				rowData[0] = rs.getString("cno");
				rowData[1] = rs.getString("cname");
				rowData[2] = rs.getInt("credit");
	
				conn.setAutoCommit(true);
				//加入集合
				data.add(rowData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	public List<Object[]> selectGrade() {
		Connection conn=new DBConnection().getConn();
		List<Object[]> data = null;
		String sql = "select * from SC";
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			rs = pre.executeQuery(sql);
			data = new ArrayList<Object[]>();
			while(rs.next()){
				Object[] rowData=new Object[3];
				rowData[0] = rs.getString("id");
				rowData[1] = rs.getString("cno");
				rowData[2] = rs.getInt("grade");
	
				conn.setAutoCommit(true);
				//加入集合
				data.add(rowData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	public  boolean check(String id,String pwd,Connection conn){
		
		PreparedStatement pre=null;
		ResultSet rs=null;
		String password=null;
		try {
			//创建sql语句
			String sql="select pwd from tb_admin where id=?";
			pre=conn.prepareStatement(sql);
			//动态传递参数并执行sql语句
			pre.setString(1,id);
			rs=pre.executeQuery();
			while(rs.next())
			password = rs.getString("pwd");
			if(pwd.equals(password)) 
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
public  boolean register(String id,String pwd,Connection conn){
		
		PreparedStatement pre=null;
		try {
			//创建sql语句
			String sql="insert into tb_admin values (?,?)";
			pre=conn.prepareStatement(sql);
			//动态传递参数并执行sql语句
			pre.setString(1,id);
			pre.setString(2, pwd);
			pre.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean deleteStu(String id)
	{
		Connection conn=new DBConnection().getConn();
		 PreparedStatement pre=null;
		String sql = "delete from student where id=?";
		try {
			conn.setAutoCommit(false);
			pre = conn.prepareStatement(sql);
			pre.setString(1,id);
			pre.execute();
			conn.setAutoCommit(true);
			if (pre!= null)pre.close();
			if(conn!=null) conn.close();
			return true;
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();}
			return false;
		
	}

	public boolean deleteGrade(String id,String cno)
	{
		Connection conn=new DBConnection().getConn();
		 PreparedStatement pre=null;
		String sql = "delete from SC where id=? and cno=?";
		try {
			conn.setAutoCommit(false);
			pre = conn.prepareStatement(sql);
			pre.setString(1,id);
			pre.setString(2, cno);
			pre.execute();
			conn.setAutoCommit(true);
			if (pre!= null)pre.close();
			if(conn!=null) conn.close();
			return true;
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();}
			return false;
		
	}
	public boolean deleteClass(String id)
	{
		Connection conn=new DBConnection().getConn();
		 PreparedStatement pre=null;
		String sql = "delete from course where cno=?";
		try {
			conn.setAutoCommit(false);
			pre = conn.prepareStatement(sql);
			pre.setString(1,id);
			pre.execute();
			conn.setAutoCommit(true);
			if (pre!= null)pre.close();
			if(conn!=null) conn.close();
			return true;
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();}
			return false;
		
	}
	
	
	
	public boolean insertGrade(List<StudentCourse> ls){
		Connection conn=new DBConnection().getConn();
		 PreparedStatement pre=null;
		String sql = "insert into SC values(?,?,?)";
		try {
			conn.setAutoCommit(false);
			pre = conn.prepareStatement(sql);
			for (StudentCourse sc:ls){
				pre=conn.prepareStatement(sql);
				pre.setString(1,sc.getId());
				pre.setString(2,sc.getCno());
				pre.setInt(3,sc.getGrade());
				
				pre.addBatch();
				
			}
			pre.executeBatch();
			conn.setAutoCommit(true);
		
			if (pre!= null)pre.close();
			if(conn!=null) conn.close();
			return true;
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();}
			return false;
		}
	
	
	
	public boolean insertStu(List<Student> ls){
		Connection conn=new DBConnection().getConn();
		 PreparedStatement pre=null;
		String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			pre = conn.prepareStatement(sql);
			for (Student s:ls){
				pre=conn.prepareStatement(sql);
				pre.setString(1,s.getId());
				pre.setInt(2,s.getAge());
				pre.setString(3,s.getName());
				pre.setString(4,s.getSex());
				pre.setInt(5,s.getYear());
				pre.setString(6,s.getAddress());
				pre.setString(7,s.getDept());
				pre.setString(8,s.getPolitical());
				pre.setString(9,s.getNationality());
				pre.setString(10,s.getRecord());
				pre.setString(11, s.getFlag());
				pre.addBatch();
				
			}
			pre.executeBatch();
			conn.setAutoCommit(true);
		
			if (pre!= null)pre.close();
			if(conn!=null) conn.close();
			return true;
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();}
			return false;
		}

	public boolean insertClass(List<Course> ls){
		Connection conn=new DBConnection().getConn();
		 PreparedStatement pre=null;
		String sql = "insert into course values(?,?,?)";
		try {
			conn.setAutoCommit(false);
			pre = conn.prepareStatement(sql);
			for (Course c:ls){
				pre=conn.prepareStatement(sql);
				pre.setString(1,c.getCno());
				pre.setString(2,c.getCname());
				pre.setInt(3,c.getCredit());
				pre.addBatch();
			}
			pre.executeBatch();
			conn.setAutoCommit(true);
			System.out.println("添加成功");
			if (pre!= null)pre.close();
			if(conn!=null) conn.close();
			return true;
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();}
			return false;
		}
	
	public void see(Connection conn)
	{
		PreparedStatement pre=null;
		ResultSet rs=null;
		String password=null;
		String id=null;
		try {
			//创建sql语句
			String sql="select * from tb_admin";
			pre=conn.prepareStatement(sql);
			//动态传递参数并执行sql语句
			rs=pre.executeQuery();
			while(rs.next()){
				id=rs.getString("id");
				password = rs.getString("pwd");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
