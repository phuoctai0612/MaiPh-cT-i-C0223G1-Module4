public class Main {
    boolean solution(String s) {
        if(s.equals("")){
            return false;
        }
        String[] check=s.split("");

        for (int i = 0; i < check.length; i++) {
            if (check[i].equals("(")){
                if(!check[i+1].equals(")")){
                    return false;
                }else{
                    i=i+2;
                    continue;
                }
            }else if(check[i].equals("{")){
                if(!check[i+1].equals("}")){
                    return false;
                }else{
                    i=i+2;
                    continue;
                }
            }else if(check[i].equals("[")){
                if(!check[i+1].equals("]")){
                    return false;
                }else{
                    i=i+2;
                    continue;
                }
            }
            if(i==check.length){
                break;
            }
        }
        return false;
    }
}