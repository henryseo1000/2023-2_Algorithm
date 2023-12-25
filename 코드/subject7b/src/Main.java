import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int w[][] = {{0,1,10000,1,10000},
                {1,0,1,10000,10000},
                {10000,1,0,1,1},
                {1,10000,1,0,1},
                {10000,10000,1,1,0}};
        int n = 5;
        int r[][] = graph2(w,n);
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                System.out.print(r[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] process(int[] A, int n){ // 1. 번호 순서대로 실행 시간이 담긴 A라는 배열과 프로세스의 개수 n을 입력받는다.
        //2. 실행시간에 대한 최솟값의 인덱스 min과 순서를 넣을 배열 num, 프로세스가 이미 끝났는지의 여부를 나타내는 배열 done을 선언한다.
        int min;
        int[] num = new int[n];
        int[] done = new int[n];

        //3. done과 num 배열을 모두 0으로 채워 초기화한다.
        Arrays.fill(done, 0);
        Arrays.fill(num, 0);

        for(int i = 0; i < n; i++){ //4. 지역변수 i가 0에서 n-1까지 증가하는 동안
            int j  = 0; // 4-1. 반복문 속에 지역변수 j를 선언해 0으로 초기화한다.

            for(; j < n; j++) { // 4-2. j가 0에서 n-1까지 증가하는 동안
                if (done[j] == 0) { // 4-3. done[j] 가 0이라면 반복문을 탈출한다.
                    break;
                }
            }
            min = j; // 4-4. min 변수 속에 j를 대입한다.

            for(; j < n; j++){ // 4-5. 그 뒤에 j가 0에서 n-1까지 증가하는 동안
                if(done[j] == 0 && A[j] <= A[min]){ // 4-6. done[j]가 0이고 A[j]가 A[min] 이하라면
                    min = j; // 4-7. min에 j를 대입하고 그렇지 않다면 아무것도 하지 않는다.
                }
                num[i] = min + 1;// 4-8. num[i]에 min + 1(실제 프로세스 번호는 1부터이므로)을 대입하여 저장한다.
            }
            done[min] = 1; // 4-9. done[min]에 1을 저장하여 해당 min 번 프로세스가 끝났다고 표시한다.
        }
        return num; // 5. num 배열을 반환한다.
    }

    public static int[][] graph(int [][] w, int n){
        boolean isblue[] = new boolean[n];
        int near[] = new int[n];
        int T[][] = new int[n][n];
        int minval = 1000;
        int newred = 0;
        int count = 0;

        isblue[0] = false;

        for(int i = 1; i < n; i++){
            isblue[i] = true;
            near[i] = 0;
        }
        for(int i = 1; i < n; i++){
            minval = 1000;
            for(int j = 0; j < n; j++){
                if(isblue[j] && w[j][near[j]] < minval){
                    minval = w[j][near[j]];
                    newred = j;
                }
                isblue[newred] = false;
                T[newred][near[newred]] = 1;
            }
            for(int j = 0; j < n; j++){
                if(isblue[j] && w[j][newred] < w[j][near[j]]){
                    near[j] = newred;
                }
            }
        }
        return T;
    }

    public static int[][] graph2(int [][] w, int n){ // 1. 인접 행렬 형식으로 나타내되, 연결된 경우 1을 입력하고, 연결되지 않은 경우는 무한을,
        // 자기 자신과는 0을 대입한 행렬 w와 정점의 개수 n을 입력받는다.

        //2. 청색으로 변했는지 여부를 나타내는 배열 isblue 배열, 연결할 간선을 나타내는 배열 T, 적색으로 변할 정점 번호를 저장할 newred 변수 선언
        boolean isblue[] = new boolean[n];
        int T[][] = new int[n][n];
        int newred = 0;

        // 3. 0번 정점을 선택하여 먼저 적색으로 만든다. (isblue[0] = false)
        isblue[0] = false;

        // 4. 변수 i가 1에서 n - 1까지 증가할때까지 isblue[i] = true로 만든다.
        for(int i = 1; i < n; i++){
            isblue[i] = true;
        }

        // 5. 변수 i가 1에서 n - 1까지 증가할때까지
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){ // 5-1. 변수 j가 1에서 n - 1까지 증가할때까지
                if(isblue[j] && w[i][j] == 1){ // 5-2. isblue[j] 이고 w[i][j] == 1일 경우
                    newred = j; // 5-3. newred에 j를 대입하고 반복문을 탈출한다.
                    break;
                }
            }

            // 5-4. isblue[newred] = false로 만들고 T에 i번과 newred를 연결하는 간선을 표시해 1로 만든다.
            isblue[newred] = false;
            T[i][newred] = 1;
        }

        // 6. 배열 T를 반환한다.
        return T;
    }
}

