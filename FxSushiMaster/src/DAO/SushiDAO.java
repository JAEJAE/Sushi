package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import main.vo.GuestVO;
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

	public void insertStore(StoreVODB store) {
		SqlSession session=null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			System.out.println(store);
			mapper.insertStore(store);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void insertSushi(SushiVODB sushi) {
		SqlSession session=null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.insertSushi(sushi);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void insertJumun(JumunVODB jumun) {
		SqlSession session=null;
		try {
			session = factory.openSession();
			SushiMapper mapper = session.getMapper(SushiMapper.class);
			mapper.insertJumun(jumun);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	
	public SushiDAO() {

	}

	//////////////////////////////////////////////////////// Sushi

	public void deleteSushi(String sushiNo) {
		for (int i = 0; i < sushiList.size(); i++) {
			if (sushiList.get(i).getSushiNo().equals(sushiNo)) {
				sushiList.remove(i);
			}
		}
	}

	////////////////////////////////////////////////////////// Jumun
	public boolean insertJumun(JumunVO vo) {
		boolean flag = true;

		for (int i = 0; i < jumunList.size(); i++) {
			if (jumunList.get(i).getJumunNo().equals(vo.getJumunNo())) {
				flag = false;
			} else {
				jumunList.add(vo);
			}
		}

		return flag;
	}

	public void deleteJumun(String jumunNO) {
		for (int i = 0; i < jumunList.size(); i++) {
			if (jumunList.get(i).getJumunNo().equals(jumunNO)) {
				jumunList.remove(i);
			}
		}
	}

	//////////////////////////////////////////////////////////// Store

	// 추가
	public boolean insertStore(StoreVO vo) {
		boolean flag = true;

		for (int i = 0; i < storeList.size(); i++) {
			if (storeList.get(i).getFishNo().equals(vo.getFishNo())) {
				flag = false;
			} else {
				storeList.add(vo);
				flag = true;
			}
		}
		return flag;
	}

	// 삭제
	public void deleteStore(String fishNo) {

		for (int i = 0; i < storeList.size(); i++) {
			if (storeList.get(i).getFishNo().equals(fishNo)) {
				if (storeList.size() != 0) {
					storeList.remove(i);
				}
			}
		}
	}

	/*
	// 재고변경

	public void changefishAmount(String fishNo) {

		String fishAmt = null;
		String sushiCou = null;

		for (int i = 0; i < sushiList.size(); i++) {
			if (sushiList.get(i).getFishNo().equals(fishNo)) {
				fishAmt = sushiList.get(i).getFishIn();
			}
		}

		for (int i = 0; i < jumunList.size(); i++) {
			if (jumunList.get(i).getSushiCount().equals(fishNo)) {
				sushiCou = jumunList.get(i).getSushiCount();
			}
		}

		for (int i = 0; i < storeList.size(); i++) {
			if (storeList.get(i).getFishNo().equals(fishNo)) {
				int amount = Integer.parseInt(storeList.get(i).getFishAmount())
						- (Integer.parseInt(fishAmt) * Integer.parseInt(sushiCou));

				String amount2 = amount + "";
				storeList.get(i).setFishAmount(amount2);
			}
		}
	}

	
	//테이블 별 총매출
	public void calSales(String guestNo) {
	
	}
	
	*/
	
	//////////////////////////////////////////////////////////// Guest

	public boolean insertGuest(GuestVO vo) {
		boolean flag = true;

		for (int i = 0; i < guestList.size(); i++) {

			if (guestList.get(i).getGuestNo().equals(vo.getGuestNo())) {
				flag = false;
			} else {
				guestList.add(vo);
				flag = true;
			}
		}

		return flag;
	}

	public void deleteGuest(String guestNo) {
		for (int i = 0; i < guestList.size(); i++) {
			if (guestList.get(i).getGuestNo().equals(guestNo)) {
				guestList.remove(i);
			}
		}
	}

}
