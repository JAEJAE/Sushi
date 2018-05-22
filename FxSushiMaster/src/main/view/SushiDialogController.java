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
	
	////////////////////////////////////////////sushiVO
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
	///////////////////////////////////////////guestVO
	@FXML
	private TextField GuestNoFieldg;
	@FXML
	private TextField TableNOFieldg;
	@FXML
	private Label CostLabelg;
	///////////////////////////////////////////jumunVO
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
	///////////////////////////////////////////storeVO
	@FXML
	private TextField FishNoFields;
	@FXML
	private TextField FishAmounts;

	
	
	
	private Stage dialogStage;
	private SushiVO sushi;
	private GuestVO guest;
	private JumunVO jumun;
	private StoreVO store;

	private boolean okClicked = false;
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
	
	
/////////////////////////////////////////// 입력창
	
	public void setSushi(SushiVO sushi) {
		sdc.SushiNoField.setText(sushi.getSushiNo());
		sdc.SushiNameField.setText(sushi.getSushiName());
		sdc.SushiPriceField.setText(sushi.getSushiPrice());
		sdc.FishNoField.setText(sushi.getFishNo());
		sdc.FishNameField.setText(sushi.getFishName());
		sdc.FishInField.setText(sushi.getFishIn());
		sdc.sushi = sushi;
	}

	public void setGuest(GuestVO guest) {
		sdc.GuestNoFieldg.setText(guest.getGuestNo());
		sdc.TableNOFieldg.setText(guest.getTableNo());
		sdc.guest = guest;
	}
	
	
	public void setJumun(JumunVO jumun) {
		sdc.JumunNoFieldj.setText(jumun.getJumunNo());
		sdc.GuestNoFieldj.setText(jumun.getGuestNo());
		sdc.TableNoFieldj.setText(jumun.getTableNo());
		sdc.SushiNoFieldj.setText(jumun.getSushiNo());
		sdc.SushiCountj.setText(jumun.getSushiCount());
		sdc.jumun = jumun;
		
	}
	public void setStore(StoreVO store) {
		sdc.FishNoFields.setText(store.getFishNo());
		sdc.FishAmounts.setText(store.getFishAmount());
		sdc.store = store;
	}

	// OK버튼 안누를 시 -> false
	public boolean isOkClicked() {
		return okClicked;
	}
	
	// CANCLE버튼 -> 스테이지 종료
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

////////////////////////////////////////////////////////////////////////////////// SUSHI 버튼
	
	@FXML
	private void handleOk() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					String sushiNO = sdc.SushiNoField.getText();
					sushi.setSushiNo(sushiNO);
					sushi.setSushiName(sdc.SushiNameField.getText());
					sushi.setSushiPrice(sdc.SushiPriceField.getText());
					sushi.setFishNo(sdc.FishNoField.getText());
					sushi.setFishName(sdc.FishNameField.getText());
					sushi.setFishIn(sdc.FishInField.getText());
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

	////////////////////////////////////////////////////////////////////////////////// GUEST dialog 버튼
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

	@FXML
	private void handleOk1() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					guest.setGuestNo(sdc.GuestNoFieldg.getText());
					guest.setTableNo(sdc.TableNOFieldg.getText());
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

	////////////////////////////////////////////////////////////////////////////////// JUMUN dialog 버튼
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


	@FXML
	private void handleOk2() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					jumun.setJumunNo(sdc.JumunNoFieldj.getText());
					jumun.setGuestNo(sdc.GuestNoFieldj.getText());
					jumun.setTableNo(sdc.TableNoFieldj.getText());
					jumun.setSushiNo(sdc.SushiNoFieldj.getText());
					jumun.setSushiCount(sdc.SushiCountj.getText());

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

	////////////////////////////////////////////////////////////////////////////////// STORE dialog 버튼
	
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
					store.setFishNo(sdc.FishNoFields.getText());
					store.setFishAmount(sdc.FishAmounts.getText());
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
	

	private boolean inputValid() {
		return true;
	}

}
