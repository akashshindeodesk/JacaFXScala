package application.controller;


import io.datafx.controller.flow.action.ActionMethod;

import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.action.BackAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author akash.shinde 
 *
 */
public class WizardController {
    @FXML
    @BackAction
    @ActionTrigger("backAction")
    private Button backButton;
 
    @FXML
    @ActionTrigger("cancelAction")
    private Button cancelButton;
 
    /**
     * @return button instance
     */
    public Button getBackButton() {
        return backButton;
    }
 
    public Button getCancelButton() {
        return cancelButton;
    }
 
    /**
     * @throws Exception
     */
    @ActionMethod("cancelAction")
    public void onAction() throws Exception {
		  
	}
   
}