package main.dao;

import java.util.List;
import javafx.collections.ObservableList;
import main.db.BasicDB;
import main.model.Course;
import main.model.CourseGrade;

public class CourseGradeDao implements IDAO
{
    private ObservableList<Course> courses;
    
    public CourseGradeDao() {}
    
    public CourseGradeDao( ObservableList<Course> courses ) 
    {
        this.courses = courses;
    }
    
    public ObservableList<Course> getCourses() { return this.courses; }
    
    public void setCourses( ObservableList<Course> courses ) { this.courses = courses; }
    
    
    
    @Override
    public List retrieveAll()
    {
        return null;
    }
    
    @Override
    public Object retrieveOne( int id )
    {
        return null;
    }
    
    @Override
    public List retrieve( Object model )
    {
        return null;
    }
    
    @Override
    public void add( Object model )
    {
        CourseGrade courseGrade = (CourseGrade) model;
        
        String query = "{call addGradeToStudent(" + 
                courseGrade.getStudent().getId() + 
                courseGrade.getCourse().getId() +
                courseGrade.getMidterm() +
                courseGrade.getExam() +
                ") }";
        
        BasicDB.callVoid( query );
    }
    
    @Override
    public void update( Object model )
    {
        CourseGrade courseGrade = (CourseGrade) model;
        
        String query = "{call updateGradeOfStudent(" + 
                courseGrade.getId() + 
                courseGrade.getStudent().getId() + 
                courseGrade.getCourse().getId() +
                courseGrade.getMidterm() +
                courseGrade.getExam() +
                ") }";
        
        BasicDB.callVoid( query );
    }
    
    @Override
    public void delete( Object model )
    {
        CourseGrade courseGrade = (CourseGrade) model;
        
        courseGrade.setMidterm( (byte) 0);
        courseGrade.setExam( (byte) 0);
        
        this.update(courseGrade);
    }
}
