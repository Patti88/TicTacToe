module org.openjfx.tictactoemvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.junit.jupiter.api;
    requires org.mockito;


    opens org.openjfx.tictactoemvc to javafx.fxml;
    exports org.openjfx.tictactoemvc;
}