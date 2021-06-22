/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import main.controller.CourseGradeController;
import main.dao.CourseGradeDao;
import main.model.Course;
import main.model.CourseGrade;
import main.model.SchoolClass;
import main.model.Student;

/**
 *
 * @author Jaafar
 */
public class MarksMgmtController implements Initializable {
    
    
    @FXML
    private TableView<CourseGrade> marksTable;
    
//    @FXML
//    private TableColumn<CourseGrade, String> courseId;
    
    @FXML
    private TableColumn<CourseGrade, Byte> midterm;
    
    @FXML
    private TableColumn<CourseGrade, Byte> exam;
    
    public Student st;
    
    @FXML
    private TableColumn<CourseGrade, Byte> finalGrade;
    
//    private Student st;
    
    ObservableList<CourseGrade> marks = FXCollections.observableArrayList();
    CourseGradeDao courseGradeDao = new CourseGradeDao(marks);
    CourseGradeController marksController = new CourseGradeController(courseGradeDao);
    
    void initData(Student std) {
//        marksController.retrieve(std);
        
//        midterm.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        
//        midterm.setCellValueFactory(new PropertyValueFactory<>("age"));
//            midterm.setOnEditStart((TableColumn.CellEditEvent<CourseGrade, Byte> t) -> {
//               
//            });
            
        
            
            marks.add(new CourseGrade(0, 
                    new Student("first", "frst", "fa", "mo", "Male", 1, (java.sql.Date) new Date(5), (java.sql.Date) new Date(5), "523", Byte.decode("5")),
                    new Course(1, "Mat", new SchoolClass(2, "Second", new main.model.Level(1, "First"))), Byte.decode("63"), Byte.decode("93"), Byte.decode("100")));
            
              
        marksTable.setItems(marks);

//        courseId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        exam.setCellValueFactory(new PropertyValueFactory<>("exam"));
//        finalGrade.setCellValueFactory(new PropertyValueFactory<>("finalGrade"));
//        System.out.println("afe" +marks.get(1).getCourse().getId());

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println("sgr" + this.st.getFatherName());
       
    }
    
}
