package sample.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.objects.Organization;

public class CollectionOrganization implements sample.interfaces.Organization
{
    private ObservableList<Organization> organizationList = FXCollections.observableArrayList();

    @Override
    public void addOrganization(Organization organization) {organizationList.add(organization);}

    @Override
    public void deleteOrganization(Organization organization) {organizationList.remove(organization);}

    public ObservableList<Organization> getOrganizationList() {return organizationList;}
}
