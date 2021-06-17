package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
import main.model.Student;
import main.db.BasicDB;

public class StudentDao implements IDAO
{
    private ObservableList<Student> students;
    
    public StudentDao() {}
    
    public StudentDao( ObservableList<Student> students ) 
    {
        this.students = students;
    }
    
    public ObservableList<Student> getStudents() { return this.students; }
    
    public void setStudents( ObservableList<Student> students ) { this.students = students; }
    
    
    
    @Override
    public List retrieveAll()
    {
        String query = "{call getAllStudents() }";
        
        ResultSet resultSet = BasicDB.call(query);
        
        try
        {
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
                String phone = resultSet.getString(9);
                byte age = resultSet.getByte(9);
                
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
    public List retrieve( Object model )
    {
        Student student = (Student) model;
        
        return null;
    }
    
    @Override
    public void add( Object model )
    {
        Student student = (Student) model;
        
        String query = "{call addStudentToSchool(" + 
                student.getFirstName() + 
                student.getLastName() + 
                student.getFatherName() +
                student.getMotherName() +
                student.getGender() +
                student.getClassId() +
                student.getDateOfBirth() +
                student.getDateOfJoin() +
                student.getPhone() +
                student.getAge() +
                ") }";
        
        BasicDB.callVoid(query);
    }
    
    @Override
    public void update( Object model )
    {
        Student student = (Student) model;
        
        String query = "{call updateStudentInSchool(" + 
                student.getId() + 
                student.getFirstName() + 
                student.getLastName() + 
                student.getFatherName() +
                student.getMotherName() +
                student.getGender() +
                student.getClassId() +
                student.getDateOfBirth() +
                student.getDateOfJoin() +
                student.getPhone() +
                student.getAge() +
                ") }";
        
        BasicDB.callVoid(query);
    }
    
    @Override
    public void delete( Object model )
    {
        Student student = (Student) model;
        
        String query = "{call deleteStudentInTheSchool(" + student.getId() + ") }";
        
        BasicDB.callVoid(query);
    }
}
