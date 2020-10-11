package gamelogic;
// The backend logic of the game
import javafx.scene.text.Font;
import javafx.scene.control.Button;

public class GameLogic {
    // The buttons that will be used in the 3x3 gridpane
    private Button[] buttonsInGridPane;
    // status if the game is over
    private boolean isGameOver;
    // how many times a button has been clicked
    private int clicksOfAButton;

    public GameLogic() {
        this.buttonsInGridPane = new Button[10];
        initButtons();
        this.isGameOver = false;
        this.clicksOfAButton = 0;
    }

    public int getClicksOfAButton() {
        return clicksOfAButton;
    }

    public void incrementClicksOfAButton() {
        clicksOfAButton++;
    }

    public Button[] getButtonsInGridPane() {
        return buttonsInGridPane;
    }

    public boolean getIsGameOver() {
        return !isGameOver;
    }

    public void setGameOver(boolean gameStatus) {
        this.isGameOver = gameStatus;
    }


    private void initButtons() { // Initializes the buttons and sets the font
        for (int i = 0; i < buttonsInGridPane.length; i++) {
            buttonsInGridPane[i] = new Button("");
            buttonsInGridPane[i].setFont(Font.font("Monospaced", 40));
        }

    }

    // Converts the one dimensional array logic into a two dimensional coordinate
    private int convert(int row, int column) {
        return row * 3 + column;
    }

    public boolean isOAWinner() {
        return isColumnAWinner("O") || isRowAWinner("O") || isDiagonalAWinner("O");
    }

    public boolean isXAWinner() {
        return isColumnAWinner("X") || isRowAWinner("X") || isDiagonalAWinner("X");
    }

    private boolean isRowAWinner(String str) {
        for (int i = 0; i < 3; i++) {
            isGameOver = true;
            for (int j = 0; j < 3; j++) {
                if ((!buttonsInGridPane[convert(i, j)].getText().equals(str))) {
                    isGameOver = false;
                    break;
                }
            }
            if (isGameOver) {
                return true;
            }
        }
        return false;
    }

    private boolean isColumnAWinner(String str) {
        for (int j = 0; j < 3; j++) {
            isGameOver = true;
            for (int i = 0; i < 3; i++) {
                if ((!buttonsInGridPane[convert(i, j)].getText().equals(str))) {
                    isGameOver = false;
                    break;
                }
            }
            if (isGameOver) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalAWinner(String str) {
        int counter = 2;
        isGameOver = true;
        for (int i = 0; i < 3; i++) {
            if ((!buttonsInGridPane[convert(i, i)].getText().equals(str))) {
                isGameOver = false;
                break;
            }
        }
        if (isGameOver) {
            return true;
        }
        isGameOver = true;
        for (int i = 0; i < 3; i++) {
            if ((!buttonsInGridPane[convert(i, counter)].getText().equals(str))) {
                isGameOver = false;
                break;

            }
            counter--;
        }
        return isGameOver;
    }
}
