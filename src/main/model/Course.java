package main.model;

/**
 *
 * @author zaid
 */
public class Course 
{
    private int id;
    private String courseName;
    private SchoolClass schoolClass;
    
    public Course(){ }
    
    public Course( int id,
                   String courseName,
                   SchoolClass schoolClass )
    {
        this.id = id;
        this.courseName = courseName;
        this.schoolClass = schoolClass;
    }
    
    public Course( Course course )
    {
        this( course.getId(),
              course.getCourseName(), 
              course.getSchoolClass() );
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getCourseName() { return this.courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public SchoolClass getSchoolClass() { return this.schoolClass; }
    public void setSchoolClass(SchoolClass schoolClass) { this.schoolClass = schoolClass; }

}
