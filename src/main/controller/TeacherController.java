package main.controller;

import main.dao.TeacherDao;
import main.model.Teacher;

public class TeacherController extends AbstractController
{
    public TeacherController( TeacherDao teacherDao )
    {
        super( teacherDao );
    }
    
    
    @Override
    public void addButtonHandler( Object model ) 
    {
        Teacher teacher = (Teacher) model;
        
        super.getDao().add( teacher );
    }

    @Override
    public void updateButtonHandler( Object model ) 
    {
        Teacher teacher = (Teacher) model;
        
        super.getDao().update( teacher );
    }

    @Override
    public void deleteButtonHandler( Object model ) 
    {
        Teacher teacher = (Teacher) model;
        
        super.getDao().delete( teacher );
    }
}
