package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.ActionHandler;
import io.datafx.controller.flow.context.FlowActionHandler;
import io.datafx.controller.util.VetoException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Text;
/**
 * @author akash.shinde 
 *
 */

@FXMLController(value = "/application/fxml/SceneSecond.fxml", title = "Scene 2")
public class SecondSceneController extends WizardController implements Initializable {

	@FXML
	@ActionTrigger("nextAction")
	private Button nextButton;

	@ActionHandler
	private FlowActionHandler actionHandler;

	@FXML
	@ActionTrigger("backAction")
	private Button backButton;

	@FXML
	private Button productBtnFirst;

	@FXML
	private Button productBtnSecond;

	@FXML
	private Button productBtnThird;

	@FXML
	private Button productBtnFourth;
	@FXML
	private Button productBtnFifth;

	@FXML 
	private Label titleLabel; 
	
	public static String productSelected;
	
	@FXML
	private void onproductBtnFifth() {
		System.out.println("fifth");
		SecondSceneController.productSelected = "5";
		onActionNext();
	}

	@FXML
	private void onproductBtnFourth() {
		System.out.println("fourth");
		SecondSceneController.productSelected = "4";
		onActionNext();
	}

	@FXML
	private void onproductBtnThird() {
		System.out.println("Third");
		SecondSceneController.productSelected = "3";
		onActionNext();
	}

	@FXML
	private void onproductBtnSecond() {
		System.out.println("second");
		SecondSceneController.productSelected = "2";
		onActionNext();
	}

	@FXML
	private void onproductBtnFirst() {
		System.out.println("first");
		SecondSceneController.productSelected = "1";
		onActionNext();

	}

	@ActionMethod("nextAction")
	public void onActionNext() {
		try {
			actionHandler.navigate(ThirdSceneController.class);
		} catch (VetoException | FlowException e) {
			e.printStackTrace();
		}
	}

	@ActionMethod("backAction")
	public void onActionBack() {
		try {
			actionHandler.navigate(FirstSceneController.class);
		} catch (VetoException | FlowException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		 nextButton.setText("Next");
		 nextButton.setVisible(false);
		 getCancelButton().setVisible(true);
		 titleLabel.setText("Second Scene");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		BackgroundImage firstBtn = new BackgroundImage(
				new Image(getClass().getResourceAsStream("/application/images/icons-1.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		Background backGround = new Background(firstBtn);
		productBtnFirst.setBackground(backGround);

		BackgroundImage firstSecond = new BackgroundImage(
				new Image(getClass().getResourceAsStream("/application/images/icons-2.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		backGround = new Background(firstSecond);
		productBtnSecond.setBackground(backGround);

		BackgroundImage thirdBtn = new BackgroundImage(
				new Image(getClass().getResourceAsStream("/application/images/icons-3.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		backGround = new Background(thirdBtn);
		productBtnThird.setBackground(backGround);

		BackgroundImage fourthBg = new BackgroundImage(
				new Image(getClass().getResourceAsStream("/application/images/icons-3.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		backGround = new Background(fourthBg);
		productBtnFourth.setBackground(backGround);

		BackgroundImage fifthBg = new BackgroundImage(
				new Image(getClass().getResourceAsStream("/application/images/icons-3.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		backGround = new Background(fifthBg);
		productBtnFifth.setBackground(backGround);
	}

}
