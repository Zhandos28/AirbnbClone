package bean;

import org.genericdao.PrimaryKey;

@PrimaryKey("hotel_id")
public class Hotel {
	private String hotel_id;
	private String name;
	private String place;
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	private double price_for_night;
    private int num_of_guests;
    private int num_of_bedroom;
    private double grade;
    private int num_of_grades;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum_of_guests() {
		return num_of_guests;
	}
	public void setNum_of_guests(int num_of_guests) {
		this.num_of_guests = num_of_guests;
	}
	public int getNum_of_bedroom() {
		return num_of_bedroom;
	}
	public void setNum_of_bedroom(int num_of_bedroom) {
		this.num_of_bedroom = num_of_bedroom;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getNum_of_grades() {
		return num_of_grades;
	}
	public void setNum_of_grades(int num_of_grades) {
		this.num_of_grades = num_of_grades;
	}
	public double getPrice_for_night() {
		return price_for_night;
	}
	public void setPrice_for_night(double price_for_night) {
		this.price_for_night = price_for_night;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
}
