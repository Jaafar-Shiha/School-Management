package main.model;

public class Level 
{
    private int id;
    private String levelName;
    
    public Level() { }
    
    public Level( int id, String levelName )
    {
        this.id = id;
        this.levelName = levelName;
    }
    
    public Level( Level level )
    {
        this( level.getId(), level.getLevelName() );
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getLevelName() { return this.levelName; }
    public void setLevelName(String levelName) { this.levelName = levelName; }
}
