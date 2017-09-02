package sample.objects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by sltse on 06.08.2016.
 */
public class Organization
{
    private SimpleStringProperty shortName = new SimpleStringProperty("");
    private SimpleStringProperty FIO = new SimpleStringProperty("");
    private SimpleStringProperty employeesFIO = new SimpleStringProperty("");
    private SimpleStringProperty columnNumber = new SimpleStringProperty("");
    private SimpleStringProperty columnSurname = new SimpleStringProperty("");
    private SimpleStringProperty columnName = new SimpleStringProperty("");
    private SimpleStringProperty columnPatronymic = new SimpleStringProperty("");
    private SimpleStringProperty columnData = new SimpleStringProperty("");
    private SimpleStringProperty columnAddress = new SimpleStringProperty("");
    private SimpleStringProperty columnPhoneHome = new SimpleStringProperty("");
    private SimpleStringProperty columnPhoneMob = new SimpleStringProperty("");
    private SimpleStringProperty Position = new SimpleStringProperty("");
    private SimpleStringProperty FullName = new SimpleStringProperty("");
    private SimpleStringProperty LegalAddress = new SimpleStringProperty("");
    private SimpleStringProperty ActualAddress = new SimpleStringProperty("");
    private SimpleStringProperty Telephone = new SimpleStringProperty("");
    private SimpleStringProperty Fax = new SimpleStringProperty("");
    private SimpleStringProperty Email = new SimpleStringProperty("");
    private SimpleStringProperty WWW = new SimpleStringProperty("");

    public Organization(){}

    public String getShortName() {return shortName.get();}

    public void setShortName(String shortName) {this.shortName.set(shortName);}

    public String getFIO() {return FIO.get();}

    public void setFIO(String FIO) {this.FIO.set(FIO);}

    public String getEmployeesFIO() {return employeesFIO.get();}

    public void setEmployeesFIO(String employeesFIO) {this.employeesFIO.set(employeesFIO);}

    public String getColumnNumber() {return columnNumber.get();}

    public void setColumnNumber(String columnNumber) {this.columnNumber.set(columnNumber);}

    public String getColumnSurname() {return columnSurname.get();}

    public void setColumnSurname(String columnSurname) {this.columnSurname.set(columnSurname);}

    public String getColumnName() {return columnName.get();}

    public void setColumnName(String columnName) {this.columnName.set(columnName);}

    public String getColumnPatronymic() {return columnPatronymic.get();}

    public void setColumnPatronymic(String columnPatronymic) {this.columnPatronymic.set(columnPatronymic);}

    public String getColumnData() {return columnData.get();}

    public void setColumnData(String columnData) {this.columnData.set(columnData);}

    public String getColumnAddress() {return columnAddress.get();}

    public void setColumnAddress(String columnAddress) {this.columnAddress.set(columnAddress);}

    public String getColumnPhoneHome() {return columnPhoneHome.get();}

    public void setColumnPhoneHome(String columnPhoneHome) {this.columnPhoneHome.set(columnPhoneHome);}

    public String getColumnPhoneMob() {return columnPhoneMob.get();}

    public void setColumnPhoneMob(String columnPhoneMob) {this.columnPhoneMob.set(columnPhoneMob);}

    public String getPosition() {return Position.get();}

    public void setPosition(String Position) {this.Position.set(Position);}

    public String getFullName() {return FullName.get();}

    public void setFullName(String FullName) {this.FullName.set(FullName);}

    public String getLegalAddress() {return LegalAddress.get();}

    public void setLegalAddress(String LegalAddress) {this.LegalAddress.set(LegalAddress);}

    public String getActualAddress() {return ActualAddress.get();}

    public void setActualAddress(String ActualAddress) {this.ActualAddress.set(ActualAddress);}

    public String getTelephone() {return Telephone.get();}

    public void setTelephone(String Telephone) {this.Telephone.set(Telephone);}

    public String getFax() {return Fax.get();}

    public void setFax(String Fax) {this.Fax.set(Fax);}

    public String getEmail() {return Email.get();}

    public void setEmail(String Email) {this.Email.set(Email);}

    public String getWWW() {return WWW.get();}

    public void setWWW(String WWW) {this.WWW.set(WWW);}

    public SimpleStringProperty shortNameProperty() {return shortName;}

    public SimpleStringProperty FIOProperty() {return FIO;}

    public SimpleStringProperty employeesFIOProperty() {return employeesFIO;}

    public SimpleStringProperty columnNumberProperty() {return columnNumber;}

    public SimpleStringProperty columnSurnameProperty() {return columnSurname;}

    public SimpleStringProperty columnNameProperty() {return columnName;}

    public SimpleStringProperty columnPatronymicProperty() {return columnPatronymic;}

    public SimpleStringProperty columnDataProperty() {return columnData;}

    public SimpleStringProperty columnAddressProperty() {return columnAddress;}

    public SimpleStringProperty columnPhoneHomeProperty() {return columnPhoneHome;}

    public SimpleStringProperty columnPhoneMobProperty() {return columnPhoneMob;}

    public SimpleStringProperty PositionProperty() {return Position;}

    public SimpleStringProperty FullNameProperty() {return FullName;}

    public SimpleStringProperty LegalAddressProperty() {return LegalAddress;}

    public SimpleStringProperty ActualAddressProperty() {return ActualAddress;}

    public SimpleStringProperty TelephoneProperty() {return Telephone;}

    public SimpleStringProperty FaxProperty() {return Fax;}

    public SimpleStringProperty EmailProperty() {return Email;}

    public SimpleStringProperty WWWProperty() {return WWW;}
}