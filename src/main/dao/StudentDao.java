package main.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import main.model.Student;
import main.db.BasicDB;

/**
 *
 * @author zaid
 */
public class StudentDao implements IDAO
{
    private List<Student> students;
    
    public StudentDao() 
    { 
        this.students = new LinkedList<>(); 
    }
    
    public StudentDao( List<Student> students ) 
    {
        this.students = students;
    }
    
    public List<Student> getStudents() { return this.students; }
    
    public void setStudents( List<Student> students ) { this.students = students; }
    
    
    
    @Override
    public List retrieveAll()
    {
        String query = "{call getAllStudents() }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );

            ResultSet resultSet = BasicDB.call( callableStatement );

            this.students.clear();

            while( resultSet.next() )
            {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String fatherName = resultSet.getString(4);
                String motherName = resultSet.getString(5);
                String gender = resultSet.getString(6);
                int classId = resultSet.getInt(7);
                Date dateOfBirth = resultSet.getDate(8);
                Date dateOfJoin = resultSet.getDate(9);
                String phone = resultSet.getString(10);
                byte age = resultSet.getByte(11);

                Student resultStudent = new Student( id, firstName, 
                                                     lastName, fatherName, 
                                                     motherName, gender, 
                                                     classId, dateOfBirth, 
                                                     dateOfJoin, phone, age );

                this.students.add( resultStudent );
            }
            
            return this.students;
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
        String query = "{call getStudent(?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );
            
            callableStatement.setInt( 1 , id );

            ResultSet resultSet = BasicDB.call( callableStatement );

            this.students.clear();
        
            if( resultSet.next() )
            {
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String fatherName = resultSet.getString(4);
                String motherName = resultSet.getString(5);
                String gender = resultSet.getString(6);
                int classId = resultSet.getInt(7);
                Date dateOfBirth = resultSet.getDate(8);
                Date dateOfJoin = resultSet.getDate(9);
                String phone = resultSet.getString(10);
                byte age = resultSet.getByte(11);
                
                Student resultStudent = new Student( id, firstName, 
                                                     lastName, fatherName, 
                                                     motherName, gender, 
                                                     classId, dateOfBirth, 
                                                     dateOfJoin, phone, age );
                
                return resultStudent;
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
        Student student = (Student) model;
        this.students.clear();
        
        return null;
    }
    
    @Override
    public void add( Object model )
    {
        Student student = (Student) model;
        
        String query = "{call addStudentToSchool(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );
        
            callableStatement.setString( 1 , student.getFirstName() );
            callableStatement.setString( 2 , student.getLastName() );
            callableStatement.setString( 3 , student.getFatherName() );
            callableStatement.setString( 4 , student.getMotherName() );
            callableStatement.setString( 5 , student.getGender() );
            
//            callableStatement.setInt( 6 , student.getClassId() );
            callableStatement.setInt( 6 , student.getSchoolClass().getId() );
            
            callableStatement.setDate( 7 , student.getDateOfBirth() );
            callableStatement.setDate( 8 , student.getDateOfJoin() );
            callableStatement.setString( 9 , student.getPhone() );
            callableStatement.setInt( 10 , student.getAge() );


            BasicDB.callVoid( callableStatement );
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        
    }
    
    @Override
    public void update( Object model )
    {
        Student student = (Student) model;
        
        String query = "{call updateStudentInSchool(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                     .prepareCall( query );
        
            callableStatement.setInt( 1 , student.getId() );
            callableStatement.setString( 2 , student.getFirstName() );
            callableStatement.setString( 3 , student.getLastName() );
            callableStatement.setString( 4 , student.getFatherName() );
            callableStatement.setString( 5 , student.getMotherName() );
            callableStatement.setString( 6 , student.getGender() );
            
//            callableStatement.setInt( 7 , student.getClassId() );
            callableStatement.setInt( 7 , student.getSchoolClass().getId() );
            
            callableStatement.setDate(8 , student.getDateOfBirth() );
            callableStatement.setDate( 9 , student.getDateOfJoin() );
            callableStatement.setString( 10 , student.getPhone() );
            callableStatement.setInt( 11 , student.getAge() );


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
        Student student = (Student) model;
        
//        String query = "{call deleteStudentInTheSchool(" + student.getId() + ") }";
        String sqlcall = "{call deleteStudentInTheSchool(?) }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( sqlcall );
        
            callableStatement.setInt( 1 , student.getId() );

            BasicDB.callVoid(callableStatement);
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        
    }
}
