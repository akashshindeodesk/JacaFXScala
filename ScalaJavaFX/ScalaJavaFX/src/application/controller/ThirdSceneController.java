package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import application.dto.Product;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.ActionHandler;
import io.datafx.controller.flow.context.FlowActionHandler;
import io.datafx.controller.util.VetoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.util.Callback;

/**
 * @author akash.shinde 
 *
 */
@FXMLController(value = "/application/fxml/ThirdScene.fxml", title = "Scene 3")
public class ThirdSceneController extends WizardController implements Initializable {

	@FXML
	@ActionTrigger("nextAction")
	private Button nextButton;

	@ActionHandler
	private FlowActionHandler actionHandler;

	@FXML
	@ActionTrigger("backAction")
	private Button backButton;

	@FXML
	private TableView<Product> thirdSceneTable;
	
	@FXML 
	private Label titleLabel; 
	
	/**
	 * Init the required data
	 */
	@PostConstruct
	public void init() {
		nextButton.setText("Finish");
		getCancelButton().setVisible(false);
		titleLabel.setText("Third Scene");
	}

	/**
	 * GOTO back page 
	 */
	@ActionMethod("backAction")
	public void onActionBack() {
		try {
			actionHandler.navigate(FirstSceneController.class);
		} catch (VetoException | FlowException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * close the wizard
	 */
	@ActionMethod("nextAction")
	public void onActionNext() {
		
	}
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		
		TableColumn<Product, String> productName = new TableColumn<Product, String>("Name");
		productName.setMinWidth(200);
		productName.setCellValueFactory(new PropertyValueFactory<Product, String>("productDesc"));

		TableColumn<Product, String> productPrice = new TableColumn<Product, String>("Price ($)");
		productPrice.setMinWidth(100);
		productPrice.setCellValueFactory(new PropertyValueFactory<Product, String>("productPrice"));
	
		
		TableColumn<Product, String> productDesc = new TableColumn<Product, String>("Description");
		productDesc.setMinWidth(150);
		productDesc.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));

		TableColumn<Product, Product> productImage = new TableColumn<Product, Product>("Image");
		productImage.setMinWidth(150);

		productImage.setCellFactory(new Callback<TableColumn<Product, Product>, TableCell<Product, Product>>() {
			@Override
			public TableCell<Product, Product> call(TableColumn<Product, Product> p) {
				return new getButton();
			}
		});

		thirdSceneTable.getColumns().addAll(productImage, productName, productDesc,productPrice);

		if ("1".equals(SecondSceneController.productSelected)) {
			ObservableList<Product> list = FXCollections.observableArrayList();
			list.add(new Product("Product Selected 1", "102", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 1", "120", "Product 2 Desc comes here"));
			list.add(new Product("Product Selected 1", "125", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 1", "124", "Product 2 Desc comes here"));

			thirdSceneTable.setItems(list);
		}

		if ("2".equals(SecondSceneController.productSelected)) {
			ObservableList<Product> list = FXCollections.observableArrayList();
			list.add(new Product("Product Selected 2", "100", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 2", "200", "Product 2 Desc comes here"));
			list.add(new Product("Product Selected 2", "34", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 2", "120", "Product 2 Desc comes here"));

			thirdSceneTable.setItems(list);
		}

		if ("3".equals(SecondSceneController.productSelected)) {
			ObservableList<Product> list = FXCollections.observableArrayList();
			list.add(new Product("Product Selected 3", "20", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 3", "340", "Product 2 Desc comes here"));
			list.add(new Product("Product Selected 3", "330", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 3", "120", "Product 2 Desc comes here"));

			thirdSceneTable.setItems(list);
		}

		if ("4".equals(SecondSceneController.productSelected)) {

			ObservableList<Product> list = FXCollections.observableArrayList();
			list.add(new Product("Product Selected 4", "24", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 4", "35", "Product 2 Desc comes here"));
			list.add(new Product("Product Selected 4", "45", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 4", "55", "Product 2 Desc comes here"));

			thirdSceneTable.setItems(list);
		}

		if ("5".equals(SecondSceneController.productSelected)) {

			ObservableList<Product> list = FXCollections.observableArrayList();
			list.add(new Product("Product Selected 5", "10", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 5", "12", "Product 2 Desc comes here"));
			list.add(new Product("Product Selected 5", "23", "Product 1 Desc comes here"));
			list.add(new Product("Product Selected 5", "29", "Product 2 Desc comes here"));

			thirdSceneTable.setItems(list);
		}

	}

	/**
	 * @author akash shinde
	 *
	 */
	private class getButton extends TableCell<Product, Product> {
		private Button cellButton;

		getButton() {
			cellButton = new Button("Product");
			BackgroundImage firstBtn = new BackgroundImage(
					new Image(getClass().getResourceAsStream("/application/images/icons-1.jpg")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			Background backGround = new Background(firstBtn);
			cellButton.setBackground(backGround);

			cellButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {

				}

			});
		}

		@Override
		protected void updateItem(Product product, boolean empty) {
			super.updateItem(product, empty);
			if (!empty) {
				setGraphic(cellButton);
			} else {
				setGraphic(null);
			}
		}
	}

}
