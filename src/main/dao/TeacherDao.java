package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
import main.db.BasicDB;
import main.model.Teacher;

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
        
        ResultSet resultSet = BasicDB.call(query);
        
        try
        {
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
    public List retrieve( Object model )
    {
        Teacher teacher = (Teacher) model;
        
        return null;
    }
    
    @Override
    public void add( Object model )
    {
        Teacher teacher = (Teacher) model;
        
        String query = "{call addTeacherToSchool(" + 
                teacher.getFirstName() + 
                teacher.getLastName() + 
                teacher.getGender() +
                teacher.getDateOfJoin() +
                teacher.getPhone() +
                teacher.getAge() +
                teacher.getEmail() +
                ") }";
        
        BasicDB.callVoid(query);
    }
    
    @Override
    public void update( Object model )
    {
        Teacher teacher = (Teacher) model;
        
        String query = "{call updateTeacherInSchool(" + 
                teacher.getId()+ 
                teacher.getFirstName() + 
                teacher.getLastName() + 
                teacher.getGender() +
                teacher.getDateOfJoin() +
                teacher.getPhone() +
                teacher.getAge() +
                teacher.getEmail() +
                ") }";
        
        BasicDB.callVoid(query);
    }
    
    @Override
    public void delete( Object model )
    {
        Teacher teacher = (Teacher) model;
        
        String query = "{call deleteTeacherInTheSchool(" + teacher.getId() + ") }";
        
        BasicDB.callVoid(query);
    }
}
