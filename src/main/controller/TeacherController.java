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
    public void addButtonHandler() 
    {
        
    }

    @Override
    public void updateButtonHandler() 
    {
        
    }

    @Override
    public void deleteButtonHandler() 
    {
        
    }
}
