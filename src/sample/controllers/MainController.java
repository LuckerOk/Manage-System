package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.interfaces.impls.CollectionOrganization;
import sample.objects.Organization;

import javax.swing.text.ChangedCharSetException;
import java.io.IOException;
import java.util.Map;

public class MainController
{
    private CollectionOrganization organizationImpl = new CollectionOrganization();

    private Stage mainStage;

    public ChangeController changeController;

    /*@FXML
    private TableView tableMain;*/

    @FXML
    private Label lbShortName;

    @FXML
    private Label lbFIO;

    @FXML
    private Button btnMainAdd;

    @FXML
    private Button btnMainEdit;

    @FXML
    private Button btnMainDelete;

    @FXML
    private Button btnMainChange;

    @FXML
    private Button btnMainExit;

    /*@FXML
    private TableColumn<Organization, String> columnShortName;

    @FXML
    private TableColumn<Organization, String> columnMainFIO;*/

    private Parent fxmlEdit;
    private Parent fxmlChange;
    private FXMLLoader fxmlLoaderMain = new FXMLLoader();
    private FXMLLoader fxmlLoaderChange = new FXMLLoader();
    private AddController editDialogController;
    private ChangeController changeDialogController;
    private Stage editDialogStage;
    private Stage changeDialogStage;

    private ObservableList<Organization> orgList;

    public ObservableList<Organization> getOrgList() {
        return orgList;
    }

    public void setMainStage(Stage mainStage) {this.mainStage = mainStage;}

    @FXML
    private void initialize()
    {
        //columnShortName.setCellValueFactory(new PropertyValueFactory<Organization, String>("shortName"));
        //columnMainFIO.setCellValueFactory(new PropertyValueFactory<Organization, String>("FIO"));
        //initListeners();

        //tableMain.setItems(organizationImpl.getOrganizationList());

        initLoader();
    }

    /*private void initListeners()
    {
        tableMain.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if (event.getClickCount() == 2)
                {
                    editDialogController.setOrganization((Organization) tableMain.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        });
    }*/

    private void initLoader()
    {
        try
        {
            fxmlLoaderMain.setLocation(getClass().getResource("../fxml/addOrganization.fxml"));
            fxmlEdit = fxmlLoaderMain.load();
            editDialogController = fxmlLoaderMain.getController();
            editDialogController.mainController = this;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            fxmlLoaderChange.setLocation(getClass().getResource("../fxml/changeOrganization.fxml"));
            fxmlChange = fxmlLoaderChange.load();

            changeController = fxmlLoaderChange.getController();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void actionButtonPressed(ActionEvent actionEvent)
    {
        Object source = actionEvent.getSource();

        if (!(source instanceof Button)){return;}

        Button clickedButton = (Button) source;

        switch (clickedButton.getId())
        {
            case "btnMainAdd":

                editDialogController.setOrganization(new Organization());
                showDialog();
                organizationImpl.addOrganization(editDialogController.getOrganization());
                orgList = FXCollections.observableArrayList();
                orgList.addAll(organizationImpl.getOrganizationList());
                for (Organization org : orgList)
                {
                    lbShortName.setText(org.getShortName());
                    lbFIO.setText(org.getFIO());
                }
                break;

            /*case "btnMainEdit":
                //editDialogController.setOrganization((Organization) tableMain.getSelectionModel().getSelectedItem());
                showDialog();
                break;*/

            /*case "btnMainDelete":
                organizationImpl.deleteOrganization((Organization)tableMain.getSelectionModel().getSelectedItem());
                break;*/

            case "btnMainChange":
                changeOrganization();
                break;

            case "btnMainExit":
                close(actionEvent);
                break;
        }
    }

    public void close(ActionEvent actionEvent)
    {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private void showDialog()
    {
        if (editDialogStage == null)
        {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Организация");
            editDialogStage.setMinHeight(175);
            editDialogStage.setMinWidth(690);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }

        editDialogStage.showAndWait();
    }

    private void changeOrganization()
    {
        if (changeDialogStage == null)
        {
            changeDialogStage = new Stage();
            changeDialogStage.setTitle("Организация");
            changeDialogStage.setMinHeight(766);
            changeDialogStage.setMinWidth(1366);
            changeDialogStage.setMaximized(true);
            changeDialogStage.setResizable(false);
            changeDialogStage.setScene(new Scene(fxmlChange));
        }

        changeDialogStage.show();
    }
}
