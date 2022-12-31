package calcfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private final int WIDTH = 300;
    private final int HEIGHT = 350;

    public static void main(String args[]) {
        System.out.println("Teste");
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        stage.setTitle("Calculator");
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.show();        
    }
}
