public class Skill {
    private long id;
    private String name;
    private String email;

    public String getName(){
        return name;
    }

    public long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + email;
    }
}
