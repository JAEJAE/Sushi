package main.vo;

public class StoreVODB {
	private String fishNo;
	private String fishAmount;
	private String tableNo;
	private String totalSales;
	public StoreVODB() {
		super();
	}
	public StoreVODB(String fishNo, String fishAmount, String tableNo, String totalSales) {
		super();
		this.fishNo = fishNo;
		this.fishAmount = fishAmount;
		this.tableNo = tableNo;
		this.totalSales = totalSales;
	}
	public StoreVODB(String fishNO, String fishName) {
		super();
		this.fishNo = fishNO;
		this.fishAmount = fishAmount;
		this.tableNo = null;
		this.totalSales = null;
	}
	public String getFishNo() {
		return fishNo;
	}
	public void setFishNo(String fishNo) {
		this.fishNo = fishNo;
	}
	public String getFishAmount() {
		return fishAmount;
	}
	public void setFishAmount(String fishAmount) {
		this.fishAmount = fishAmount;
	}
	public String getTableNo() {
		return tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	public String getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(String totalSales) {
		this.totalSales = totalSales;
	}
	@Override
	public String toString() {
		return "StoreVODB [fishNo=" + fishNo + ", fishAmount=" + fishAmount + ", tableNo=" + tableNo + ", totalSales="
				+ totalSales + "]";
	}
	
	
}

