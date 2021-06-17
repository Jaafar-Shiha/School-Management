package main.dao;

import java.util.List;

public interface IDAO 
{
    public List retrieve( Object model );
    public void add( Object model );
    public void update( Object model );
    public void delete( Object model );
}
