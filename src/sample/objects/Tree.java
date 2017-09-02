package sample.objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tree
{
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty nameJTreeItem = new SimpleStringProperty("");

    public Tree(String name) {this.name = new SimpleStringProperty(name);}

    public Tree(){}

    public String getName(){return name.get();}
    @Override
    public String toString() {return getName();}

    public String getNameJTreeItem() {return nameJTreeItem.get();}

    public SimpleStringProperty nameJTreeItemProperty() {return nameJTreeItem;}

    public void setNameJTreeItem(String nameJTreeItem) {
        this.nameJTreeItem.set(nameJTreeItem);
    }

    private ObservableList<Tree> treeList = FXCollections.observableArrayList();

    public void add(Tree treeItem) {treeList.add(treeItem);}

    public ObservableList<Tree> getTreeList() {return treeList;}
}
