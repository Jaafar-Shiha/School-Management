package main.controller;

import java.util.List;
import main.dao.IDAO;

/**
 *
 * @author zaid
 */
public abstract class AbstractController 
{
    private IDAO dao;
    
    public AbstractController( IDAO dao )
    {
        this.dao = dao;
    }
    
    /**
     * Retrieve ALL "Model"s
     * @return 
     */
    public abstract List retrieveAll();
    
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
    public abstract List retrieve( Object model );
    
    /**
     * Add a "Model" to the Database
     * @param model 
     */
    public abstract void addButtonHandler( Object model );
    
    /**
     * Update an existing "Model" in the Database
     * @param model 
     */
    public abstract void updateButtonHandler( Object model );
    
    /**
     * Delete a "Model" from the Database
     * @param model 
     */
    public abstract void deleteButtonHandler( Object model );
    
    /**
     * 
     * @return 
     */
    public IDAO getDao() 
    {
        return this.dao;
    }

    /**
     * 
     * @param dao 
     */
    public void setDao(IDAO dao) 
    {
        this.dao = dao;
    }
}
