package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import sample.Main;

public class RootLayoutController {
    Main main;

    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void handleHelp(ActionEvent actionEvent) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Program Information");
        alert.setHeaderText("This is a sample JAVAFX application for SWTESTACADEMY!");
        alert.setContentText("You can search, delete, update, insert a new employee with this program.");
        alert.show();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return main;
    }
}
