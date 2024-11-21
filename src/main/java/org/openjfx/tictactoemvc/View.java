package org.openjfx.tictactoemvc;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class View extends Application {

    private Button[][] buttons;
    private Label resultLabel;
    private Controller controller; // Reference to the Controller object

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane for arranging the buttons
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        // Create the buttons and add them to the GridPane
        int ROWS = 3;
        int COLS = 3;
        buttons = new Button[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                gridPane.add(button, col, row);
                buttons[row][col] = button;

                // Add an event handler for each button
                int Row = row;
                int Col = col;
                button.setOnAction(_ -> {
                    // Pass row and col to Controller
                    controller.handleButtonClick(Row, Col);
                });
            }
        }

        // Create a Label to display the result
        resultLabel = new Label();
        resultLabel.setFont(new Font("Arial", 20));
        gridPane.add(resultLabel, 0, ROWS + 1, COLS, 1);

        // Create a scene and set it on the stage
        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create a Controller object
        controller = new Controller(new Model(), this);
    }

    public void updateButton(int row, int col, char player) {
        buttons[row][col].setText(Character.toString(player));
        if (player == 'X' || player == 'O') {
            buttons[row][col].setDisable(true); // Prevent clicking the same button again
        }
    }

    public void showGameOverMessage(char winner) {
        String message;
        if (winner == ' ') {
            message = "Draw!";
        } else {
            message = "Player " + winner + " wins!";
        }
        resultLabel.setText(message);

        // Display the reset screen after the game ends
        new ResetScreen(this, controller.getModel()).show();
    }
    public Label getResultLabel() {
        return resultLabel;
    }

    public void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setDisable(true);
            }
        }
    }

    public void enableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setDisable(false);
            }
        }
    }}