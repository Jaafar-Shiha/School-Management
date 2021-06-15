package main.controller;

public class MainController 
{
    private StudentController studentController;
    private TeacherController teacherController;
    private CourseController courseController;
    
    public MainController( StudentController studentController,
                           TeacherController teacherController,
                           CourseController courseController )
    {
        this.studentController = studentController;
        this.teacherController = teacherController;
        this.courseController = courseController;
    }
    
    

    /**
     * @return the studentController
     */
    public StudentController getStudentController() 
    {
        return studentController;
    }

    /**
     * @param studentController the studentController to set
     */
    public void setStudentController(StudentController studentController) 
    {
        this.studentController = studentController;
    }

    /**
     * @return the teacherController
     */
    public TeacherController getTeacherController() 
    {
        return teacherController;
    }

    /**
     * @param teacherController the teacherController to set
     */
    public void setTeacherController(TeacherController teacherController) 
    {
        this.teacherController = teacherController;
    }

    /**
     * @return the courseController
     */
    public CourseController getCourseController() 
    {
        return courseController;
    }

    /**
     * @param courseController the courseController to set
     */
    public void setCourseController(CourseController courseController) 
    {
        this.courseController = courseController;
    }
}
