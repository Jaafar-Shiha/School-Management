package main.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import main.db.BasicDB;
import main.model.SchoolClass;
import main.model.Level;

/**
 *
 * @author zaid
 */
public class ClassDao implements IDAO
{
    private List<main.model.SchoolClass> classes;
    
    public ClassDao() 
    { 
        this.classes = new LinkedList<>(); 
    }
    
    public ClassDao( List<SchoolClass> classes ) 
    {
        this.classes = classes;
    }
    
    public List<SchoolClass> getClasses() { return this.classes; }
    public void setClasses(List<SchoolClass> classes) { this.classes = classes; }
    
    

    @Override
    public List retrieveAll() 
    {
        String query = "{call getAllClasses() }";
        
        try
        {
            CallableStatement callableStatement = BasicDB.getConnection()
                                                         .prepareCall( query );

            ResultSet resultSet = BasicDB.call( callableStatement );

            this.classes.clear();

            while( resultSet.next() )
            {
                int id = resultSet.getInt(1);
                String className = resultSet.getString(2);
                int levelId = resultSet.getInt(3);
                
                Level level = new Level();
                level.setId( levelId );

                SchoolClass resultClass = new SchoolClass( id, className, level );

                this.classes.add( resultClass );
            }
            
            return this.classes;
        }
        catch( SQLException sqle )
        {
            sqle.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Object retrieveOne(int id) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List retrieve(Object model) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Object model) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object model) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object model) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
