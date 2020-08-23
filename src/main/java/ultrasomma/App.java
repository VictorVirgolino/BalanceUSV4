package ultrasomma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage window;
    private static FXMLLoader loader;


    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("BalanceUS");
        window.getIcons().add(new Image(getClass().getResourceAsStream("BalanceUS.png")));
        scene = new Scene(loadFXML("primary"));
        scene.getStylesheets().add(getClass().getResource("BalanceUS.css").toExternalForm());
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    static void setRoot(String fxml) throws IOException {

        scene = new Scene(loadFXML(fxml), 800, 500);
        scene.getStylesheets().add(App.class.getResource("BalanceUS.css").toExternalForm());
        window.setScene(scene);

    }

    static void setRoot(String fxml, List<List<String>> data) throws IOException {

        loader = new FXMLLoader(
                App.class.getResource(
                        "secondary.fxml"
                )
        );
        scene = new Scene(loader.load(), 800, 500);
        scene.getStylesheets().add(App.class.getResource("BalanceUS2.css").toExternalForm());
        window.setScene(scene);
        SecondaryController controller = loader.<SecondaryController>getController();
        controller.insertData(data);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}