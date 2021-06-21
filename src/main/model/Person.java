package main.model;

import java.sql.Date;

/**
 *
 * @author zaid
 */
public abstract class Person 
{
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfJoin;
    private String phone;
    private byte age;
    
    public Person(){ }
    
    public Person( int id,
                    String firstName,
                    String lastName,
                    String gender,
                    Date dateOfJoin,
                    String phone,
                    byte age )
    {
        this(firstName, lastName, gender, dateOfJoin, phone, age);
        this.id = id;
    }
    
    public Person( String firstName,
                   String lastName,
                   String gender,
                   Date dateOfJoin,
                   String phone,
                   byte age )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfJoin = dateOfJoin;
        this.phone = phone;
        this.age = age;
    }
    
    public Person( Person person )
    {
        this( person.getId(),
              person.getFirstName(),
              person.getLastName(),
              person.getGender(),
              person.getDateOfJoin(),
              person.getPhone(),
              person.getAge() );
    }


    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return this.firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return this.lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGender() { return this.gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Date getDateOfJoin() { return this.dateOfJoin; }
    public void setDateOfJoin(Date dateOfJoin) { this.dateOfJoin = dateOfJoin; }

    public String getPhone() { return this.phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public byte getAge() { return this.age; }
    public void setAge(byte age) { this.age = age; }
}
