/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view.controller;

import java.io.IOException;
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
import javafx.util.converter.IntegerStringConverter;
import main.controller.ClassController;
import main.controller.StudentController;
import main.dao.ClassDao;
import main.dao.StudentDao;
import main.model.Student;

/**
 * FXML Controller class
 *
 * @author Jaafar
 */
public class StudentsMgmtController implements Initializable {
    
    @FXML
    private TableView<Student> studentsTable;
    
    @FXML
    private TableColumn<Student, String> stID;
    
    @FXML
    private TableColumn<Student, String> fName;
    
    @FXML
    private TableColumn<Student, String> lName;
    
    @FXML
    private TableColumn<Student, String> faName;
    
    @FXML
    private TableColumn<Student, String> moName;
    
    @FXML
    private TableColumn<Student, String> gender;
    
    @FXML
    private TableColumn<Student, Integer> cls;
    
    @FXML
    private TableColumn<Student, Date> dob;
    
    @FXML
    private TableColumn<Student, Date> doj;
    
    @FXML
    private TableColumn<Student, String> phone;
    
    @FXML
    private TableColumn<Student, Byte> age;
    
    @FXML
    private TableColumn<Student, Student> action;
    
    
    @FXML
    private TextField fNameField;
    
    @FXML
    private TextField lNameField;
    
    @FXML
    private TextField faNameField;
    
    @FXML
    private TextField moNameField;
    
    @FXML
    private TextField genderField;
    
    @FXML
    private DatePicker dobPicker;
    
    @FXML
    private DatePicker dojPicker;
    
    @FXML
    private TextField clsField;
    
    @FXML
    private TextField ageField;
    
    @FXML
    private TextField phoneField;
    
    @FXML
    private Label errorLabel;
    
    Byte curAge;
    String curPhone;
    String curFName;
    String curLName;
    String curFaName;
    String curMoName;
    String curGender;
    Date curDOB;
    Date curDOJ;
    int curCls;
    Student curStudent;
    
    ObservableList<Student> students = FXCollections.observableArrayList();
    StudentDao studentDao = new StudentDao(students);
    StudentController studentController = new StudentController(studentDao);

    ObservableList<main.model.SchoolClass> classes = FXCollections.observableArrayList();
    ClassDao classDao = new ClassDao(classes);
    ClassController classController = new ClassController(classDao);


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        try {

            studentController.retrieveAll();

            stID.setCellValueFactory(new PropertyValueFactory<>("id"));
            fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            fName.setCellFactory(TextFieldTableCell.forTableColumn());
                    
            lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            faName.setCellValueFactory(new PropertyValueFactory<>("fatherName"));
            moName.setCellValueFactory(new PropertyValueFactory<>("motherName"));
            gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            gender.setOnEditStart((TableColumn.CellEditEvent<Student, String> t) -> {
               curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
               curGender = curStudent.getGender();
            });
            
            gender.setCellFactory(TextFieldTableCell.<Student, String>forTableColumn(new StringConverter<String>() {
               
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
            
            
           cls.setCellValueFactory(new PropertyValueFactory<>("classId"));
            cls.setCellFactory(TextFieldTableCell.<Student, Integer>forTableColumn(new IntegerStringConverter()));

            cls.setOnEditStart((TableColumn.CellEditEvent<Student, Integer> t) -> {
                curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
                curCls = curStudent.getClassId();
               
            });
            
            
            cls.setCellFactory(TextFieldTableCell.<Student, Integer>forTableColumn(new StringConverter<Integer>() {
               
                @Override
                public String toString(Integer object) {
                    return object.toString();
                }

                @Override
                public Integer fromString(String string) {
                    try {
                        curCls = Integer.parseInt(string);
                        return curCls;
                    } catch (Exception e) {
                        return curCls;
                    }
                }
            }
            ));
            
            dob.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
            dob.setCellFactory(TextFieldTableCell.<Student, Date>forTableColumn(new StringConverter<Date>() {
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
                        curDOB = df.parse(string);
                        return df.parse(string);
                    } catch (Exception e) {
                        return curDOB;
                    }
                }
            }));
            
            dob.setOnEditStart((TableColumn.CellEditEvent<Student, Date> t) -> {
               curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
               curDOB = curStudent.getDateOfBirth();
            });
            
            
            doj.setCellValueFactory(new PropertyValueFactory<>("dateOfJoin"));
            doj.setCellFactory(TextFieldTableCell.<Student, Date>forTableColumn(new StringConverter<Date>() {
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
            
            doj.setOnEditStart((TableColumn.CellEditEvent<Student, Date> t) -> {
               curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
               curDOJ = curStudent.getDateOfJoin();
            });
            
            phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            phone.setOnEditStart((TableColumn.CellEditEvent<Student, String> t) -> {
                curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
                curPhone = curStudent.getPhone();
            });
            
            phone.setCellFactory(TextFieldTableCell.<Student, String>forTableColumn(new StringConverter<String>() {
               
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
            
            phone.setOnEditStart((TableColumn.CellEditEvent<Student, String> t) -> {
                curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
               
            });
            
            
            fName.setOnEditStart((TableColumn.CellEditEvent<Student, String> t) -> {
                curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
               
            });
            
            fName.setCellFactory(TextFieldTableCell.<Student, String>forTableColumn(new StringConverter<String>() {
               
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
            
            lName.setOnEditStart((TableColumn.CellEditEvent<Student, String> t) -> {
                curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
               
            });
            
            lName.setCellFactory(TextFieldTableCell.<Student, String>forTableColumn(new StringConverter<String>() {
               
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
            
            faName.setOnEditStart((TableColumn.CellEditEvent<Student, String> t) -> {
                curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
               
            });
            
            faName.setCellFactory(TextFieldTableCell.<Student, String>forTableColumn(new StringConverter<String>() {
               
                @Override
                public String toString(String object) {
                    return object;
                }

                @Override
                public String fromString(String string) {
                    curFaName = string;
                    return string;
                    
                }
            }
            ));
            
            
            moName.setOnEditStart((TableColumn.CellEditEvent<Student, String> t) -> {
                curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
               
            });
            
            moName.setCellFactory(TextFieldTableCell.<Student, String>forTableColumn(new StringConverter<String>() {
               
                @Override
                public String toString(String object) {
                    return object;
                }

                @Override
                public String fromString(String string) {
                    curMoName = string;
                    return string;
                    
                }
            }
            ));
            
            age.setCellValueFactory(new PropertyValueFactory<>("age"));
            age.setOnEditStart((TableColumn.CellEditEvent<Student, Byte> t) -> {
                curStudent = t.getTableView().getItems().get(t.getTablePosition().getRow());
                curAge = curStudent.getAge();
               
            });
           
            age.setCellFactory(TextFieldTableCell.<Student, Byte>forTableColumn(new StringConverter<Byte>() {
               
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
            
            
            
            
            
            age.setOnEditCommit((TableColumn.CellEditEvent<Student, Byte> t) -> {
                students.get(students.indexOf(curStudent)).setAge(curAge);
            });
            
            phone.setOnEditCommit((TableColumn.CellEditEvent<Student, String> t) -> {
                students.get(students.indexOf(curStudent)).setPhone(curPhone);
            });
            
            fName.setOnEditCommit((TableColumn.CellEditEvent<Student, String> t) -> {
                students.get(students.indexOf(curStudent)).setFirstName(curFName);
            });
            
            lName.setOnEditCommit((TableColumn.CellEditEvent<Student, String> t) -> {
                students.get(students.indexOf(curStudent)).setLastName(curLName);
            });
            
            faName.setOnEditCommit((TableColumn.CellEditEvent<Student, String> t) -> {
                students.get(students.indexOf(curStudent)).setFatherName(curFaName);
            });
            
            moName.setOnEditCommit((TableColumn.CellEditEvent<Student, String> t) -> {
                students.get(students.indexOf(curStudent)).setMotherName(curMoName);
            });
            
            gender.setOnEditCommit((TableColumn.CellEditEvent<Student, String> t) -> {
                students.get(students.indexOf(curStudent)).setGender(curGender);
            });
            
            cls.setOnEditCommit((TableColumn.CellEditEvent<Student, Integer> t) -> {
                students.get(students.indexOf(curStudent)).setClassId(curCls);
            });
            
            dob.setOnEditCommit((TableColumn.CellEditEvent<Student, Date> t) -> {
                java.sql.Date sd = new java.sql.Date(curDOB.getTime());
                students.get(students.indexOf(curStudent)).setDateOfBirth(sd);
            });
            
            
            doj.setOnEditCommit((TableColumn.CellEditEvent<Student, Date> t) -> {
                java.sql.Date sd = new java.sql.Date(curDOJ.getTime());
                students.get(students.indexOf(curStudent)).setDateOfJoin(sd);
            });
            
            action.setCellFactory(new ActionCell(students,studentDao, studentController));
            
            
            studentsTable.setItems(students);
//            studentController.retrieveAll();
           
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    
    @FXML
    public void addStudentToDb(ActionEvent event){
        try {
            
            classController.retrieveAll();
            
            LocalDate dobLocalDate = dobPicker.getValue();
            Instant dobInstant = Instant.from(dobLocalDate.atStartOfDay(ZoneId.systemDefault()));
            Date dobDate = Date.from(dobInstant);
            java.sql.Date dobSqlDate = new java.sql.Date(dobDate.getTime());

            LocalDate dojLocalDate = dojPicker.getValue();
            Instant dojInstant = Instant.from(dojLocalDate.atStartOfDay(ZoneId.systemDefault()));
            Date dojDate = Date.from(dojInstant);
            java.sql.Date dojSqlDate = new java.sql.Date(dojDate.getTime());
            
            Byte stdAge = Byte.decode(ageField.getText());
            
            int stdClass = Integer.parseInt(clsField.getText());
            
            boolean isValidClass = false;
            for(int i=0;i<classes.size();i++){
                if (stdClass == classes.get(i).getId()){
                    isValidClass = true;
                    break;
                }
            }
            
            if (!isValidClass) {
                errorLabel.setVisible(true);
                return ;
            }
            
            String stdGender = genderField.getText();
            if (!stdGender.equals("Male") && !stdGender.equals("Female")){
                errorLabel.setVisible(true);
                return;
            }
            errorLabel.setVisible(false);
            Student newStd = new Student(fNameField.getText(),
                    lNameField.getText(),
                    faNameField.getText(), moNameField.getText(),
                    stdGender,
                    stdClass, dobSqlDate,
                    dojSqlDate, phoneField.getText(), stdAge);
            studentController.addButtonHandler(newStd);
            
            fNameField.setText("");
            lNameField.setText("");
            faNameField.setText("");
            moNameField.setText("");
            genderField.setText("");
            clsField.setText("");
            dobPicker.setValue(null);
            dojPicker.setValue(null);
            phoneField.setText("");
            ageField.setText("");
            
            studentController.retrieveAll();
        } catch (Exception e) {
            System.out.println(e);
            errorLabel.setVisible(true);
        }
        
    }
    


}