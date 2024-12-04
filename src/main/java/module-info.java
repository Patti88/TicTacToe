module org.openjfx.tictactoemvc {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;


    opens org.openjfx.tictactoemvc to javafx.fxml;
    exports org.openjfx.tictactoemvc;
}