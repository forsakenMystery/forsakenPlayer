package forsakenplayer;

/**
 *
 * @author forsakenmystery
 */
import Initialization.Config;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final Config c = Config.getConfig();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
        primaryStage.setTitle("Forsaken Player");
        primaryStage.setScene(new Scene(root));
        primaryStage.setAlwaysOnTop(Boolean.getBoolean(c.getPreferences().getProperty("AlwaysOnTop")));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
