package main.model;

import java.sql.Date;

public class Student extends Person
{
    private String fatherName;
    private String motherName;
    private int classId;
    private Date dateOfBirth;
    
    public Student(){ }
    
    public Student( int id,
                    String firstName,
                    String lastName,
                    String fatherName,
                    String motherName,
                    String gender,
                    int classId,
                    Date dateOfBirth,
                    Date dateOfJoin,
                    String phone,
                    byte age )
    {
        super( id, 
               firstName, 
               lastName, 
               gender, 
               dateOfJoin, 
               phone, 
               age );
        
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.classId = classId;
        this.dateOfBirth = dateOfBirth;
    }
    
    public Student( String firstName,
                    String lastName,
                    String fatherName,
                    String motherName,
                    String gender,
                    int classId,
                    Date dateOfBirth,
                    Date dateOfJoin,
                    String phone,
                    byte age )
    {
        this( 0, firstName, 
                 lastName, 
                 fatherName, 
                 motherName, 
                 gender, 
                 classId, 
                 dateOfBirth, 
                 dateOfJoin, 
                 phone, 
                 age );
    }
    
    public Student( Student student )
    {
        this( student.getId(),
              student.getFirstName(),
              student.getLastName(),
              student.getFatherName(),
              student.getMotherName(),
              student.getGender(),
              student.getClassId(),
              student.getDateOfBirth(),
              student.getDateOfJoin(),
              student.getPhone(),
              student.getAge() );
    }
    


    public String getFatherName() { return this.fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getMotherName() { return this.motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }

    public int getClassId() { return this.classId; }
    public void setClassId(int classId) { this.classId = classId; }

    public Date getDateOfBirth() { return this.dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}
