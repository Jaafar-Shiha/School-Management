package main.model;

/**
 *
 * @author zaid
 */
public class CourseGrade 
{
    private int id;
    private Student student;
    private Course course;
    private byte midterm;
    private byte exam;
    private byte finalGrade;
    
    public CourseGrade() { }
    
    public CourseGrade( int id,
                        Student student, 
                        Course course, 
                        byte midterm, 
                        byte exam, 
                        byte finalGrade )
    {
        this.id = id;
        this.student = student;
        this.course = course;
        this.midterm = midterm;
        this.exam = exam;
        this.finalGrade = finalGrade;
    }
    
    public CourseGrade( Student student, 
                        Course course, 
                        byte midterm, 
                        byte exam, 
                        byte finalGrade )
    {
        this(0, student, course, midterm, exam, finalGrade);
    }
    
    public CourseGrade( CourseGrade courseGrade )
    {
        this( courseGrade.getStudent(), 
              courseGrade.getCourse(), 
              courseGrade.getMidterm(), 
              courseGrade.getExam(), 
              courseGrade.getFinalGrade() );
    }

    public int getId() { return this.id; }
    public void setId( int id ) { this.id = id; }
    
    public Student getStudent() { return this.student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return this.course; }
    public void setCourse(Course course) { this.course = course; }

    public byte getMidterm() { return this.midterm; }
    public void setMidterm(byte midterm) { this.midterm = midterm; }

    public byte getExam() { return this.exam; }
    public void setExam(byte exam) { this.exam = exam; }

    public byte getFinalGrade() { return this.finalGrade; }
    public void setFinalGrade(byte finalGrade) { this.finalGrade = finalGrade; }
}
