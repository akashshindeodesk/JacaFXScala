package application;

import application.common.Common;
import application.controller.FirstSceneController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author akash.shinde 
 *
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage = new Stage();

			Flow wizardflow = new Flow(FirstSceneController.class);

			FlowHandler wizardflowHandler = wizardflow.createHandler();
			StackPane root = wizardflowHandler.start();
			Scene scene = new Scene(root);

			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			// Set minimum size
			primaryStage.setHeight(Common.WIZARDHEIGHT);
			primaryStage.setWidth(Common.WIZARDWIDTH);
			primaryStage.setScene(scene);

			primaryStage.show();

			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
