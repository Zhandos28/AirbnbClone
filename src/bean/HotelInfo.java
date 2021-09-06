package bean;

import org.genericdao.PrimaryKey;

@PrimaryKey("hotel_id")
public class HotelInfo {
	private String hotel_id;
	private String info;
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
