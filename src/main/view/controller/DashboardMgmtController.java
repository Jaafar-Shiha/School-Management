package main.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


/**
 *
 * @author Jaafar
 */

public class DashboardMgmtController implements Initializable {
    
    public DashboardMgmtController(){
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
   @FXML
    private AnchorPane children;
   
   @FXML
    private AnchorPane root;
   
   @FXML
    public Text title;

   @FXML
    public ImageView backBtn;


    @FXML
    void openStudentMgmtPage() {
        backBtn.setVisible(true);
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
        backBtn.setVisible(true);
         try {
            title.setText("Teachers");
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getClassLoader().getResource("main/view/Teachers.fxml"));
            children.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println( e);
        }
        
    }
    
    @FXML
    void back(){
        backBtn.setVisible(false);
            try {
                title.setText("Home Page");
                AnchorPane homePage = FXMLLoader.load(getClass().getClassLoader().getResource("main/view/Dashboard.fxml"));
                children.getChildren().setAll(homePage);
            }catch(IOException e){
                System.out.println( e);
            }
    }
    
}

  
