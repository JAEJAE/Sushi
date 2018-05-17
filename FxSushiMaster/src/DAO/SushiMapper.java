package DAO;


import main.vo.GuestVODB;
import main.vo.JumunVODB;
import main.vo.StoreVODB;
import main.vo.SushiVODB;

public interface SushiMapper {
	public void insertStore(StoreVODB store);
	public void insertSushi(SushiVODB sushi);
	public void insertGuest(GuestVODB guest);
	public void insertJumun(JumunVODB jumun);
	
	public void deleteStore(String fishNo);
	public void deleteJumun(String jumunNo);
	public void deleteGuest(String guestNo);
	public void deleteSushi(String sushiNo);
	
	public void updateCost(GuestVODB guest);
	public void updateSales(StoreVODB store);
	
	

	//public void updateAmount(String totalamount, String fishNo);
	
	
	
	
}
