package main.controller;

import java.util.List;
import javafx.collections.ObservableList;
import main.dao.StudentDao;
import main.model.Student;

public class StudentController extends AbstractController
{
    public StudentController( StudentDao studentDao )
    {
        super( studentDao );
    }

    
    @Override
    public List retrieveAll()
    {
        return super.getDao().retrieveAll();
    }
    
    @Override
    public Object retrieveOne( int id )
    {
        return super.getDao().retrieveOne( id );
    }
    
    @Override
    public List retrieve( Object model )
    {
        return super.getDao().retrieve( model );
    }

    @Override
    public void addButtonHandler( Object model ) 
    {
        Student student = (Student) model;
        
        super.getDao().add( student );
    }

    @Override
    public void updateButtonHandler( Object model ) 
    {
        Student student = (Student) model;
        
        super.getDao().update( student );
    }

    @Override
    public void deleteButtonHandler( Object model ) 
    {
        Student student = (Student) model;
        
        super.getDao().delete( student );
    }
}
