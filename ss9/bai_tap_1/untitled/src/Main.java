public class Main {
    boolean solution(String s) {

        String[] check=s.split("");

        for (int i = 0; i < check.length; i++) {
            if (check[i].equals("(")){
                if(!check[i+1].equals(")")){
                    return false;
                }
            }else if(check[i].equals("{")){
                if(!check[i+1].equals("}")){
                    return false;
                }
            }else if(check[i].equals("[")){
                if(!check[i+1].equals("]")){
                    return false;
                }
            }
            i+=2;
        }
        return true;
    }

    public static void main(String[] args) {
        Main main=new Main();
        System.out.println(main.solution("()[]{}"));
    }
}