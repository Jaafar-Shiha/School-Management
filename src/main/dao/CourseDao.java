package main.dao;

import java.util.List;
import javafx.collections.ObservableList;
import main.model.Course;

public class CourseDao implements IDAO
{
    private ObservableList<Course> courses;
    
    public CourseDao() {}
    
    public CourseDao( ObservableList<Course> courses ) 
    {
        this.courses = courses;
    }
    
    public ObservableList<Course> getCourses() { return this.courses; }
    
    public void setCourses( ObservableList<Course> courses ) { this.courses = courses; }
    
    @Override
    public List retrieve( Object model )
    {
        return null;
    }
    
    @Override
    public void add( Object model )
    {
        
    }
    
    @Override
    public void update( Object model )
    {
        
    }
    
    @Override
    public void delete( Object model )
    {
        
    }
}
