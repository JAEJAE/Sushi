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
	
	
	
}
