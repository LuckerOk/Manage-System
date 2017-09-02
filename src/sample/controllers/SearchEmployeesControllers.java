package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.interfaces.impls.CollectionEmployees;
import sample.interfaces.impls.CollectionOrganization;
import sample.objects.Employees;
import sample.objects.Organization;

/**
 * Created by sltse on 12.08.2016.
 */
public class SearchEmployeesControllers
{
    @FXML
    private TextField txtSurname;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPatronymic;

    @FXML
    private RadioButton rbAll;

    @FXML
    private RadioButton rbCandidate;

    @FXML
    private RadioButton rbEmployees;

    @FXML
    private RadioButton rbDismissed;

    @FXML
    private TableView tableSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnExit;

    @FXML
    private TableColumn<Employees, String> columnNumber;

    @FXML
    private TableColumn<Employees, String> columnSurname;

    @FXML
    private TableColumn<Employees, String> columnName;

    @FXML
    private TableColumn<Employees, String> columnPatronymic;

    @FXML
    private TableColumn<Employees, String> columnData;

    @FXML
    private TableColumn<Employees, String> columnAddress;

    @FXML
    private TableColumn<Employees, String> columnPhoneHome;

    @FXML
    private TableColumn<Employees, String> columnPhoneMob;

    private CollectionEmployees employeesImpl = new CollectionEmployees();

    @FXML
    private void initialize()
    {
        columnNumber.setCellValueFactory(new PropertyValueFactory<Employees, String>("columnNumber"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<Employees, String>("columnSurname"));
        columnName.setCellValueFactory(new PropertyValueFactory<Employees, String>("columnName"));
        columnPatronymic.setCellValueFactory(new PropertyValueFactory<Employees, String>("columnPatronymic"));
        columnData.setCellValueFactory(new PropertyValueFactory<Employees, String>("columnData"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<Employees, String>("columnAddress"));
        columnPhoneHome.setCellValueFactory(new PropertyValueFactory<Employees, String>("columnPhoneHome"));
        columnPhoneMob.setCellValueFactory(new PropertyValueFactory<Employees, String>("columnPhoneMob"));

        tableSearch.setItems(employeesImpl.getEmployeesList());
    }

    public void search(ActionEvent actionEvent) {}

    public void reset(ActionEvent actionEvent) {}

    public void exit(ActionEvent actionEvent)
    {
        Stage stage = new Stage();
        stage.close();
    }
}
