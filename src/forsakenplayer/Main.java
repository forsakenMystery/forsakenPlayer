package forsakenplayer;

/**
 *
 * @author forsakenmystery
 */
import Initialization.Config;
import Utility.Preference;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private static final Config c = Config.getConfig();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
        primaryStage.setTitle("Forsaken Player");
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(Double.valueOf(c.getPreferences().getProperty(Preference.Height+"")));
        primaryStage.setWidth(Double.valueOf(c.getPreferences().getProperty(Preference.Width+"")));
        primaryStage.setFullScreen(Boolean.getBoolean(c.getPreferences().getProperty(Preference.FullScreen+"")));
        primaryStage.setX(Double.valueOf(c.getPreferences().getProperty(Preference.X+"")));
        primaryStage.setY(Double.valueOf(c.getPreferences().getProperty(Preference.Y+"")));
        primaryStage.setAlwaysOnTop(Boolean.getBoolean(c.getPreferences().getProperty(Preference.ForceTop+"")));
        primaryStage.setOnCloseRequest((t) -> {
//            System.out.println("c = " + c.getPreferences());
            c.getPreferences().setProperty(Preference.Width+"", primaryStage.getWidth() + "");
            c.getPreferences().setProperty(Preference.Height+"", primaryStage.getHeight() + "");
            c.getPreferences().setProperty(Preference.X+"", primaryStage.getX() + "");
            c.getPreferences().setProperty(Preference.Y+"", primaryStage.getY() + "");
            c.getPreferences().setProperty(Preference.FullScreen+"", primaryStage.isFullScreen()+"");
            c.getPreferences().setProperty(Preference.ForceTop+"", primaryStage.isAlwaysOnTop()+"");

            try {
                File configFile = new File("config.xml");
                OutputStream outputStream = new FileOutputStream(configFile);

                c.getPreferences().storeToXML(outputStream, "config");
                outputStream.close();
            } catch (IOException ex) {
                // I/O error where the fuck is it
            }
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
