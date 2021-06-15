package main.controller;

import main.dao.CourseDao;

public class CourseController extends AbstractController
{
    private CourseDao courseDao;
    
    public CourseController( CourseDao courseDao )
    {
        super( courseDao );
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
