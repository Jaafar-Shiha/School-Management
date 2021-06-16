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
    public void addButtonHandler( Object model ) 
    {
        
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
