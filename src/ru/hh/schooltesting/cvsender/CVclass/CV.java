package ru.hh.schooltesting.cvsender.CVclass;
import java.io.*;
public class CV implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String position;
	private String phone;
	private String email;
	private String sex;
	private String wage;
	private int day;
	private int month;
	private int year;
	public CV(String Aname, String Asex, int Aday, int Amonth, int Ayear, String Aposition, String Awage, String Aphone, String Aemail)
	{
		setName(Aname);
		setSex(Asex);
		setDay(Aday);
		setMonth(Amonth);
		setYear(Ayear);
		setPosition(Aposition);
		setWage(Awage);
		setPhone(Aphone);
		setEmail(Aemail);		
	}
	//Encapsulating fields
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	private void setPosition(String position) {
		this.position = position;
	}
	public String getPhone() {
		return phone;
	}
	private void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	private void setSex(String sex) {
		this.sex = sex;
	}
	public String getWage() {
		return wage;
	}
	private void setWage(String wage) {
		this.wage = wage;
	}
	public int getDay() {
		return day;
	}
	private void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	private void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	private void setYear(int year) {
		this.year = year;
	}
}
