package models;
import java.io.Serializable;
import java.util.Date;

public class StudentInfo implements Serializable {
	
	private String ssn;
	private String firstName;
	private String mi;
	private String lastName;	
	private Date birthDate;
	private String street;
	private String phone;
	private String zipcode;
	private String deptId;
	private String fullName;
	
	public StudentInfo()
	{
		
	}

	public StudentInfo(String ssn, String firstName, String mi, String lastName, Date birthDate,
			String street, String phone, String zipcode, String deptId) {
		this.ssn=ssn;
		this.firstName=firstName;
		this.mi=mi;
		this.lastName=lastName;	
		this.birthDate=birthDate;
		this.street=street;
		this.phone=phone;
		this.zipcode=zipcode;
		this.deptId=deptId;
		this.fullName = firstName+" "+mi+" "+lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMi() {
		return mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
