package DAO;


import main.vo.GuestVODB;
import main.vo.JumunVODB;
import main.vo.StoreVODB;
import main.vo.SushiVODB;

public interface SushiMapper {
	
	// 생성
	public void insertStore(StoreVODB store);
	public void insertSushi(SushiVODB sushi);
	public void insertGuest(GuestVODB guest);
	public void insertJumun(JumunVODB jumun);
	
	// 삭제
	public void deleteStore(String fishNo);
	public void deleteJumun(String jumunNo);
	public void deleteGuest(String guestNo);
	public void deleteSushi(String sushiNo);
	
	// 손님(테이블) 별 매출과 가게 총매출 
	public void updateCost(GuestVODB guest);
	public void updateSales(StoreVODB store);
	

	
	
	
	
}
