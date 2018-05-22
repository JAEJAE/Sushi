package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import main.vo.GuestVO;
import main.vo.GuestVODB;
import main.vo.JumunVO;
import main.vo.JumunVODB;
import main.vo.StoreVO;
import main.vo.StoreVODB;
import main.vo.SushiVODB;

public class SushiDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	public ArrayList<SushiVODB> sushiList = new ArrayList<>();
	public ArrayList<GuestVO> guestList = new ArrayList<>();
	public ArrayList<StoreVO> storeList = new ArrayList<>();
	public ArrayList<JumunVO> jumunList = new ArrayList<>();
	
	
	public SushiDAO() {
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////// Insert
	
	
	public void insertStore(StoreVODB store) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			System.out.println(store);
			mapper.insertStore(store);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	
	public void insertSushi(SushiVODB sushi) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.insertSushi(sushi);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void insertJumun(JumunVODB jumun) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.insertJumun(jumun);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void insertGuest(GuestVODB guest) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.insertGuest(guest);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	///////////////////////////////////////////////////////////////////////////// Delete


	public void deleteJumun(String jumunNo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.deleteJumun(jumunNo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteGuest(String guestNo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.deleteGuest(guestNo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteSushi(String sushiNo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.deleteSushi(sushiNo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteStore(String fishNo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.deleteStore(fishNo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	///////////////////////////////////////////////////////////////////////////// Update
	
	
	public void updateCost(GuestVODB guest) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.updateCost(guest);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void updateSales(StoreVODB store) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.updateSales(store);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


}
