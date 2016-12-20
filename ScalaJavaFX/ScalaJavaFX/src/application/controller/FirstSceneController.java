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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * @author akash.shinde 
 *
 */
@FXMLController(value = "/application/fxml/SceneFirst.fxml", title = "Scene 1")
public class FirstSceneController extends WizardController implements Initializable {

	@ActionHandler
	private FlowActionHandler actionHandler;

	@FXML
	private ImageView firstSceneImageVew;

	@FXML
	private Label subtitleLabel;

	@FXML
	@ActionTrigger("nextAction")
	private Button nextButton;

	@FXML
	private Label titleLabel;
	
	@ActionMethod("nextAction")
	public void onActionNext() {
		try {
			actionHandler.navigate(SecondSceneController.class);
		} catch (VetoException | FlowException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		subtitleLabel.setText("Scene First");
		getBackButton().setVisible(false);
		titleLabel.setText("First Scene");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		firstSceneImageVew.setImage(new Image(getClass().getResourceAsStream("/application/images/scene1.jpg")));
	}
}
