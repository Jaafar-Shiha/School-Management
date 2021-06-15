package main.controller;

import main.dao.IDAO;

public abstract class AbstractController 
{
    private IDAO dao;
    
    public AbstractController( IDAO dao )
    {
        this.dao = dao;
    }
    
    
    public void addEventHandlers()
    {
        addButtonHandler();
        updateButtonHandler();
        deleteButtonHandler();
    }
    
    public abstract void addButtonHandler();
    public abstract void updateButtonHandler();
    public abstract void deleteButtonHandler();
    
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
