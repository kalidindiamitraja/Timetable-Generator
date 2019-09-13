import java.util.*; 
public class Batch extends Timetable{
    static Random rand = new Random(); 
    static ArrayList<Integer> list = new ArrayList<Integer>();
    void add(Course x,Professor y){
        int i,j,k,m,n;
        for(i=0;i<6;i++){
            for(j=0;j<8;j++){
                if(y.a[i][j]==null && this.a[i][j]==null){
                    list.add(i*10 + j);
                }
            }
        }
        if(list.size()>=x.credits){
            for(i=0;i<x.credits;i++){
                k=rand.nextInt(list.size());
                n=list.get(k)%10;
                m=list.get(k)/10;
                this.a[m][n]=x.name+"("+y.name+")";
                y.a[m][n]=this.name+"("+x.name+")";
                list.remove(k);
            }
        }
        list.clear();
    }
}