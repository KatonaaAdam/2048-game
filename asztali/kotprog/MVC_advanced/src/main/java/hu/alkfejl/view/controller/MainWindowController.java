package hu.alkfejl.view.controller;

import hu.alkfejl.controller.GameController;
import hu.alkfejl.model.ModelGame;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private TableView<ModelGame> table;

    @FXML
    private TableColumn<ModelGame, String> idoCol;

    @FXML
    private TableColumn<ModelGame, Integer> levelCol;

    @FXML
    public void refreshTable(){
        List<ModelGame> list = GameController.getInstance().getAll();
        table.setItems(FXCollections.observableList(list));
    }
    @FXML
    private void vissza(ActionEvent event){
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }


    public MainWindowController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<ModelGame> list = GameController.getInstance().getAll();
       table.setItems(FXCollections.observableList(list));


        idoCol.setCellValueFactory(new PropertyValueFactory<>("ido"));
        levelCol.setCellValueFactory(new PropertyValueFactory<>("lvl"));
    }
}
