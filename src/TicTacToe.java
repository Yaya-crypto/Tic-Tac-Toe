import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userinterface.GameView;
/* This program is a simple TicTacToe application made using JavaFx.
It is divided into two packages.
One storing the backend logic and another storing the UI
 */
public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameView layout = new GameView();

        Scene scene = new Scene(layout.gameLayout());
        primaryStage.setTitle("Tic Tac Toe Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
