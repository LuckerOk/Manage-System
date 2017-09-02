package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.objects.Organization;

import java.util.HashMap;

/**
 * Created by sltse on 09.08.2016.
 */
public class AddController
{
    @FXML
    private TextField txtFIO;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtShortName;

    @FXML
    private TextField txtLegalAddress;

    @FXML
    private TextField txtActualAddress;

    @FXML
    private TextField txtTelephone;

    @FXML
    private TextField txtFax;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtWWW;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnNotSave;

    private Organization organization;

    public MainController mainController;

    public void setOrganization(Organization organization)
    {
        if (organization == null){return;}
        this.organization = organization;
        txtFIO.setText(organization.getFIO());
        txtPosition.setText(organization.getPosition());
        txtFullName.setText(organization.getFullName());
        txtShortName.setText(organization.getShortName());
        txtLegalAddress.setText(organization.getLegalAddress());
        txtActualAddress.setText(organization.getActualAddress());
        txtTelephone.setText(organization.getTelephone());
        txtFax.setText(organization.getFax());
        txtEmail.setText(organization.getEmail());
        txtWWW.setText(organization.getWWW());
    }

    public Organization getOrganization(){return organization;}

    public void saveOrganization(ActionEvent actionEvent)
    {
        organization.setFIO(txtFIO.getText());
        organization.setPosition(txtPosition.getText());
        organization.setFullName(txtFullName.getText());
        organization.setShortName(txtShortName.getText());
        organization.setLegalAddress(txtLegalAddress.getText());
        organization.setActualAddress(txtActualAddress.getText());
        organization.setTelephone(txtTelephone.getText());
        organization.setFax(txtFax.getText());
        organization.setEmail(txtEmail.getText());
        organization.setWWW(txtWWW.getText());

        mainController.changeController.aboutOrg.initData(organization);

        notSaveOrganization(actionEvent);
    }

    public void notSaveOrganization(ActionEvent actionEvent)
    {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
