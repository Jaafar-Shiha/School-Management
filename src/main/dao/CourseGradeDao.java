package main.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import main.db.BasicDB;
import main.model.Course;
import main.model.CourseGrade;

/**
 *
 * @author zaid
 */
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
        
        
        String query = "{call addGradeToStudent(?, ?, ?, ?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                     .prepareCall( query );
        
            callableStatement.setInt( 1 , courseGrade.getStudent().getId() );
            callableStatement.setInt( 2 , courseGrade.getCourse().getId() );
            callableStatement.setByte( 3 , courseGrade.getMidterm() );
            callableStatement.setByte( 4 , courseGrade.getExam() );

            BasicDB.callVoid(callableStatement);
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        
    }
    
    @Override
    public void update( Object model )
    {
        CourseGrade courseGrade = (CourseGrade) model;
        
        String query = "{call updateGradeOfStudent(?, ?, ?, ?, ?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                     .prepareCall( query );
        
            callableStatement.setInt( 1 , courseGrade.getId() );
            callableStatement.setInt( 2 , courseGrade.getStudent().getId() );
            callableStatement.setInt( 3 , courseGrade.getCourse().getId() );
            callableStatement.setByte( 4 , courseGrade.getMidterm() );
            callableStatement.setByte( 5 , courseGrade.getExam() );

            BasicDB.callVoid(callableStatement);
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        
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
