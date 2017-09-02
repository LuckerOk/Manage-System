package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;
import sample.objects.Tree;

public class NameJtreeItemController
{
    @FXML
    private TextField txtName;

    @FXML
    private Button btnOk;

    public ChangeController changeController;

    public String name;

    public void save(ActionEvent actionEvent)
    {
        name = txtName.getText();
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();

        TreeItem<String> item = new TreeItem<>();
        item.setValue(name);

    }
}
