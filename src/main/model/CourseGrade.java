package main.model;

public class CourseGrade 
{
    private Student student;
    private Course course;
    private byte midterm;
    private byte exam;
    private byte finalGrade;
    
    public CourseGrade() { }
    
    public CourseGrade( Student student, 
                        Course course, 
                        byte midterm, 
                        byte exam, 
                        byte finalGrade )
    {
        this.student = student;
        this.course = course;
        this.midterm = midterm;
        this.exam = exam;
        this.finalGrade = finalGrade;
    }
    
    public CourseGrade( CourseGrade courseGrade )
    {
        this( courseGrade.getStudent(), 
              courseGrade.getCourse(), 
              courseGrade.getMidterm(), 
              courseGrade.getExam(), 
              courseGrade.getFinalGrade() );
    }

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