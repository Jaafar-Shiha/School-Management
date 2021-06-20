package main.model;

import java.sql.Date;

public class Teacher extends Person
{
    private String email;
    
    public Teacher(){ };
    
    public Teacher( int id,
                    String firstName,
                    String lastName,
                    String gender,
                    Date dateOfJoin,
                    String phone,
                    byte age,
                    String email )
    {
        super( id, 
               firstName, 
               lastName, 
               gender, 
               dateOfJoin, 
               phone, 
               age );
        
        this.email = email;
    }
    
    public Teacher( String firstName,
                    String lastName,
                    String gender,
                    Date dateOfJoin,
                    String phone,
                    byte age,
                    String email )
    {
        this( 0, firstName, 
                 lastName, 
                 gender, 
                 dateOfJoin, 
                 phone, 
                 age, 
                 email );
    }
    
    public Teacher( Teacher teacher )
    {
        this( teacher.getId(),
              teacher.getFirstName(),
              teacher.getLastName(),
              teacher.getGender(),
              teacher.getDateOfJoin(),
              teacher.getPhone(),
              teacher.getAge(),
              teacher.getEmail() );
    }
    
    public String getEmail() { return this.email; }
    public void setEmail( String email ){ this.email = email; }
}
