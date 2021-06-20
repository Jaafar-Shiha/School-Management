/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controller.MainController;
import main.controller.StudentController;
import main.dao.StudentDao;
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
        
        Student s = new Student(1, 
                "James", "Wilson", 
                "father", "mother", 
                "male", 3, 
                new Date(2000, 10, 5), new Date(2021, 5, 18), 
                "12345", (byte)7 );
        
        sc.addButtonHandler( s );
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
