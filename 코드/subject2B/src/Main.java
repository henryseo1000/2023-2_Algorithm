public class Main {
    public static void main(String[] args) {
        System.out.println(stairs(2));
    }
    public static int stairs(int N){
        if (N > 0){
            if (N == 1){
                return 1;
            }
            else if (N == 2){
                return 2;
            }
            else{
                return stairs(N - 1) + stairs(N - 2);
            }
        }
        else {
            return -1;
        }
    }
}