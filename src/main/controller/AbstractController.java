package main.controller;

import main.dao.IDAO;

public abstract class AbstractController 
{
    private IDAO dao;
    
    public AbstractController( IDAO dao )
    {
        this.dao = dao;
    }
    
    
//    public void addEventHandlers()
//    {
//        addButtonHandler();
//        updateButtonHandler();
//        deleteButtonHandler();
//    }
    
    public abstract void addButtonHandler( Object model );
    public abstract void updateButtonHandler( Object model );
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
