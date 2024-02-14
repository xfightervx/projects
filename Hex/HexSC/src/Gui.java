package HexSC.src;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application {
	@Override
	public void start(Stage stage) throws Exception{
		Group root = new Group();
		Scene scene = new Scene(root, 600,600);
		stage.setTitle("test");
		stage.setScene(scene);
		stage.show();
		
	}
	public void create_GUI(String args[]) {
		launch(args);
	}
}