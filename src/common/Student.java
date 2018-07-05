package common;

public class Student {
	private byte[] picture;
	private String id;//学号
	private int age;//年龄
	private String name;//姓名
	private String sex;//性别
	private int year;//学制
	private String address;//地区
	private String dept;
	private String political;
	private String nationality; 
	private String record; 
	private String flag; 
	public Student(String id,int age,String name,String sex,int year,String address,String dept,
			String political,String nationality,String record,String flag) {
		this.id=id;
		this.age=age;
		this.name=name;
		this.sex=sex;
		this.year=year;
		this.address=address;
		this.dept=dept;
		this.political=political;
		this.nationality=nationality;
		this.record=record;	
		this.flag=flag;
	}
	public void setFlag(String flag)
	{
		this.flag=flag;
	}
	public String getFlag(){
		return flag;
		
	}
	public Student() {
		// TODO 自动生成的构造函数存根
	}
	public void setPicture(byte[] pic)
	{
		this.picture=pic;
	}
	public byte[] getPicture()
	{
		return picture;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setYear(int year)
	{
		this.year=year;
	}
	public int getYear()
	{
		return year;
	}
	public void setPolitical(String political)
	{
		this.political=political;
	}
	public String getPolitical()
	{
		return political;
	}
	public void setNationality(String nationality){
		this.nationality=nationality;
	}
	public String getNationality()
	{
		return nationality;
	}
	public void setRecord(String record){
		this.record=record;
	}
	public String getRecord()
	{
		return record;
	}

	
}
