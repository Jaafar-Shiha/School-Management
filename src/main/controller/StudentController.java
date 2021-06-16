package main.controller;

import main.dao.StudentDao;
import main.model.Student;

public class StudentController extends AbstractController
{
    public StudentController( StudentDao studentDao )
    {
        super( studentDao );
    }


    @Override
    public void addButtonHandler( Object model ) 
    {
        Student student = (Student) model;
        
        super.getDao().add( student );
        
//        super.getDao().add(this);
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
