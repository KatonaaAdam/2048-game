package hu.alkfejl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage myStage) throws Exception{

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/kezdo.fxml"));
			Scene scene = new Scene(root);
			myStage.setScene(scene);
			myStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


}