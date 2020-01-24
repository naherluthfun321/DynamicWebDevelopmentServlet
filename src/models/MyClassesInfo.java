package models;

import java.io.Serializable;

public class MyClassesInfo  implements Serializable {
	private String subjectID;	   
	private String title;
	private String grade;
	
	public MyClassesInfo(){
		
	}
	public MyClassesInfo(String subjectID,String title,String grade){
		this.subjectID = subjectID;
		this.title =title;
		this.grade=grade;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}		

}
