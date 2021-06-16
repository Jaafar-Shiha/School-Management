package main.controller;

import main.dao.TeacherDao;

public class TeacherController extends AbstractController
{
    private TeacherDao teacherDao;
    
    public TeacherController( TeacherDao teacherDao )
    {
        super( teacherDao );
    }
    
    
    @Override
    public void addButtonHandler( Object model ) 
    {
        
        
//        super.getDao().add(this);
    }

    @Override
    public void updateButtonHandler( Object model ) 
    {
        
    }

    @Override
    public void deleteButtonHandler( Object model ) 
    {
        
    }
}
