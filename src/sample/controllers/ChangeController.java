package sample.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.interfaces.impls.CollectionEmployees;
import sample.objects.Employees;
import sample.objects.Tree;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChangeController extends TreeCell<String>
{
    @FXML
    public TreeView<String> treeSL;

    @FXML
    private Button btnChange;

    @FXML
    private Button btnAbout;

    @FXML
    private TableView<Employees> tableEmployees;

    @FXML
    private Label labelQuantity;

    @FXML
    private Button btnCreateCondidate;

    @FXML
    private Button btnDeleteCondidate;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private TableColumn<Employees, String> columnSurname;

    @FXML
    private TableColumn<Employees, String> columnName;

    @FXML
    private TableColumn<Employees, String> columnPatronymic;

    private Parent fxmlAddEmployees;
    private Parent fxmlSearchEmployees;
    private Parent fxmlAboutOrg;
    private Parent fxmlNameJtree;


    private FXMLLoader fxmlLoaderAddEmployees = new FXMLLoader();
    private FXMLLoader fxmlLoaderSearchEmployees = new FXMLLoader();
    private FXMLLoader fxmlLoaderAboutOrg = new FXMLLoader();
    private FXMLLoader fxmlLoaderNameTree = new FXMLLoader();

    private Stage addEmployeesStage;
    private Stage searchEmployeesStage;
    private Stage aboutOrgStage;
    private Stage nameTreeStage;

    private AddEmployeesController addEmployeesController;
    private NameJtreeItemController nameJtreeItemController;

    private CollectionEmployees employeesImpl = new CollectionEmployees();

    private ObservableList<Employees> backupList;

    public AboutOrg aboutOrg;

    public TextFieldTreeCellImpl txt;

    @FXML
    public void initialize()
    {
        List<Employee> employees = Arrays.<Employee>asList(
                new Employee("Jacob Smith", "Accounts Department"),
                new Employee("Isabella Johnson", "Accounts Department"),
                new Employee("Ethan Williams", "Sales Department"),
                new Employee("Emma Jones", "Sales Department"),
                new Employee("Michael Brown", "Sales Department"),
                new Employee("Anna Black", "Sales Department"),
                new Employee("Rodger York", "Sales Department"),
                new Employee("Susan Collins", "Sales Department"),
                new Employee("Mike Graham", "IT Support"),
                new Employee("Judy Mayer", "IT Support"),
                new Employee("Gregory Smith", "IT Support"));
        TreeItem<String> rootNode = new TreeItem<>("MyCompany Human Resources");
        rootNode.setExpanded(true);
        for (Employee employee : employees) {
            TreeItem<String> empLeaf = new TreeItem<>(employee.getName());
            boolean found = false;
            for (TreeItem<String> depNode : rootNode.getChildren()) {
                if (depNode.getValue().contentEquals(employee.getDepartment())){
                    depNode.getChildren().add(empLeaf);
                    found = true;
                    break;
                }
            }
            if (!found) {
                TreeItem<String> depNode = new TreeItem<>(employee.getDepartment());
                rootNode.getChildren().add(depNode);
                depNode.getChildren().add(empLeaf);
            }
        }

        treeSL.setRoot(rootNode);
        treeSL.setEditable(true);
        treeSL.setCellFactory(p -> new TextFieldTreeCellImpl());

        columnSurname.setCellValueFactory(new PropertyValueFactory<>("txtSurname"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("txtName"));
        columnPatronymic.setCellValueFactory(new PropertyValueFactory<>("txtPatronymic"));
        backupList = FXCollections.observableArrayList();
        backupList.addAll(employeesImpl.getEmployeesList());
        initListeners();
        tableEmployees.setItems(employeesImpl.getEmployeesList());
        initLoader();
    }

    private void updateCountLabel()
    {
        labelQuantity.setText(String.valueOf(employeesImpl.getEmployeesList().size()));
    }

    private void initListeners()
    {
        employeesImpl.getEmployeesList().addListener((ListChangeListener<Employees>) c -> updateCountLabel());

        tableEmployees.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2)
            {
                addEmployeesController.setEmployees(tableEmployees.getSelectionModel().getSelectedItem());
                createCondidateDialog();
            }
        });

    }

    private void initLoader()
    {
        try
        {
            fxmlLoaderAddEmployees.setLocation(getClass().getResource("../fxml/summaryEmployee.fxml"));
            fxmlAddEmployees = fxmlLoaderAddEmployees.load();
            addEmployeesController = fxmlLoaderAddEmployees.getController();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            fxmlLoaderAboutOrg.setLocation(getClass().getResource("../fxml/aboutOrg.fxml"));

            fxmlAboutOrg = fxmlLoaderAboutOrg.load();

            this.aboutOrg = (AboutOrg)fxmlLoaderAboutOrg.getController();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            fxmlLoaderNameTree.setLocation(getClass().getResource("../fxml/nameJtreeItem.fxml"));
            fxmlNameJtree = fxmlLoaderNameTree.load();
            nameJtreeItemController = fxmlLoaderNameTree.getController();
            nameJtreeItemController.changeController = this;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            fxmlLoaderSearchEmployees.setLocation(getClass().getResource("../fxml/searchEmployees.fxml"));
            fxmlSearchEmployees = fxmlLoaderSearchEmployees.load();
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
            case "btnChange":
                changeDialog(actionEvent);
                break;

            case "btnAbout":
                aboutDialog(actionEvent);
                break;

            case "btnCreateCondidate":
                addEmployeesController.setEmployees(new Employees());
                createCondidateDialog();
                employeesImpl.addEmployees(addEmployeesController.getEmployees());
                break;

            case "btnDeleteCondidate":
                employeesImpl.deleteEmployees(tableEmployees.getSelectionModel().getSelectedItem());
                break;

            case "btnSearch":
                actionSearch(actionEvent);
                searchDialog();
                break;
        }
    }

    private void changeDialog(ActionEvent actionEvent)
    {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    private void aboutDialog(ActionEvent actionEvent)
    {
        if (aboutOrgStage == null)
        {
            aboutOrgStage = new Stage();
            aboutOrgStage.setTitle("Организация");
            aboutOrgStage.setMinHeight(280);
            aboutOrgStage.setMinWidth(690);
            aboutOrgStage.setResizable(false);
            aboutOrgStage.setScene(new Scene(fxmlAboutOrg));
        }

        aboutOrgStage.show();
    }

    private void createCondidateDialog()
    {
        if (addEmployeesStage == null)
        {
            addEmployeesStage = new Stage();
            addEmployeesStage.setTitle("Организация");
            addEmployeesStage.setMinHeight(715);
            addEmployeesStage.setMinWidth(700);
            addEmployeesStage.setResizable(false);
            addEmployeesStage.setScene(new Scene(fxmlAddEmployees));
        }

        addEmployeesStage.showAndWait();
    }

    private void searchDialog()
    {
        if (searchEmployeesStage == null)
        {
            searchEmployeesStage = new Stage();
            searchEmployeesStage.setTitle("Организация");
            searchEmployeesStage.setMinHeight(370);
            searchEmployeesStage.setMinWidth(630);
            searchEmployeesStage.setResizable(false);
            searchEmployeesStage.setScene(new Scene(fxmlSearchEmployees));
        }

        searchEmployeesStage.show();
    }

    private void actionSearch(ActionEvent actionEvent)
    {
        employeesImpl.getEmployeesList().clear();

        for (Employees employees : backupList)
        {
            if (employees.gettxtSurname().toLowerCase().contains(txtSearch.getText().toLowerCase()) ||
                employees.gettxtName().toLowerCase().contains(txtSearch.getText().toLowerCase()) ||
                    employees.gettxtPatronymic().toLowerCase().contains(txtSearch.getText().toLowerCase()))
            {
                employeesImpl.getEmployeesList().add(employees);
            }
        }
    }

    private void nameTreeItem()
    {
        if (nameTreeStage == null)
        {
            nameTreeStage = new Stage();
            nameTreeStage.setTitle("Организация");
            nameTreeStage.setMinHeight(70);
            nameTreeStage.setMinWidth(300);
            nameTreeStage.setResizable(false);
            nameTreeStage.setScene(new Scene(fxmlNameJtree));
        }

        nameTreeStage.show();
    }

    private final class TextFieldTreeCellImpl extends TreeCell<String> {

        private TextField textField;
        private final ContextMenu addMenu = new ContextMenu();

        TextFieldTreeCellImpl() {
            MenuItem addMenuItem = new MenuItem("Add Employee");

            MenuItem delMenuItem = new MenuItem("Delete Employee");

            addMenu.getItems().addAll(addMenuItem, delMenuItem);
            addMenuItem.setOnAction((ActionEvent t) -> {
//                nameTreeItem();



                TreeItem<String> newEmployee =
                        new TreeItem<>("New Employee");
                getTreeItem().getChildren().add(newEmployee);
            });
            delMenuItem.setOnAction((ActionEvent t) -> {
                TreeItem<String> item = treeSL.getSelectionModel().getSelectedItem();
                if (item!=treeSL.getRoot())
                {
                    treeSL.getSelectionModel().getSelectedItem().getParent().getChildren().remove(item);
                }
            });

        }

        @Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(getTreeItem().getGraphic());
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(getTreeItem().getGraphic());
                    if (
                            !getTreeItem().isLeaf()&&getTreeItem().getParent()!= null
                            ){
                        setContextMenu(addMenu);
                    }
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setOnKeyReleased((KeyEvent t) -> {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(textField.getText());
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            });

        }

        private String getString() {
            return getItem() == null ? "" : getItem();
        }
    }

    public static class Employee {

        private final SimpleStringProperty name;
        private final SimpleStringProperty department;

        private Employee(String name, String department) {
            this.name = new SimpleStringProperty(name);
            this.department = new SimpleStringProperty(department);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String fName) {
            name.set(fName);
        }

        public String getDepartment() {
            return department.get();
        }

        public void setDepartment(String fName) {
            department.set(fName);
        }
    }
}
