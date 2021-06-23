/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view.controller;

import java.net.URL;
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
import main.controller.CourseGradeController;
import main.dao.CourseGradeDao;
import main.model.Course;
import main.model.CourseGrade;
import main.model.Student;

/**
 *
 * @author Jaafar
 */
public class MarksMgmtController implements Initializable {
    
    
    @FXML
    private TableView<CourseGrade> marksTable;
    
    @FXML
    private TableColumn<CourseGrade, Course> courseId;
    
    @FXML
    private TableColumn<CourseGrade, Byte> midterm;
    
    @FXML
    private TableColumn<CourseGrade, Byte> exam;

    public Student st;
    
    @FXML
    private TableColumn<CourseGrade, Byte> finalGrade;
    
    @FXML
    private TableColumn<Student, Student> action;
    
    Byte curMidTerm;
    Byte curExam;
    Byte curFinalGrade;
    
    
    private CourseGrade curCourseGrade;
    
    ObservableList<CourseGrade> marks = FXCollections.observableArrayList();
    CourseGradeDao courseGradeDao = new CourseGradeDao(marks);
    CourseGradeController marksController = new CourseGradeController(courseGradeDao);
    
    void initData(Student std) {
        marksController.retrieve(std);
        
        courseId.setCellValueFactory(new PropertyValueFactory<>("course"));
        courseId.setCellFactory(TextFieldTableCell.<CourseGrade, Course>forTableColumn(new StringConverter<Course>() {
            @Override
            public String toString(Course object) {
                return Integer.toString(object.getId());

            }

            @Override
            public Course fromString(String string) {
                return null;
            }
        }));

        midterm.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        
        midterm.setCellFactory(TextFieldTableCell.<CourseGrade, Byte>forTableColumn(new StringConverter<Byte>() {
            @Override
            public String toString(Byte object) {
                return object.toString();
            }

            @Override
            public Byte fromString(String string) {
                try {
                    curMidTerm = Byte.decode(string);
                    return Byte.decode(string);
                } catch (Exception e) {
                    return curMidTerm;
                }
            }
        }));
        
        midterm.setOnEditStart((TableColumn.CellEditEvent<CourseGrade, Byte> t) -> {
            curCourseGrade = t.getTableView().getItems().get(t.getTablePosition().getRow());
            curMidTerm = curCourseGrade.getMidterm();
               
        });
        
        midterm.setOnEditCommit((TableColumn.CellEditEvent<CourseGrade, Byte> t) -> {
            marks.get(marks.indexOf(curCourseGrade)).setMidterm(curMidTerm);
            });
        exam.setCellValueFactory(new PropertyValueFactory<>("exam"));
        
        exam.setCellFactory(TextFieldTableCell.<CourseGrade, Byte>forTableColumn(new StringConverter<Byte>() {
            @Override
            public String toString(Byte object) {
                return object.toString();
            }

            @Override
            public Byte fromString(String string) {
                try {
                    curExam = Byte.decode(string);
                    return Byte.decode(string);
                } catch (Exception e) {
                    return curExam;
                }
            }
        }));
        
        
        exam.setOnEditStart((TableColumn.CellEditEvent<CourseGrade, Byte> t) -> {
            curCourseGrade = t.getTableView().getItems().get(t.getTablePosition().getRow());
            curExam = curCourseGrade.getExam();
               
        });
        
        exam.setOnEditCommit((TableColumn.CellEditEvent<CourseGrade, Byte> t) -> {
            marks.get(marks.indexOf(curCourseGrade)).setExam(curExam);
        });
        
        finalGrade.setCellValueFactory(new PropertyValueFactory<>("finalGrade"));

        finalGrade.setCellFactory(TextFieldTableCell.<CourseGrade, Byte>forTableColumn(new StringConverter<Byte>() {
            @Override
            public String toString(Byte object) {
                return object.toString();
            }

            @Override
            public Byte fromString(String string) {
                 try {
                    curFinalGrade = Byte.decode(string);
                    return Byte.decode(string);
                } catch (Exception e) {
                    return curFinalGrade;
                }
            }
        }));
        
        finalGrade.setOnEditStart((TableColumn.CellEditEvent<CourseGrade, Byte> t) -> {
            curCourseGrade = t.getTableView().getItems().get(t.getTablePosition().getRow());
            curFinalGrade = curCourseGrade.getFinalGrade();
               
        });
        
        finalGrade.setOnEditCommit((TableColumn.CellEditEvent<CourseGrade, Byte> t) -> {
            marks.get(marks.indexOf(curCourseGrade)).setFinalGrade(curFinalGrade);
        });
        
        marksTable.setItems(marks);
        
        action.setCellFactory(new ActionCell(marks,courseGradeDao, marksController));

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}
