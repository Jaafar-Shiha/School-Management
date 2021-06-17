package main.controller;

import java.util.List;
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
    public List<Object> retrieve( Object model )
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
