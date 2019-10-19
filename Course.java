import java.util.*;
public class Course{
    private String name;
    private int credits;
    private ArrayList<String> profs = new ArrayList<String>();
    void setName(String s){
        this.name = s;
    }
    void setCredits(int d){
        this.credits=d;
    }
    String getName(){
        return this.name;
    }
    int getCredits(){
        return this.credits;
    }
    void addProfs(String s){
        this.profs.add(s);
    }
    int getProfsSize(){
        return this.profs.size();
    }
    String getProfsItem(int d){
        return this.profs.get(d);
    }
}