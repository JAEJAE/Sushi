package main.vo;

public class SushiVODB {
	private String sushiNo;
	private String sushiName;
	private String sushiPrice;
	private String fishNo;
	private String fishName;
	private String fishIn;
	public SushiVODB() {
		super();
	}
	public SushiVODB(String sushiNo, String sushiName, String sushiPrice, String fishNo, String fishName,
			String fishIn) {
		super();
		this.sushiNo = sushiNo;
		this.sushiName = sushiName;
		this.sushiPrice = sushiPrice;
		this.fishNo = fishNo;
		this.fishName = fishName;
		this.fishIn = fishIn;
	}
	public String getSushiNo() {
		return sushiNo;
	}
	public void setSushiNo(String sushiNo) {
		this.sushiNo = sushiNo;
	}
	public String getSushiName() {
		return sushiName;
	}
	public void setSushiName(String sushiName) {
		this.sushiName = sushiName;
	}
	public String getSushiPrice() {
		return sushiPrice;
	}
	public void setSushiPrice(String sushiPrice) {
		this.sushiPrice = sushiPrice;
	}
	public String getFishNo() {
		return fishNo;
	}
	public void setFishNo(String fishNo) {
		this.fishNo = fishNo;
	}
	public String getFishName() {
		return fishName;
	}
	public void setFishName(String fishName) {
		this.fishName = fishName;
	}
	public String getFishIn() {
		return fishIn;
	}
	public void setFishIn(String fishIn) {
		this.fishIn = fishIn;
	}
	@Override
	public String toString() {
		return "SushiVODB [sushiNo=" + sushiNo + ", sushiName=" + sushiName + ", sushiPrice=" + sushiPrice + ", fishNo="
				+ fishNo + ", fishName=" + fishName + ", fishIn=" + fishIn + "]";
	}
	
	
}
