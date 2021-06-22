package main.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.controller.MainController;

/**
 * @author Safnaj on 8/12/2018
 * @project School Management System
 **/

public class DashboardMgmtController implements Initializable {
    
    public DashboardMgmtController(){
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
//    MainController mainController = new MainController();
    
    
   @FXML
    private AnchorPane children;
   
   @FXML
    private AnchorPane root;
   
   @FXML
    public Text title;


    @FXML
    void openStudentMgmtPage() {
         try {
            title.setText("Students");
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getClassLoader().getResource("main/view/Students.fxml"));
            children.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println( e);
        }
        
    }
    
    
    @FXML
    void openTeacherMgmtPage() {
         try {
             title.setText("Teachers");
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getClassLoader().getResource("main/view/Teachers.fxml"));
            children.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println( e);
        }
        
    }
    
    
    @FXML
    void openMarksMgmtPage() {
        try {
             title.setText("Marks");
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getClassLoader().getResource("main/view/Teachers.fxml"));
            children.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println( e);
        }
        
    }
}

  
