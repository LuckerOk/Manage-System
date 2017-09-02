package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.objects.Employees;
import sample.objects.Organization;

public class AddEmployeesController
{
    @FXML
    private TextField txtSurname;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPatronymic;

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
    private RadioButton RMale;

    @FXML
    private RadioButton RFemale;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnExit;

    private Employees employees;

    public void setEmployees(Employees employees)
    {
        if (employees == null){return;}
        this.employees = employees;
        txtSurname.setText(employees.gettxtSurname());
        txtName.setText(employees.gettxtName());
        txtPatronymic.setText(employees.gettxtPatronymic());
        txtAge.setText(employees.gettxtAge());
        txtData.setText(employees.gettxtData());
        txtPlace.setText(employees.gettxtPlace());
        txtPassport.setText(employees.gettxtPassport());
        txtRegistration.setText(employees.gettxtRegistration());
        txtDataRegistration.setText(employees.gettxtDataRegistration());
        txtAddress.setText(employees.gettxtAddress());
        txtPhoneHome.setText(employees.gettxtPhoneHome());
        txtPhoneMob.setText(employees.gettxtPhoneMob());
        txtEmail.setText(employees.gettxtEmail());
        txtEducation.setText(employees.gettxtEducation());
        txtTotalExperience.setText(employees.gettxtTotalExperience());
        txtExperienceOrg.setText(employees.gettxtExperienceOrg());
        txtSubdivision.setText(employees.gettxtSubdivision());
        txtPosition.setText(employees.gettxtPosition());
        txtTabNumber.setText(employees.gettxtTabNumber());
        txtRate.setText(employees.gettxtRate());
    }

    public Employees getEmployees(){return employees;}

    public void Exit(ActionEvent actionEvent)
    {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void Save(ActionEvent actionEvent)
    {
        employees.settxtName(txtName.getText());
        employees.settxtSurname(txtSurname.getText());
        employees.settxtPatronymic(txtPatronymic.getText());
        employees.settxtAge(txtAge.getText());
        employees.settxtData(txtData.getText());
        employees.settxtPlace(txtPlace.getText());
        employees.settxtPassport(txtPassport.getText());
        employees.settxtRegistration(txtRegistration.getText());
        employees.settxtDataRegistration(txtDataRegistration.getText());
        employees.settxtAddress(txtAddress.getText());
        employees.settxtPhoneHome(txtPhoneHome.getText());
        employees.settxtPhoneMob(txtPhoneMob.getText());
        employees.settxtEmail(txtEmail.getText());
        employees.settxtEducation(txtEducation.getText());
        employees.settxtTotalExperience(txtTotalExperience.getText());
        employees.settxtExperienceOrg(txtExperienceOrg.getText());
        employees.settxtSubdivision(txtSubdivision.getText());
        employees.settxtPosition(txtPosition.getText());
        employees.settxtTabNumber(txtTabNumber.getText());
        employees.settxtRate(txtRate.getText());
        Exit(actionEvent);
    }
}
