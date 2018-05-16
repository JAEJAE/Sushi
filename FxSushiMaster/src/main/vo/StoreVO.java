package main.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StoreVO {
	private StringProperty fishNo;
	private StringProperty fishAmount;
	private StringProperty tableNo;
	private StringProperty totalSales;
	
	public StoreVO() {
		this(null,null,null,null);
	}
	
	public StoreVO(String fishNo,String fishAmount,String tableNo,String totalSales) {
		this.fishNo = new SimpleStringProperty(fishNo);
		this.fishAmount = new SimpleStringProperty(fishAmount);
		this.tableNo = new SimpleStringProperty(tableNo);
		this.totalSales = new SimpleStringProperty(totalSales);
	}
	
	public String getFishNo() {
		return fishNo.get();
	}
	public void setFishNo(String fishNo) {
		this.fishNo.set(fishNo);
	}
	public StringProperty FishNoProperty() {
		return fishNo;
	}
	////////////////////////////////////////
	public String getFishAmount() {
		return fishAmount.get();
	}
	public void setFishAmount(String fishAmount) {
		this.fishAmount.set(fishAmount);
	}
	public StringProperty FishAmountProperty() {
		return fishAmount;
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
	public String getTotalSales() {
		return totalSales.get();
	}
	public void setTotalSales(String totalSales) {
		this.totalSales.set(totalSales);
	}
	public StringProperty TotalSalesProperty() {
		return totalSales;
	}
	///////////////////////////////////////////

	@Override
	public String toString() {
		return "&생선번호:" + fishNo + ", 생선재고량:" + fishAmount + ", 테이블번호:" + tableNo + ", 매출:"
				+ totalSales ;
	}
	
	
	
}
