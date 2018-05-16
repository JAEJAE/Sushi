package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.view.SushiController;
import main.view.SushiDialogController;
import main.vo.GuestVO;
import main.vo.JumunVO;
import main.vo.StoreVO;
import main.vo.SushiVO;

public class Main extends Application {

	private Stage primaryStage;
	private Stage dialogStage;
	
	
	private BorderPane rootLayout;
	private AnchorPane sushi;
	private AnchorPane sushidialog;
	private AnchorPane guestdialog;
	private AnchorPane jumundialog;
	private AnchorPane storedialog;
	// data ObservableList
	private ObservableList<SushiVO> sushiData = FXCollections.observableArrayList();
	private ObservableList<GuestVO> guestData = FXCollections.observableArrayList();
	private ObservableList<JumunVO> jumunData = FXCollections.observableArrayList();
	private ObservableList<StoreVO> storeData = FXCollections.observableArrayList();
	//
	public ObservableList<SushiVO> getSuchiVOData() {
		return sushiData;
	}
	public ObservableList<GuestVO> getGuestVOData(){
		return guestData;
	}
	public ObservableList<JumunVO> getJumunVOData(){
		return jumunData;
	}
	public ObservableList<StoreVO> getStoreVOData(){
		return storeData;
	}
	//
	public void printList() {//디버깅용 출력
		System.out.println(sushiData);
		System.out.println(guestData);
		System.out.println(jumunData);
		System.out.println(storeData);
	}
	
	public Main() {
		//초기값뺐음
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SunooshiMasteR!");

		initRootLayout();

		showSushi();
	}

	// 레이아웃 초기화
	public void initRootLayout() {
		try {
			// fxml가져오기
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// 상위 레이아웃을 포함하는 scene을 보여준다.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	// Menu보여주기
	public void showSushi() {//전체창 불러오기
		try {
			// 메뉴정보 가져오기
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Sushi.fxml"));
			sushi = (AnchorPane) loader.load();////////////////////
			// 레이아웃 위치설정
			rootLayout.setCenter(sushi);
			
			//controller연결하기
			SushiController controller = loader.getController();
			controller.setMain(this);//fxml 씬빌더로 열어서 커트롤러 걸어주기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean showSushiDialog(SushiVO sushi) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/SushiDialog.fxml"));
			sushidialog = (AnchorPane) loader.load();
			//다이얼로그용 스테이지 그리고 그안에 들어갈 scene만들어줌
			dialogStage = new Stage();
			dialogStage.setTitle("Sushi Info");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(sushidialog);
			dialogStage.setScene(scene);
			//컨트롤러 연결하기
			SushiDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSushi(sushi);
			
			dialogStage.showAndWait();
			return controller.isOkClicked();//ok되면 트루되고 창꺼짐
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showGuestDialog(GuestVO guest) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GuestDialog.fxml"));
			guestdialog = (AnchorPane) loader.load();
			dialogStage = new Stage();
			dialogStage.setTitle("Guest Info");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(guestdialog);
			dialogStage.setScene(scene);
			SushiDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setGuest(guest);
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showJumunDialog(JumunVO jumun) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/JumunDialog.fxml"));
			jumundialog = (AnchorPane) loader.load();
			dialogStage = new Stage();
			dialogStage.setTitle("Jumun Info");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(jumundialog);
			dialogStage.setScene(scene);
			SushiDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setJumun(jumun);
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showStoreDialog(StoreVO store) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/StoreDialog.fxml"));
			storedialog = (AnchorPane) loader.load();
			dialogStage = new Stage();
			dialogStage.setTitle("Store Info");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(storedialog);
			dialogStage.setScene(scene);
			SushiDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setStore(store);
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//////////////////////////////////////////////////////////////////
	//추가 FXML작성할 곳
	
	
/////////////////////////////////////////////////////////////////stage호출
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
