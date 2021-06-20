/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controller.StudentController;
import main.controller.TeacherController;
import main.dao.StudentDao;
import main.dao.TeacherDao;
import main.model.Student;
import main.model.Teacher;

/**
 *
 * @author Jaafar
 */
public class SchoolManagement extends Application {
    
   
    @Override
    public void init()
    {
//        StudentController sc = new StudentController( new StudentDao() );
//        
//        Student s = new Student(1, 
//                "Ted", "Mosby", 
//                "ddd", "qqq", 
//                "male", 2, 
//                new Date(98, 10, 24), new Date(121, 6, 19), 
//                "99", (byte)14 );
        
//        sc.addButtonHandler( s );
        
//        Student toBeDeleted = new Student();
//        toBeDeleted.setId( 1 );
//        sc.deleteButtonHandler( toBeDeleted );
        
//        TeacherController tc = new TeacherController( new TeacherDao() );
//        Teacher t = new Teacher(5,
//                "teacher3First", "teacher3Last", 
//                "male", new Date(180, 1, 16),
//                "111", (byte)45, "teacher3@gmail.com" );
        
//        tc.addButtonHandler( t );
        
//        Teacher toBeDeleted = new Teacher();
//        toBeDeleted.setId( 2 );
//        tc.deleteButtonHandler( toBeDeleted );
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Dashboard.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
