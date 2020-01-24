package models;

import java.io.Serializable;

public class CourseInfo implements Serializable{
	
	private String courseID;
	private String subjectID;
	private Integer courseNumber;   
	private String title;
    private Integer numOfCredits;

    public CourseInfo()
	{		
	}
    public CourseInfo(String subjectID,Integer courseNumber,String title,Integer numOfCredits)
	{
    	this.subjectID= subjectID;
    	this.courseNumber =courseNumber;
    	this.title=title;
    	this.numOfCredits=numOfCredits;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}    
    public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public Integer getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getNumOfCredits() {
		return numOfCredits;
	}
	public void setNumOfCredits(Integer numOfCredits) {
		this.numOfCredits = numOfCredits;
	}    

}
