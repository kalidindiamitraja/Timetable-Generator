import java.util.*; 
public class Batch extends Timetable{
    static Random rand = new Random(); 
    static ArrayList<Integer> list = new ArrayList<Integer>();
    boolean add(Course x,Professor y){
        int i,j,k,m,n;
        for(i=0;i<6;i++){
            for(j=0;j<8;j++){
                if(y.a[i][j]==null && this.a[i][j]==null){
                    list.add(i*10 + j);
                }
            }
        }
        if(list.size()>=x.getCredits()){
            for(i=0;i<x.getCredits();i++){
                k=rand.nextInt(list.size());
                n=list.get(k)%10;
                m=list.get(k)/10;
                this.a[m][n]=x.getName()+"("+y.getName()+")";
                y.a[m][n]=this.getName()+"("+x.getName()+")";
                list.remove(k);
            }
            list.clear();
            return true;
        }
        list.clear();
        return false;
    }
}