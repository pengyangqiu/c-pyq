
import java.util.ArrayList;
import java.util.List;

public class Main {
//    private static UnicodeSet l;
    static List <List<Integer>>l= new ArrayList<>();

    public static  void  main(String []args){
        System.out.println("--------------作业一-------------");
        reverse("-123");
        System.out.println("--------------作业二-------------");
        climb(3);
        System.out.println("--------------作业三-------------");
        List <List<Integer>>m = new ArrayList<>();
        int c[]={1,2,3};
//        l.add(1);

        subset(c);

//        for(int i=0;i<m.size();i++){
//            System.out.println(m.get(i));
//        }

    }
    public  static  void  reverse(String a ){
        String ans ="";
        String op="";
        op+=a.charAt(0);
        for(int i=a.length()-1;i>0;i--){
            op+=a.charAt(i);
        }
        ans+=op;
        System.out.println(ans);
    }
    public static  void  climb(int n){
        int a[] = new int[100];
        a[1]=1;
        a[2]=2;
        for(int i=3;i<=n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        System.out.println(a[n]);
    }
    public static void dfs(int i, int[] nums, List<Integer> temp){
        l.add(temp);
        for(int j=i;j<nums.length;j++){
            temp.add(nums[j]);
            dfs(j+1,nums,temp);
            l.remove(l.size()-1);
        }
    }
    public static void subset(int[] nums){
        List temp = new ArrayList();
        dfs(0,nums,temp);
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
}
