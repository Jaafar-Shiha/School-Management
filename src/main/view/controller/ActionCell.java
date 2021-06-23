/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.controller.AbstractController;
import main.dao.IDAO;
import main.model.CourseGrade;
import main.model.Student;

/**
 *
 * @author Jaafar
 */
public class ActionCell<T> implements  Callback<TableColumn<T, T>, TableCell<T, T>> {

    
    private ObservableList<T> listOfObjects = FXCollections.observableArrayList();
    IDAO dao;
    AbstractController controller ;
    public ActionCell(ObservableList<T> listOfObjects,IDAO dao, AbstractController controller){
        this.listOfObjects = listOfObjects;
        this.dao = dao;
        this.controller = controller;
    }

    @Override
    public TableCell<T, T> call(TableColumn<T, T> arg) {
        TableCell<T, T> cell = new TableCell<T, T>() {
    private final Button updateButton = new Button("Update");
    private final Button deleteButton = new Button("Delete");
    private final Button showMarksButton = new Button("Show marks");

    @Override
    protected void updateItem(T model, boolean empty) {
        if (getIndex() >= listOfObjects.size()){
            setGraphic(null);
            return ;
        }
        HBox pane ;
        try {
            CourseGrade object = (CourseGrade) getTableView().getItems().get(0);
            pane = new HBox(10,updateButton);
        } catch (Exception e) {
            try {
            Student object = (Student) getTableView().getItems().get(0);
            pane = new HBox(10,updateButton, deleteButton, showMarksButton);
        } catch (Exception ee) {
            pane = new HBox(10,updateButton, deleteButton);
        }
        }
        
        
        
        setGraphic(pane);
                
        deleteButton.setOnAction(event -> {
            T object = getTableView().getItems().get(getIndex());
            controller.deleteButtonHandler(object);
            listOfObjects.remove(object);
        });

        updateButton.setOnAction(event -> {
            T object = getTableView().getItems().get(getIndex());
            controller.updateButtonHandler(object);
        });
        
        showMarksButton.setOnAction(event -> {
            T object = getTableView().getItems().get(getIndex());

            try {
                FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                    "/main/view/Marks.fxml"
                  )
                );
                Stage stage = new Stage();
                Scene scene = new Scene(loader.load());
                MarksMgmtController controller = loader.getController();
                controller.initData(((Student) object));
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ActionCell.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
    }
};
        return cell;
    }
}
