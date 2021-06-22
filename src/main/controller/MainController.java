package main.controller;

/**
 *
 * @author zaid
 */
public class MainController 
{
    private StudentController studentController;
    private TeacherController teacherController;
    private CourseGradeController courseGradeController;
    private ClassController classController;
    
    public MainController( StudentController studentController,
                           TeacherController teacherController,
                           CourseGradeController courseGradeController,
                           ClassController classController )
    {
        this.studentController = studentController;
        this.teacherController = teacherController;
        this.courseGradeController = courseGradeController;
        this.classController = classController;
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
    public CourseGradeController getCourseGradeController() 
    {
        return courseGradeController;
    }

    /**
     * 
     * @param courseGradeController 
     */
    public void setCourseGradeController(CourseGradeController courseGradeController) 
    {
        this.courseGradeController = courseGradeController;
    }

    /**
     * @return the classController
     */
    public ClassController getClassController() 
    {
        return classController;
    }

    /**
     * @param classController the classController to set
     */
    public void setClassController(ClassController classController) 
    {
        this.classController = classController;
    }
    
}
