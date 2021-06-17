package main.controller;

import java.util.List;
import main.dao.CourseDao;

public class CourseController extends AbstractController
{
    private CourseDao courseDao;
    
    public CourseController( CourseDao courseDao )
    {
        super( courseDao );
    }
    

    
    @Override
    public List retrieveAll()
    {
        return null;
    }
    
    @Override
    public List retrieve( Object model )
    {
        return null;
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
