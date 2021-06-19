/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import main.controller.AbstractController;
import main.controller.StudentController;
import main.dao.IDAO;
import main.dao.StudentDao;
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

    @Override
    protected void updateItem(T student, boolean empty) {
        if (getIndex() >= listOfObjects.size()){
            setGraphic(null);
            return ;
        }

        HBox pane = new HBox(10,updateButton, deleteButton);
        setGraphic(pane);
                
        deleteButton.setOnAction(event -> {
            T object = getTableView().getItems().get(getIndex());
            controller.deleteButtonHandler(object);
            listOfObjects.remove(object);
        });
//
        updateButton.setOnAction(event -> {
            T object = getTableView().getItems().get(getIndex());
//            studentController.updateButtonHandler(std);
            
        });

        
    }
};
        return cell;
    }
}
