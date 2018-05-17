package main.view;

import DAO.SushiDAO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.vo.GuestVO;
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
	// ��Ʈ�ѷ����� ���� ������Ű�鼭 Field���� ���������Ѵ�.(�ſ��߿� VO�� import�Ѵٰ��ؼ� ���̾ƴ�)
	public static SushiDialogController sdc;

	public SushiDialogController() {
		sdc = this;
	}

	//
	@FXML // Ŭ���� �ʱ�ȭ
	private void initialize() {

	}
	// �������� �ʱ�ȭ
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	// �� �� �޴´�
	public void setSushi(SushiVO sushi) {
		sdc.SushiNoField.setText(sushi.getSushiNo());
		sdc.SushiNameField.setText(sushi.getSushiName());
		sdc.SushiPriceField.setText(sushi.getSushiPrice());
		sdc.FishNoField.setText(sushi.getFishNo());
		sdc.FishNameField.setText(sushi.getFishName());
		sdc.FishInField.setText(sushi.getFishIn());
		sdc.sushi = sushi;
	}

	// �� �� �޴´�
	public void setGuest(GuestVO guest) {
		sdc.GuestNoFieldg.setText(guest.getGuestNo());
		sdc.TableNOFieldg.setText(guest.getTableNo());
		sdc.guest = guest;
	}
	
	//���°� �޴´�
	public void setJumun(JumunVO jumun) {
		sdc.JumunNoFieldj.setText(jumun.getJumunNo());
		sdc.GuestNoFieldj.setText(jumun.getGuestNo());
		sdc.TableNoFieldj.setText(jumun.getTableNo());
		sdc.SushiNoFieldj.setText(jumun.getSushiNo());
		sdc.SushiCountj.setText(jumun.getSushiCount());
		sdc.jumun = jumun;
		
	}
	// store �� �� �޴°�
	public void setStore(StoreVO store) {
		sdc.FishNoFields.setText(store.getFishNo());
		sdc.FishAmounts.setText(store.getFishAmount());
		sdc.store = store;
	}

	// ok�ȴ����� false return
	public boolean isOkClicked() {
		return okClicked;
	}

	/////////////////////////////////////////////////////////////////////// ��ư�̺�Ʈ�ϱ�
	/////////////////////////////////////////////////////////////////////// �ѽ�����
	/////////////////////////////////////////////////////////////////////// �־�ߵȴ�
	// cancle������ �������� ����
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	// ok������ ������
	@FXML
	private void handleOk() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					String sushiNO = sdc.SushiNoField.getText();
					sushi.setSushiNo(sushiNO);// sushiVO�� ��Ʈ���� sds.SushiVO�� �ִ°Ŵ�
					sushi.setSushiName(sdc.SushiNameField.getText());
					sushi.setSushiPrice(sdc.SushiPriceField.getText());
					sushi.setFishNo(sdc.FishNoField.getText());
					sushi.setFishName(sdc.FishNameField.getText());
					sushi.setFishIn(sdc.FishInField.getText());
					// ���� sdc.sushi�� List�� �߰��������
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
//////////////////////////////////////////////////////////////////////////////////sushi ��ư
	@FXML
	private void handleCancel1() {
		dialogStage.close();
	}

	// ok������ ������
	@FXML
	private void handleOk1() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					guest.setGuestNo(sdc.GuestNoFieldg.getText());// guestVO�� ��Ʈ���� sds.GuestVO�� �ִ°Ŵ�
					guest.setTableNo(sdc.TableNOFieldg.getText());
					// ���� sdc.guest�� List�� �߰��������
					okClicked = true;
					dialogStage.close();
				}
			}
		});
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////guest���̾�α� ��ư
	@FXML
	private void handleCancel2() {
		dialogStage.close();
	}

	// ok������ ������
	@FXML
	private void handleOk2() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					jumun.setJumunNo(sdc.JumunNoFieldj.getText());// jumunVO�� ��Ʈ���� sds.jumunVO�� �ִ°Ŵ�
					jumun.setGuestNo(sdc.GuestNoFieldj.getText());
					jumun.setTableNo(sdc.TableNoFieldj.getText());
					jumun.setSushiNo(sdc.SushiNoFieldj.getText());
					jumun.setSushiCount(sdc.SushiCountj.getText());
					// ���� sdc.guest�� List�� �߰��������
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
	/////////////////////////////////////////////////////////////////////////////////////////////////jumun���̾�α� ��ư
	@FXML
	private void handleCancel3() {
		dialogStage.close();
	}
	@FXML
	private void handleOk3() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (inputValid()) {
					store.setFishNo(sdc.FishNoFields.getText());// jumunVO�� ��Ʈ���� sds.jumunVO�� �ִ°Ŵ�
					store.setFishAmount(sdc.FishAmounts.getText());
					// ���� sdc.guest�� List�� �߰��������
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
	
	//////////////////////////////////////////////////////////////////store ���̾� ��ư
	// ��ȿ�� �ϴ� true
	private boolean inputValid() {
		return true;
	}

}
