import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a {

    public static int[] solution(int l, int r) {

        List<Integer> list=new ArrayList<>();
        if(l<0 || r<l){
            return new int[0];
        }
        for (int index = l; index < r; l++) {
            if(l<10){
                list.add(l);
            }else{
                break;
            }
        }
            for (int i = l; l <= r; l++) {
                String b= String.valueOf(l);
                String[] a= b.split("");
                if(a[0].equals(a[a.length-1])){
                    list.add(l);
                }
        }
        int[] arr1 =new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr1[i]=list.get(i);
        }
        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(8, 22)));
    }
}