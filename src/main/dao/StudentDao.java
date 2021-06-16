package main.dao;

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
    public void retrieve( Object model )
    {
        Student student = (Student) model;
        
        String query = "{call getAllStudents() }";
        
        BasicDB.call(query);
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
