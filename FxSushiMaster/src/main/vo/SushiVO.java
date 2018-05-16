package main.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SushiVO {
	private StringProperty sushiNo;
	private StringProperty sushiName;
	private StringProperty sushiPrice;
	private StringProperty fishNo;
	private StringProperty fishName;
	private StringProperty fishIn;
	
	public SushiVO() {
		this(null,null,null,null,null,null);
	}
	//데이터 초기화 생성자
	public SushiVO(String sushiNo,String sushiName,String sushiPrice, String fishNo,String fishName, String fishIn) {
		this.sushiNo = new SimpleStringProperty(sushiNo);
		this.sushiName = new SimpleStringProperty(sushiName);
		this.sushiPrice = new SimpleStringProperty(sushiPrice);
		this.fishNo = new SimpleStringProperty(fishNo);
		this.fishName = new SimpleStringProperty(fishName);
		this.fishIn = new SimpleStringProperty(fishIn);
	}
	public String getSushiNo() {
		return sushiNo.get();
	}
	public void setSushiNo(String sushiNo) {
		this.sushiNo.set(sushiNo);
	}
	public StringProperty SushiNoProperty() {
		return sushiNo;
	}
	/////////////////////////////////////////////
	public String getSushiName() {
		return sushiName.get();
	}
	public void setSushiName(String sushiName) {
		this.sushiName.set(sushiName);
	}
	public StringProperty SushiNameProperty() {
		return sushiName;
	}
	////////////////////////////////////////////
	public String getSushiPrice() {
		return sushiPrice.get();
	}
	public void setSushiPrice(String sushiPrice) {
		this.sushiPrice.set(sushiPrice);
	}
	public StringProperty SushiPriceProperty() {
		return sushiPrice;
	}
	///////////////////////////////////////////
	public String getFishNo() {
		return fishNo.get();
	}
	public void setFishNo(String fishNo) {
		this.fishNo.set(fishNo);
	}
	public StringProperty FishNoProperty() {
		return fishNo;
	}
	//////////////////////////////////////////
	public String getFishName() {
		return fishName.get();
	}
	public void setFishName(String fishName) {
		this.fishName.set(fishName);
	}
	public StringProperty FishNameProperty() {
		return fishName;
	}
	//////////////////////////////////////////
	public String getFishIn() {
		return fishIn.get();
	}
	public void setFishIn(String fishIn) {
		this.fishIn.set(fishIn);
	}
	public StringProperty FishInProperty() {
		return fishIn;
	}
	@Override
	public String toString() {
		return "&스시번호:" + sushiNo + " 스시이름:" + sushiName + " 스시가격:" + sushiPrice + " 생선번호:"
				+ fishNo + " 생선이름:" + fishName + " 사용량:" + fishIn;
	}
	
}
