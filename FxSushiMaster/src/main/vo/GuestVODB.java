package main.vo;

public class GuestVODB {
	private String guestNo;
	private String tableNo;
	private String cost;
	public GuestVODB() {
		super();
	}
	public GuestVODB(String guestNo, String tableNo, String cost) {
		super();
		this.guestNo = guestNo;
		this.tableNo = tableNo;
		this.cost = cost;
	}
	public String getGuestNo() {
		return guestNo;
	}
	public void setGuestNo(String guestNo) {
		this.guestNo = guestNo;
	}
	public String getTableNo() {
		return tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "GuestVODB [guestNo=" + guestNo + ", tableNo=" + tableNo + ", cost=" + cost + "]";
	}
	
	
}
