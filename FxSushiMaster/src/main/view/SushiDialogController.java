package main.view;

import DAO.SushiDAO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.vo.GuestVO;
import main.vo.GuestVODB;
import main.vo.JumunVO;
import main.vo.JumunVODB;
import main.vo.StoreVO;
import main.vo.StoreVODB;
import main.vo.SushiVO;
import main.vo.SushiVODB;

public class SushiDialogController {
	SushiDAO dao = new SushiDAO();
	@FXML
	private TextField SushiNoField;
	@FXML
	private TextField SushiNameField;
	@FXML
	private TextField SushiPriceField;
	@FXML
	private TextField FishNoField;
	@FXML
	private TextField FishNameField;
	@FXML
	private TextField FishInField;
	////////////////////////////////////////////sushiVO
	@FXML
	private TextField GuestNoFieldg;
	@FXML
	private TextField TableNOFieldg;
	@FXML
	private Label CostLabelg;
	///////////////////////////////////////////guestVO
	@FXML
	private TextField JumunNoFieldj;
	@FXML
	private TextField GuestNoFieldj;
	@FXML
	private TextField TableNoFieldj;
	@FXML
	private TextField SushiNoFieldj;
	@FXML
	private TextField SushiCountj;
	///////////////////////////////////////////jumunVO
	@FXML
	private TextField FishNoFields;
	@FXML
	private TextField FishAmounts;
	///////////////////////////////////////////storeVO
	private Stage dialogStage;
	private SushiVO sushi;
	private GuestVO guest;
	private JumunVO jumun;
	private StoreVO store;

	private boolean okClicked = false;
	// 컨트롤러에서 따로 생성시키면서 Field값을 만들어줘야한다.(매우중요 VO를 import한다고해서 끝이아님)
	public static SushiDialogController sdc;

	public SushiDialogController() {
		sdc = this;
	}

	//
	@FXML // 클래스 초기화
	private void initialize() {

	}
	// 스테이지 초기화
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	// 들어갈 값 받는다
	public void setSushi(SushiVO sushi) {
		sdc.SushiNoField.setText(sushi.getSushiNo());
		sdc.SushiNameField.setText(sushi.getSushiName());
		sdc.SushiPriceField.setText(sushi.getSushiPrice());
		sdc.FishNoField.setText(sushi.getFishNo());
		sdc.FishNameField.setText(sushi.getFishName());
		sdc.FishInField.setText(sushi.getFishIn());
		sdc.sushi = sushi;
	}

	// 들어갈 값 받는다
	public void setGuest(GuestVO guest) {
		sdc.GuestNoFieldg.setText(guest.getGuestNo());
		sdc.TableNOFieldg.setText(guest.getTableNo());
		sdc.guest = guest;
	}
	
	//들어가는값 받는다
	public void setJumun(JumunVO jumun) {
		sdc.JumunNoFieldj.setText(jumun.getJumunNo());
		sdc.GuestNoFieldj.setText(jumun.getGuestNo());
		sdc.TableNoFieldj.setText(jumun.getTableNo());
		sdc.SushiNoFieldj.setText(jumun.getSushiNo());
		sdc.SushiCountj.setText(jumun.getSushiCount());
		sdc.jumun = jumun;
		
	}
	// store 들어갈 값 받는거
	public void setStore(StoreVO store) {
		sdc.FishNoFields.setText(store.getFishNo());
		sdc.FishAmounts.setText(store.getFishAmount());
		sdc.store = store;
	}

	// ok안누르면 false return
	public boolean isOkClicked() {
		return okClicked;
	}

	/////////////////////////////////////////////////////////////////////// 버튼이벤트니까
	/////////////////////////////////////////////////////////////////////// 한쌍으로
	/////////////////////////////////////////////////////////////////////// 있어야된다
	// cancle누르면 스테이지 종료
	@FXML
	private void handleCancel() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					System.out.println(sdc.SushiNoField.getText());
					dao.deleteSushi(sdc.SushiNoField.getText());
					dialogStage.close();
				}
			}
		});
	}

	// ok누르면 값들어간당
	@FXML
	private void handleOk() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					String sushiNO = sdc.SushiNoField.getText();
					sushi.setSushiNo(sushiNO);// sushiVO에 컨트롤의 sds.SushiVO를 넣는거다
					sushi.setSushiName(sdc.SushiNameField.getText());
					sushi.setSushiPrice(sdc.SushiPriceField.getText());
					sushi.setFishNo(sdc.FishNoField.getText());
					sushi.setFishName(sdc.FishNameField.getText());
					sushi.setFishIn(sdc.FishInField.getText());
					// 여기 sdc.sushi를 List에 추가해줘야해
					okClicked = true;
					dialogStage.close();
					SushiVODB sushiDB = new SushiVODB();
					sushiDB.setSushiNo(sushiNO);
					sushiDB.setSushiName(sdc.SushiNameField.getText());
					sushiDB.setSushiPrice(sdc.SushiPriceField.getText());
					sushiDB.setFishNo(sdc.FishNoField.getText());
					sushiDB.setFishName(sdc.FishNameField.getText());
					sushiDB.setFishIn(sdc.FishInField.getText());
					System.out.println(sushiDB);
					dao.insertSushi(sushiDB);
				}
			}
		});
	}
//////////////////////////////////////////////////////////////////////////////////sushi 버튼
	@FXML
	private void handleCancel1() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					System.out.println(sdc.GuestNoFieldg.getText());
					dao.deleteGuest(sdc.GuestNoFieldg.getText());
					dialogStage.close();
				}
			}
		});
	}

	// ok누르면 값들어간당
	@FXML
	private void handleOk1() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					guest.setGuestNo(sdc.GuestNoFieldg.getText());// guestVO에 컨트롤의 sds.GuestVO를 넣는거다
					guest.setTableNo(sdc.TableNOFieldg.getText());
					// 여기 sdc.guest를 List에 추가해줘야해
					okClicked = true;
					dialogStage.close();
					GuestVODB guestDB = new GuestVODB();
					guestDB.setGuestNo(sdc.GuestNoFieldg.getText());
					guestDB.setTableNo(sdc.TableNOFieldg.getText());
					System.out.println(guestDB);
					dao.insertGuest(guestDB);
				}
			}
		});
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////guest다이얼로그 버튼
	@FXML
	private void handleCancel2() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					System.out.println(sdc.JumunNoFieldj.getText());
					dao.deleteJumun(sdc.JumunNoFieldj.getText());
					dialogStage.close();
				}
			}
		});
	}

	// ok누르면 값들어간당
	@FXML
	private void handleOk2() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					jumun.setJumunNo(sdc.JumunNoFieldj.getText());// jumunVO에 컨트롤의 sds.jumunVO를 넣는거다
					jumun.setGuestNo(sdc.GuestNoFieldj.getText());
					jumun.setTableNo(sdc.TableNoFieldj.getText());
					jumun.setSushiNo(sdc.SushiNoFieldj.getText());
					jumun.setSushiCount(sdc.SushiCountj.getText());
					// 여기 sdc.guest를 List에 추가해줘야해
					okClicked = true;
					dialogStage.close();
					JumunVODB jumunDB = new JumunVODB();
					jumunDB.setJumunNo(sdc.JumunNoFieldj.getText());
					jumunDB.setGuestNo(sdc.GuestNoFieldj.getText());
					jumunDB.setTableNo(sdc.TableNoFieldj.getText());
					jumunDB.setSushiNo(sdc.SushiNoFieldj.getText());
					jumunDB.setSushiCount(sdc.SushiCountj.getText());
					dao.insertJumun(jumunDB);
					System.out.println(jumunDB);
				}
			}
		});
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////jumun다이얼로그 버튼
	@FXML
	private void handleCancel3() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					System.out.println(sdc.FishNoFields.getText());
					dao.deleteStore(sdc.FishNoFields.getText());
					dialogStage.close();
				}
			}
		});
	}
	@FXML
	private void handleOk3() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					store.setFishNo(sdc.FishNoFields.getText());// jumunVO에 컨트롤의 sds.jumunVO를 넣는거다
					store.setFishAmount(sdc.FishAmounts.getText());
					// 여기 sdc.guest를 List에 추가해줘야해
					okClicked = true;
					dialogStage.close();
					StoreVODB store = new StoreVODB();
					store.setFishNo(sdc.FishNoFields.getText());
					store.setFishAmount(sdc.FishAmounts.getText());
					System.out.println(store);
					dao.insertStore(store);
				}
			}
		});
	}
	
	//////////////////////////////////////////////////////////////////store 다이얼 버튼
	// 유효성 일단 true
	private boolean inputValid() {
		return true;
	}

}
