package main.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JumunVO {
	private StringProperty jumunNo;
	private StringProperty guestNo;
	private StringProperty tableNo;
	private StringProperty sushiNo;
	private StringProperty sushiCount;
	
	public JumunVO() {
		this(null, null, null, null, null);
	}
	
	public JumunVO(String jumunNo, String guestNo, String tableNo, String sushiNo, String sushiCount) {
		this.jumunNo = new SimpleStringProperty(jumunNo);
		this.guestNo = new SimpleStringProperty(guestNo);
		this.tableNo = new SimpleStringProperty(tableNo);
		this.sushiNo = new SimpleStringProperty(sushiNo);
		this.sushiCount = new SimpleStringProperty(sushiCount);
	}
	
	public String getJumunNo() {
		return jumunNo.get();
	}
	public void setJumunNo(String jumunNo) {
		this.jumunNo.set(jumunNo);
	}
	public StringProperty JumunNoProperty() {
		return jumunNo;
	}
	///////////////////////////////////////////
	public String getGuestNo() {
		return guestNo.get();
	}
	public void setGuestNo(String guestNo) {
		this.guestNo.set(guestNo);
	}
	public StringProperty GuestNoProperty() {
		return guestNo;
	}
	///////////////////////////////////////////
	public String getTableNo() {
		return tableNo.get();
	}
	public void setTableNo(String tableNo) {
		this.tableNo.set(tableNo);
	}
	public StringProperty TableNoProperty() {
		return tableNo;
	}
	///////////////////////////////////////////
	public String getSushiNo() {
		return sushiNo.get();
	}
	public void setSushiNo(String sushiNo) {
		this.sushiNo.set(sushiNo);
	}
	public StringProperty SushiNoProperty() {
		return sushiNo;
	}
	/////////////////////////////////////////
	public String getSushiCount() {
		return sushiCount.get();
	}
	public void setSushiCount(String sushiCount) {
		this.sushiCount.set(sushiCount);
	}
	public StringProperty SushiCountProperty() {
		return sushiCount;
	}

	@Override
	public String toString() {
		return "&주문번호:" + jumunNo + " 손님번호:" + guestNo + " 테이블번호:" + tableNo + " 초밥번호:" + sushiNo
				+ " 초밥개수:" + sushiCount;
	}
	
}
