package main.vo;

public class JumunVODB {
	private String jumunNo;
	private String guestNo;
	private String tableNo;
	private String sushiNo;
	private String sushiCount;
	public JumunVODB() {
		super();
	}
	public JumunVODB(String jumunNo, String guestNo, String tableNo, String sushiNo, String sushiCount) {
		super();
		this.jumunNo = jumunNo;
		this.guestNo = guestNo;
		this.tableNo = tableNo;
		this.sushiNo = sushiNo;
		this.sushiCount = sushiCount;
	}
	public String getJumunNo() {
		return jumunNo;
	}
	public void setJumunNo(String jumunNo) {
		this.jumunNo = jumunNo;
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
	public String getSushiNo() {
		return sushiNo;
	}
	public void setSushiNo(String sushiNo) {
		this.sushiNo = sushiNo;
	}
	public String getSushiCount() {
		return sushiCount;
	}
	public void setSushiCount(String sushiCount) {
		this.sushiCount = sushiCount;
	}
	@Override
	public String toString() {
		return "JumunVODB [jumunNo=" + jumunNo + ", guestNo=" + guestNo + ", tableNo=" + tableNo + ", sushiNo="
				+ sushiNo + ", sushiCount=" + sushiCount + "]";
	}
	
	
}
