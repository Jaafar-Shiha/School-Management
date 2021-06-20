/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import main.controller.StudentController;
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
    
    ObservableList<Student> students = FXCollections.observableArrayList();
//    List<Student> students ;
    StudentDao studentDao = new StudentDao(students);
    StudentController studentController = new StudentController(studentDao);
//     private final Hyperlink updateButton = new Hyperlink("update");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            studentController.retrieveAll();

            stID.setCellValueFactory(new PropertyValueFactory<>("id"));
            fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//            fName.
            fName.setCellFactory(TextFieldTableCell.forTableColumn());
            fName.setOnEditCommit(event -> {
//                Student row = event.getRowValue();
            });   
                    
                    
                    
            lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            faName.setCellValueFactory(new PropertyValueFactory<>("fatherName"));
            moName.setCellValueFactory(new PropertyValueFactory<>("motherName"));
            gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            cls.setCellValueFactory(new PropertyValueFactory<>("classId"));
            cls.setCellFactory(TextFieldTableCell.<Student, Integer>forTableColumn(new IntegerStringConverter()));

            
            dob.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
            dob.setCellFactory(TextFieldTableCell.<Student, Date>forTableColumn(new StringConverter<Date>() {
                @Override
                public String toString(Date object) {
                    String pattern = "MM/dd/yyyy";
                    DateFormat df = new SimpleDateFormat(pattern);
                    String todayAsString = df.format(object);

                    return todayAsString;
                }

                @Override
                public Date fromString(String string) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }));
            
            
            doj.setCellValueFactory(new PropertyValueFactory<>("dateOfJoin"));
            doj.setCellFactory(TextFieldTableCell.<Student, Date>forTableColumn(new StringConverter<Date>() {
                @Override
                public String toString(Date object) {
                    String pattern = "MM/dd/yyyy";
                    DateFormat df = new SimpleDateFormat(pattern);
                    String todayAsString = df.format(object);

                    return todayAsString;
                }

                @Override
                public Date fromString(String string) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }));
            
            
            phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            
            
            age.setCellValueFactory(new PropertyValueFactory<>("age"));
            age.setCellFactory(TextFieldTableCell.<Student, Byte>forTableColumn(new StringConverter<Byte>() {
                @Override
                public String toString(Byte object) {
                    return object.toString();
                }

                @Override
                public Byte fromString(String string) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }));
            
            
            action.setCellFactory(new ActionCell(students,studentDao, studentController));
            
            studentsTable.setItems(students);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    
    
}

 
