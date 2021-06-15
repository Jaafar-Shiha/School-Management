package main.dao;

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
    public void retrieve( Object model )
    {
        Teacher teacher = (Teacher) model;
        
        String query = "{call getStudents(?) }";
        
        BasicDB.call(query);
    }
    
    @Override
    public void add( Object model )
    {
        Teacher teacher = (Teacher) model;
        
        String query = "{call saveStudent(?) }";
        
        BasicDB.callVoid(query);
    }
    
    @Override
    public void update( Object model )
    {
        Teacher teacher = (Teacher) model;
        
        String query = "{call updateStudent(?) }";
        
        BasicDB.callVoid(query);
    }
    
    @Override
    public void delete( Object model )
    {
        Teacher teacher = (Teacher) model;
        
        String query = "{call deleteStudent(" + teacher.getId() + ") }";
        
        BasicDB.callVoid(query);
    }
}
