package main.dao;

import java.sql.ResultSet;

public interface IDAO 
{
    public void retrieve( Object model );
    public void add( Object model );
    public void update( Object model );
    public void delete( Object model );
}
