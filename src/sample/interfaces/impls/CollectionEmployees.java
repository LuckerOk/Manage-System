package sample.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.objects.Employees;
import sample.objects.Organization;

public class CollectionEmployees implements sample.interfaces.Employees
{
    private ObservableList<Employees> employeesList = FXCollections.observableArrayList();

    @Override
    public void addEmployees(Employees employees) {employeesList.add(employees);}

    @Override
    public void deleteEmployees(Employees employees) {employeesList.remove(employees);}

    public ObservableList<Employees> getEmployeesList() {return employeesList;}
}
