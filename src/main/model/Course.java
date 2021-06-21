package main.model;

/**
 *
 * @author zaid
 */
public class Course 
{
    private int id;
    private String courseName;
    private int classId;
    
    public Course(){ }
    
    public Course( int id,
                   String courseName,
                   int classId )
    {
        this.id = id;
        this.courseName = courseName;
        this.classId = classId;
    }
    
    public Course( Course course )
    {
        this( course.getId(),
              course.getCourseName(), 
              course.getClassId() );
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getCourseName() { return this.courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getClassId() { return this.classId; }
    public void setClassId(int classId) { this.classId = classId; }

}
