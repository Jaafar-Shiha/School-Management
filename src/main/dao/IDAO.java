package main.dao;

import java.util.List;

/**
 *
 * @author zaid
 */
public interface IDAO 
{
    /**
     * Retrieve ALL "Model"s
     * @return 
     */
    public List retrieveAll();
    
    /**
     * Retrieve a SPECIFIC "Model" based on his ID
     * @param id
     * @return 
     */
    public abstract Object retrieveOne( int id );
    
    /**
     * Retrieve a List of "Model"s based on a condition
     * @param model
     * @return 
     */
    public List retrieve( Object model );
    
    /**
     * Add a "Model" to the Database
     * @param model 
     */
    public void add( Object model );
    
    /**
     * Update an existing "Model" in the Database
     * @param model 
     */
    public void update( Object model );
    
    /**
     * Delete a "Model" from the Database
     * @param model 
     */
    public void delete( Object model );
}
