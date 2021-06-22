package main.controller;

import java.util.List;
import main.dao.ClassDao;

/**
 *
 * @author zaid
 */
public class ClassController extends AbstractController
{
    public ClassController( ClassDao classDao )
    {
        super( classDao );
    }

    @Override
    public List retrieveAll() 
    {
        return super.getDao().retrieveAll();
    }

    @Override
    public Object retrieveOne(int id) 
    {
        return super.getDao().retrieveOne(id);
    }

    @Override
    public List retrieve(Object model) 
    {
        return super.getDao().retrieve(model);
    }

    @Override
    public void addButtonHandler(Object model) 
    {
        super.getDao().add(model);
    }

    @Override
    public void updateButtonHandler(Object model) 
    {
        super.getDao().update(model);
    }

    @Override
    public void deleteButtonHandler(Object model) 
    {
        super.getDao().delete(model);
    }
    
}
