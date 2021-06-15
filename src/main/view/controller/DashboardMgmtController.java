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
import javafx.stage.Stage;
import main.controller.MainController;

/**
 * @author Safnaj on 8/12/2018
 * @project School Management System
 **/

public class DashboardMgmtController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
//    MainController mainController = new MainController();
    
    @FXML
    private ImageView StudentMgmt;

   

    @FXML
    void openStudentMgmtPage() {
        System.out.println("Finally");
        
        }
    }

  
