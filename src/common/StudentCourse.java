package common;

public class StudentCourse {
	private String cno;
	private String id;
	private int grade;

	StudentCourse(String id, String cno, int grade) {
		this.cno = cno;
		this.id = id;
		this.grade = grade;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getCno() {
		return cno;
	}

	public String getId() {
		return id;
	}

	public int getGrade() {
		return grade;
	}

	public StudentCourse() {

	}

}


