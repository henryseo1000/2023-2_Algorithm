public class Main {
    public static void main(String[] args) {
        System.out.println(rabbit1(1));
    }
    public static void sort(int A[], int len){ // 정렬할 배열과 배열의 크기를 입력받는다.
        int i = 0; // 1. 처음 시작 부분을 저장하는 정수 변수 i를 선언한다.
        int j = len - 1; // 2. 배열의 끝 부분 인덱스를 저장하는 정수 변수 j를 선언한다.
        while(i <= j){ // 3. j가 i이상일 경우 :
            if(A[i] <= 0){ // A[i]가 0 이하면 i를 1 증가시킨다.
                i = i + 1;
            }
            else if(A[j] > 0){ // A[j]가 0 이하면 j를 1 감소시킨다.
                j = j - 1;
            }
            else{ // 그 외에는 A[i]와 A[j]의 값을 바꾸고(지역 변수 temp를 선언하고 A[i]를 저장하고, A[i]에 A[j] 값을 넣은 뒤 A[j]에 temp값을 넣는다.)
                // i를 1 증가, j를 1 감소시킨다.
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i = i + 1;
                j = j - 1;
            }
        }
        // 4. j가 i보다 작을 경우는 반복문 종료
    }

    public static int rabbit1(int n){ // n을 입력받는다.
        int A[] = new int[n + 1]; // 1. n + 1 크기의 배열을 선언한다.
        if (0 <= n) { // 2. 만약 n이 0 이상이라면 A[0]에 1을 넣는다.
            A[0] = 1;
        }
        if(1 <= n) { // 3. 만약 n이 1 이상이라면 A[1]에 2을 넣는다.
            A[1] = 2;
        }
        for(int i = 2; i <= n; i++){ // 3. 지역변수 i를 선언하고 i가 2에서 n까지 증가할 때 A[i] = A[i - 1] * 2 + A[i - 2] * 3
            A[i] = A[i - 1] * 2 + A[i - 2] * 3;
        }
        return A[n]; // 4. 반복문이 모두 끝나면 A[n]을 반환한다.
    }

    public static int rabbit2(int n){ // n을 입력받는다.
        if(n == 0 || n == 1){ // 1. n이 0일 때는 1을, n이 1일 때는 2를 반환한다.
            return n + 1;
        }
        else { // 2. 그 외에는 rabbit2(n - 1) * 2 + rabbit2(n - 2) * 3를 반환한다.
            return rabbit2(n - 1) * 2 + rabbit2(n - 2) * 3;
        }
    }
}