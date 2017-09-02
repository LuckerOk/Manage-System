package sample.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.objects.Organization;

import java.util.Map;

public class AboutOrg
{
    @FXML
    protected Label lbAbFIO;

    @FXML
    private Label lbPosition;

    @FXML
    private Label lbFullName;

    @FXML
    private Label lbShortName;

    @FXML
    private Label lbLegalAddress;

    @FXML
    private Label lbFactAddress;

    @FXML
    private Label lbTelephone;

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbFax;

    @FXML
    private Label lbWww;


    public void initData(Organization org){
        lbAbFIO.setText(org.getFIO());
        lbPosition.setText(org.getPosition());
        lbFullName.setText(org.getFullName());
        lbShortName.setText(org.getShortName());
        lbLegalAddress.setText(org.getLegalAddress());
        lbFactAddress.setText(org.getActualAddress());
        lbTelephone.setText(org.getTelephone());
        lbEmail.setText(org.getEmail());
        lbFax.setText(org.getFax());
        lbWww.setText(org.getWWW());
    }
}
