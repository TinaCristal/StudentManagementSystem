package common;

public class Course {
	private String cno;
	private String cname;// ĞÕÃû
	private int credit;

	Course(String cno, String cname, int credit) {
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getCno() {
		return cno;
	}

	public String getCname() {
		return cname;
	}

	public int getCredit() {
		return credit;
	}

	public Course() {

	}
}

