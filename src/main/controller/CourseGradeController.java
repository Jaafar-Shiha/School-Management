package main.controller;

import java.util.List;
import main.dao.CourseGradeDao;
import main.model.CourseGrade;

/**
 *
 * @author zaid
 */
public class CourseGradeController extends AbstractController
{
    public CourseGradeController( CourseGradeDao courseDao )
    {
        super( courseDao );
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
        CourseGrade courseGeade = (CourseGrade) model;
        
        super.getDao().add(courseGeade );
    }

    @Override
    public void updateButtonHandler( Object model ) 
    {
        CourseGrade courseGeade = (CourseGrade) model;
        
        super.getDao().update(courseGeade );
    }

    @Override
    public void deleteButtonHandler( Object model ) 
    {
        CourseGrade courseGeade = (CourseGrade) model;
        
        super.getDao().delete( courseGeade );
    }
}
