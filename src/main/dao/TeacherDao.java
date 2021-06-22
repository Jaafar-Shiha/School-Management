package main.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import javafx.collections.ObservableList;
import main.db.BasicDB;
import main.model.Teacher;

/**
 *
 * @author zaid
 */
public class TeacherDao implements IDAO
{
    private ObservableList<Teacher> teachers;
    
    public TeacherDao() {}
    
    public TeacherDao( ObservableList<Teacher> teachers ) 
    {
        this.teachers = teachers;
    }
    
    public ObservableList<Teacher> getTeachers() { return this.teachers; }
    
    public void setTeachers( ObservableList<Teacher> teachers ) { this.teachers = teachers; }
    
    
    
    @Override
    public List retrieveAll()
    {
        String query = "{call getAllTeachers() }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );

            ResultSet resultSet = BasicDB.call( callableStatement );
        
            this.teachers.clear();
        
            while( resultSet.next() )
            {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String gender = resultSet.getString(4);
                Date dateOfJoin = resultSet.getDate(5);
                String phone = resultSet.getString(6);
                byte age = resultSet.getByte(7);
                String email = resultSet.getString(8);
                
                Teacher resultTeacher = new Teacher( id, firstName, 
                                                     lastName, gender, 
                                                     dateOfJoin, phone, 
                                                     age, email );
                
                this.teachers.add( resultTeacher );
            }
            
            return this.teachers;
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public Object retrieveOne( int id )
    {
        String query = "{call getTeacher(?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );
            
            callableStatement.setInt( 1 , id );

            ResultSet resultSet = BasicDB.call( callableStatement );

            this.teachers.clear();
        
            if( resultSet.next() )
            {
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String gender = resultSet.getString(4);
                Date dateOfJoin = resultSet.getDate(5);
                String phone = resultSet.getString(6);
                byte age = resultSet.getByte(7);
                String email = resultSet.getString(8);
                
                Teacher resultTeacher = new Teacher( id, firstName, 
                                                     lastName, gender, 
                                                     dateOfJoin, phone, 
                                                     age, email );
                
                return resultTeacher;
            }
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public List retrieve( Object model )
    {
//        Teacher teacher = (Teacher) model;
//        this.teachers.clear();
//        
//        return null;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void add( Object model )
    {
        Teacher teacher = (Teacher) model;
        
        String query = "{call addTeacherToSchool(?, ?, ?, ?, ?, ?, ?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );
        
            callableStatement.setString( 1 , teacher.getFirstName() );
            callableStatement.setString( 2 , teacher.getLastName() );
            callableStatement.setString( 3 , teacher.getGender() );
            callableStatement.setDate( 4 , teacher.getDateOfJoin() );
            callableStatement.setString( 5 , teacher.getPhone() );
            callableStatement.setInt( 6 , teacher.getAge() );
            callableStatement.setString( 7 , teacher.getEmail() );

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
        Teacher teacher = (Teacher) model;
        
        String query = "{call updateTeacherInSchool(?, ?, ?, ?, ?, ?, ?, ?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );
        
            callableStatement.setInt( 1 , teacher.getId() );
            callableStatement.setString( 2 , teacher.getFirstName() );
            callableStatement.setString( 3 , teacher.getLastName() );
            callableStatement.setString( 4 , teacher.getGender() );
            callableStatement.setDate( 5 , teacher.getDateOfJoin() );
            callableStatement.setString( 6 , teacher.getPhone() );
            callableStatement.setInt( 7 , teacher.getAge() );
            callableStatement.setString( 8 , teacher.getEmail() );

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
        Teacher teacher = (Teacher) model;
        
//        String query = "{call deleteTeacherInTheSchool(" + teacher.getId() + ") }";
        String query = "{call deleteTeacherInTheSchool(?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );
        
            callableStatement.setInt( 1 , teacher.getId() );

            BasicDB.callVoid(callableStatement);
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        
    }
}
