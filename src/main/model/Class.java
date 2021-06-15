package main.model;

public class Class 
{
    private int id;
    private String className;
    private Level level;
    
    public Class() { }
    
    public Class( int id,
                  String className,
                  Level level )
    {
        this.id = id;
        this.className = className;
        this.level = level;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getClassName() { return this.className; }
    public void setClassName(String className) { this.className = className; }

    public Level getLevel() { return this.level; }
    public void setLevel(Level level) { this.level = level; }
}
