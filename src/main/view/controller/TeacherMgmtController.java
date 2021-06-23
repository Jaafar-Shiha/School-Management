/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view.controller;



import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import main.controller.TeacherController;
import main.dao.TeacherDao;
import main.model.Teacher;

/**
 *
 * @author Jaafar
 */
public class TeacherMgmtController implements Initializable{
    
@FXML
private TableView<Teacher> teachersTable;
    
@FXML
private TableColumn<Teacher, String> tchID;

@FXML
private TableColumn<Teacher, String> fName;

@FXML
private TableColumn<Teacher, String> lName;

@FXML
private TableColumn<Teacher, String> gender;

@FXML
private TableColumn<Teacher, Date> doj;

@FXML
private TableColumn<Teacher, String> phone;

@FXML
private TableColumn<Teacher, Byte> age;

@FXML
private TableColumn<Teacher, Byte> email;

@FXML
private TableColumn<Teacher, Teacher> action;


Byte curAge;
String curPhone;
String curFName;
String curLName;
String curGender;
String curEmail;

Date curDOJ;


Teacher curTeacher;


@FXML
private TextField fNameField;

@FXML
private TextField lNameField;


@FXML
private TextField genderField;

@FXML
private DatePicker dojPicker;

@FXML
private TextField ageField;

@FXML
private TextField phoneField;

@FXML
private TextField emailField;

@FXML
private Label errorLabel;


ObservableList<Teacher> teachers = FXCollections.observableArrayList();
TeacherDao teacherDao = new TeacherDao(teachers);
TeacherController teacherController = new TeacherController(teacherDao);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            teacherController.retrieveAll();
            
            tchID.setCellValueFactory(new PropertyValueFactory<>("id"));
            fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            doj.setCellValueFactory(new PropertyValueFactory<>("dateOfJoin"));
            gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            age.setCellValueFactory(new PropertyValueFactory<>("age"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            
            
            gender.setCellFactory(TextFieldTableCell.<Teacher, String>forTableColumn(new StringConverter<String>() {
               
                @Override
                public String toString(String object) {
                    return object;
                }

                @Override
                public String fromString(String string) {
                    if (string.equals("Male") || string.equals("Female")){
                        curGender = string;
                    }
                    return curGender;
                    
                }

            }
            ));
            
            doj.setCellFactory(TextFieldTableCell.<Teacher, Date>forTableColumn(new StringConverter<Date>() {
                @Override
                public String toString(Date object) {
                    String pattern = "yyyy-MM-dd";
                    DateFormat df = new SimpleDateFormat(pattern);
                    String todayAsString = df.format(object);

                    return todayAsString;
                }

                @Override
                public Date fromString(String string) {
                    String pattern = "yyyy-MM-dd";
                    DateFormat df = new SimpleDateFormat(pattern);
                    try {
                        curDOJ = df.parse(string);
                        return df.parse(string);
                    } catch (Exception e) {
                        return curDOJ;
                    }
                }
            }));
            
            doj.setOnEditStart((TableColumn.CellEditEvent<Teacher, Date> t) -> {
               curTeacher = t.getTableView().getItems().get(t.getTablePosition().getRow());
               curDOJ = curTeacher.getDateOfJoin();
            });
            
            
            phone.setOnEditStart((TableColumn.CellEditEvent<Teacher, String> t) -> {
                curTeacher = t.getTableView().getItems().get(t.getTablePosition().getRow());
                curPhone = curTeacher.getPhone();
            });
            
            phone.setCellFactory(TextFieldTableCell.<Teacher, String>forTableColumn(new StringConverter<String>() {
               
                @Override
                public String toString(String object) {
                    return object;
                }

                @Override
                public String fromString(String string) {
                    curPhone = string;
                    return string;
                    
                }

            }
            ));
            
            
            phone.setOnEditStart((TableColumn.CellEditEvent<Teacher, String> t) -> {
                curTeacher = t.getTableView().getItems().get(t.getTablePosition().getRow());
               
            });
            
            fName.setOnEditStart((TableColumn.CellEditEvent<Teacher, String> t) -> {
                curTeacher = t.getTableView().getItems().get(t.getTablePosition().getRow());
               
            });
            
            fName.setCellFactory(TextFieldTableCell.<Teacher, String>forTableColumn(new StringConverter<String>() {
               
                @Override
                public String toString(String object) {
                    return object;
                }

                @Override
                public String fromString(String string) {
                    curFName = string;
                    return string;
                    
                }
            }
            ));
            
            
             lName.setOnEditStart((TableColumn.CellEditEvent<Teacher, String> t) -> {
                curTeacher = t.getTableView().getItems().get(t.getTablePosition().getRow());
               
            });
            
            lName.setCellFactory(TextFieldTableCell.<Teacher, String>forTableColumn(new StringConverter<String>() {
               
                @Override
                public String toString(String object) {
                    return object;
                }

                @Override
                public String fromString(String string) {
                    curLName = string;
                    return string;
                    
                }
            }
            ));
            
            
            age.setOnEditStart((TableColumn.CellEditEvent<Teacher, Byte> t) -> {
                curTeacher = t.getTableView().getItems().get(t.getTablePosition().getRow());
                curAge = curTeacher.getAge();
               
            });
           
            age.setCellFactory(TextFieldTableCell.<Teacher, Byte>forTableColumn(new StringConverter<Byte>() {
               
                @Override
                public String toString(Byte object) {
                    return object.toString();
                }

                @Override
                public Byte fromString(String string) {
                    try {
                        curAge = Byte.decode(string);
                        return Byte.decode(string);
                    } catch (Exception e) {
                        return curAge;
                    }
                }
            }
            ));
            
            age.setOnEditCommit((TableColumn.CellEditEvent<Teacher, Byte> t) -> {
                teachers.get(teachers.indexOf(curTeacher)).setAge(curAge);
            });
            
            phone.setOnEditCommit((TableColumn.CellEditEvent<Teacher, String> t) -> {
                teachers.get(teachers.indexOf(curTeacher)).setPhone(curPhone);
            });
            
            fName.setOnEditCommit((TableColumn.CellEditEvent<Teacher, String> t) -> {
                teachers.get(teachers.indexOf(curTeacher)).setFirstName(curFName);
            });
            
            lName.setOnEditCommit((TableColumn.CellEditEvent<Teacher, String> t) -> {
                teachers.get(teachers.indexOf(curTeacher)).setLastName(curLName);
            });
            
            gender.setOnEditCommit((TableColumn.CellEditEvent<Teacher, String> t) -> {
                teachers.get(teachers.indexOf(curTeacher)).setGender(curGender);
            });
            
             doj.setOnEditCommit((TableColumn.CellEditEvent<Teacher, Date> t) -> {
                java.sql.Date sd = new java.sql.Date(curDOJ.getTime());
                teachers.get(teachers.indexOf(curTeacher)).setDateOfJoin(sd);
            });
            
            
            action.setCellFactory(new ActionCell(teachers,teacherDao, teacherController));
            teachersTable.setItems(teachers);
        } catch (Exception e) {
        }
        
    }
  
    @FXML
    public void addTeacherToDb(ActionEvent event){
        try {
            LocalDate dojLocalDate = dojPicker.getValue();
            Instant dojInstant = Instant.from(dojLocalDate.atStartOfDay(ZoneId.systemDefault()));
            Date dojDate = Date.from(dojInstant);
            java.sql.Date dojSqlDate = new java.sql.Date(dojDate.getTime());
            
            Byte tchAge = Byte.decode(ageField.getText());
            
            
            String tchGender = genderField.getText();
            if (!tchGender.equals("Male") && !tchGender.equals("Female")){
                errorLabel.setVisible(true);
                return;
            }
            errorLabel.setVisible(false);
            Teacher newtch = new Teacher(fNameField.getText(),
                    lNameField.getText(),
                    tchGender,
                    dojSqlDate, phoneField.getText(), tchAge, emailField.getText());
            teacherController.addButtonHandler(newtch);
            
            fNameField.setText("");
            lNameField.setText("");
            genderField.setText("");
            dojPicker.setValue(null);
            phoneField.setText("");
            ageField.setText("");
            emailField.setText("");
            
            teacherController.retrieveAll();
        } catch (Exception e) {
            System.out.println( e + "dvsb ");
            errorLabel.setVisible(true);
        }
        
        
    
}
}