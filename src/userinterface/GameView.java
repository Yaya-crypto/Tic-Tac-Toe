package userinterface;
// The userinterface of the game
import gamelogic.GameLogic;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javafx.scene.control.Label;
import java.util.Arrays;

public class GameView {
    BorderPane borderPane;
    GameLogic gameLogic;
    GridPane gridPane;
    Label whosTurn;

    public GameView() {
        this.borderPane = new BorderPane();
        this.gameLogic = new GameLogic();
        this.gridPane = new GridPane();
        this.whosTurn = new Label("Turn: X");
    }

    public Pane gameLayout() {
        borderPane.setTop(whosTurn);
        borderPane.setCenter(getGrid());
        pressFunction();

        return borderPane;
    }

    public void pressFunction() {
        Arrays.stream(gameLogic.getButtonsInGridPane()).forEach(buttonInArray -> buttonInArray.setOnAction((event) -> {
            if (buttonInArray.getText().isEmpty() && whosTurn.getText().equalsIgnoreCase("Turn: X") && gameLogic.getIsGameOver()) {
                gameLogic.incrementClicksOfAButton();
                buttonInArray.setText("X");
                if (gameLogic.isXAWinner()) {
                    whosTurn.setText("X is a winner!");
                    gameLogic.setGameOver(true);
                } else
                    whosTurn.setText("Turn: O");

            } else if (buttonInArray.getText().isEmpty() && gameLogic.getIsGameOver()) {
                gameLogic.incrementClicksOfAButton();
                buttonInArray.setText("O");
                if (gameLogic.isOAWinner()) {
                    whosTurn.setText("O is a winner");
                    gameLogic.setGameOver(true);
                } else
                    whosTurn.setText("Turn: X");

            }
            if (gameLogic.getClicksOfAButton() == 9) {
                gameLogic.setGameOver(true);
                whosTurn.setText("Game is a Tie!");
            }
        }));

    }

    private GridPane getGrid() {
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        int i = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                gridPane.add(gameLogic.getButtonsInGridPane()[i], x, y);
                i++;
            }
        }

        return gridPane;
    }

}
