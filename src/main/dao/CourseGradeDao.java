package main.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import main.db.BasicDB;
import main.model.Course;
import main.model.CourseGrade;
import main.model.Student;

/**
 *
 * @author zaid
 */
public class CourseGradeDao implements IDAO
{
    private List<CourseGrade> coursesGrades;
    
    public CourseGradeDao() {}
    
    public CourseGradeDao( List<CourseGrade> coursesGrades ) 
    {
        this.coursesGrades = coursesGrades;
    }
    
    public List<CourseGrade> getCourses() { return this.coursesGrades; }
    
    public void setCourses( List<CourseGrade> coursesGrades ) { this.coursesGrades = coursesGrades; }
    
    
    
    @Override
    public List retrieveAll()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object retrieveOne( int id )
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List retrieve( Object model )
    {
        String query = "{call getMarksOfStudent( ? ) }";
        
        Student student = (Student) model;
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );

            callableStatement.setInt( 1 , student.getId() );
            
            ResultSet resultSet = BasicDB.call( callableStatement );

            this.coursesGrades.clear();

            while( resultSet.next() )
            {
//                int id = resultSet.getInt(1);
                int studentId = resultSet.getInt(1);
                int courseId = resultSet.getInt(2);
                byte midterm = resultSet.getByte(3);
                byte exam = resultSet.getByte(4);
                byte finalGrade = resultSet.getByte(5);
                
                Student resultStudent = new Student();
                resultStudent.setId( studentId );
                
                Course resultCourse = new Course();
                resultCourse.setId( courseId );

                CourseGrade resultCourseGrade = new CourseGrade( resultStudent, 
                                                     resultCourse, midterm, 
                                                     exam, finalGrade );

                this.coursesGrades.add( resultCourseGrade );
            }
            
            return this.coursesGrades;
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public void add( Object model )
    {
//        CourseGrade courseGrade = (CourseGrade) model;
//        
//        
//        String query = "{call addGradeToStudent(?, ?, ?, ?) }";
//        
//        try
//        {
//            CallableStatement callableStatement = BasicDB.getConnection()
//                                                     .prepareCall( query );
//        
//            callableStatement.setInt( 1 , courseGrade.getStudent().getId() );
//            callableStatement.setInt( 2 , courseGrade.getCourse().getId() );
//            callableStatement.setByte( 3 , courseGrade.getMidterm() );
//            callableStatement.setByte( 4 , courseGrade.getExam() );
//
//            BasicDB.callVoid(callableStatement);
//        }
//        catch( SQLException sqle )
//        {
//            sqle.printStackTrace();
//        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    @Override
    public void update( Object model )
    {
        CourseGrade courseGrade = (CourseGrade) model;
        
        String query = "{call updateMarkToStudent(?, ?, ?, ?, ?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                     .prepareCall( query );
        
//            callableStatement.setInt( 1 , courseGrade.getId() );
//            callableStatement.setInt( 2 , courseGrade.getStudent().getId() );
//            callableStatement.setInt( 3 , courseGrade.getCourse().getId() );
//            callableStatement.setByte( 4 , courseGrade.getMidterm() );
//            callableStatement.setByte( 5 , courseGrade.getExam() );
            callableStatement.setInt( 1 , courseGrade.getStudent().getId() );
            callableStatement.setInt( 2 , courseGrade.getCourse().getId() );
            callableStatement.setByte( 3 , courseGrade.getMidterm() );
            callableStatement.setByte( 4 , courseGrade.getExam() );
            callableStatement.setByte( 5 , courseGrade.getFinalGrade() );

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
