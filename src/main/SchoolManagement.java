/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controller.ClassController;
import main.controller.StudentController;
import main.controller.TeacherController;
import main.dao.ClassDao;
import main.dao.StudentDao;
import main.dao.TeacherDao;
import main.model.SchoolClass;
import main.model.Student;

/**
 *
 * @author Jaafar
 */
public class SchoolManagement extends Application {
    
   
    @Override
    public void init()
    {
        StudentController sc = new StudentController( new StudentDao() );
        
//        Student s = new Student(4, 
//                "Marshal", "Ericksen", 
//                "Marven", "Joudy", 
//                "male", 10, 
//                new Date(86, 8, 2), new Date(114, 8, 6), 
//                "99", (byte)17 );
//        
//        sc.addButtonHandler( s );
//        sc.updateButtonHandler(s);
        
//        Student toBeDeleted = new Student();
//        toBeDeleted.setId( 7 );
//        sc.deleteButtonHandler( toBeDeleted );
        
        TeacherController tc = new TeacherController( new TeacherDao() );
//        Teacher t = new Teacher(1,
//                "teacherUUUU", "teacherUUUU", 
//                "female", new Date(193, 2, 17),
//                "1522", (byte)37, "teacherUUUU@gmail.com" );
//        
//        tc.addButtonHandler( t );
//        tc.updateButtonHandler(t);
        
//        Teacher toBeDeleted = new Teacher();
//        toBeDeleted.setId( 4 );
//        tc.deleteButtonHandler( toBeDeleted );
        
        
        ClassController cc = new ClassController( new ClassDao() );
        
//        List<SchoolClass> cs = cc.retrieveAll();
//        for( SchoolClass c: cs )
//        {
//            System.out.println( c.getId() + "\t" + c.getClassName() + "\t" + c.getLevel().getId() );
//        }
//        System.out.println( "\n***********************\n" );
        
        System.out.println( "Query Sent" );
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
