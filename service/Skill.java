package service;

public class Skill {
    private long id;
    private String skill;

    public Skill(){

    }

    public Skill(long id, String skill){
        this.id = id;
        this.skill = skill;
    }

    public String getName(){
        return skill;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setName(String skill){
        this.skill = skill;
    }

    @Override
    public String toString(){
        return id + " " + skill;
    }
}
