module org.openjfx.tictactoemvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.openjfx.tictactoemvc to javafx.fxml;
    exports org.openjfx.tictactoemvc;
}