package main.controller;

import java.util.List;
import main.dao.TeacherDao;
import main.model.Teacher;

/**
 *
 * @author zaid
 */
public class TeacherController extends AbstractController
{
    public TeacherController( TeacherDao teacherDao )
    {
        super( teacherDao );
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
        return super.getDao().retrieve(model);
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
