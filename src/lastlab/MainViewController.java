/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lastlab;

/**
 *
 * @author Cheero
 */
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;

import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javax.print.DocFlavor.URL;

public class MainViewController {
    
    @FXML
    private AnchorPane mainPane;
    
    @FXML
    private MenuItem closeItem;

    @FXML
    private MenuItem copyItem;

    @FXML
    private MenuItem findItem;

    @FXML
    private CheckMenuItem gridItem;

    @FXML
    private RadioMenuItem largeItem;

    @FXML
    private RadioMenuItem mediumItem;

    @FXML
    private MenuItem newItem;

    @FXML
    private MenuItem openItem;

    @FXML
    private MenuItem replaceItem;

    @FXML
    private MenuItem saveItem;

    @FXML
    private RadioMenuItem smallItem;

    @FXML
    void handleClose(ActionEvent event) {
        System.out.println("CLOSE has been pressed");
        newItem.setDisable(false);
        openItem.setDisable(false);
        closeItem.setDisable(true);
    }

    @FXML
    void handleCopy(ActionEvent event) {
        System.out.println("COPY has been pressed");
    }

    @FXML
    void handleFind(ActionEvent event) {
        System.out.println("FIND has been pressed");
    }

    @FXML
    void handleGrid(ActionEvent event) {
        if (gridItem.isSelected()) {
            System.out.println("USE GRIDLINES selected");
        } else {
            System.out.println("USE GRIDLINES unselected");
        }
    }

    @FXML
    void handleNew(ActionEvent event) {
        System.out.println("NEW has been pressed");
        newItem.setDisable(true);
        openItem.setDisable(true);
        closeItem.setDisable(false);
    }

    @FXML
    void handleOpen(ActionEvent event) {
        System.out.println("OPEN has been pressed");
        newItem.setDisable(false);
        openItem.setDisable(true);
        closeItem.setDisable(false);
    }

    @FXML
    void handleReplace(ActionEvent event) {
        System.out.println("REPLACE has been pressed");
    }

    @FXML
    void handleSizeLarge(ActionEvent event) {
        System.out.println("LARGE has been pressed");
        smallItem.setSelected(false);
        mediumItem.setSelected(false);
    }

    @FXML
    void handleSizeMedium(ActionEvent event) {
        System.out.println("MEDIUM has been pressed");
        smallItem.setSelected(false);
        largeItem.setSelected(false);
    }

    @FXML
    void handleSizeSmall(ActionEvent event) {
        System.out.println("SMALL has been pressed");
        largeItem.setSelected(false);
        mediumItem.setSelected(false);
    }

    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup tg = new ToggleGroup();
        smallItem.setToggleGroup(tg);
        mediumItem.setToggleGroup(tg);
        largeItem.setToggleGroup(tg);
        closeItem.setDisable(true); // disabled until a file is "opened"
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        ContextMenu popup = new ContextMenu();
        MenuItem help = new MenuItem("Help");
        MenuItem inspect = new MenuItem("Inspect");
        popup.getItems().addAll(help, inspect);
        mainPane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                popup.show(mainPane, e.getScreenX() - 50, e.getScreenY()
                        - 25);
            }
        });

    }

}
