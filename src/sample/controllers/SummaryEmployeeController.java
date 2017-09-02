package sample.controllers;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.interfaces.impls.CollectionEmployees;
import sample.objects.Employees;

import java.io.IOException;

public class SummaryEmployeeController
{
    private CollectionEmployees employeesImpl = new CollectionEmployees();

    @FXML
    private ChoiceBox chbApplying;

    @FXML
    private TextField txtFIO;

    @FXML
    private TextField txtSex;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtPlace;

    @FXML
    private TextField txtPassport;

    @FXML
    private TextField txtRegistration;

    @FXML
    private TextField txtDataRegistration;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtPhoneHome;

    @FXML
    private TextField txtPhoneMob;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEducation;

    @FXML
    private TextField txtTotalExperience;

    @FXML
    private TextField txtExperienceOrg;

    @FXML
    private TextField txtSubdivision;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtTabNumber;

    @FXML
    private TextField txtRate;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnExit;

    public void Save(ActionEvent actionEvent) {}

    public void Exit(ActionEvent actionEvent)
    {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
