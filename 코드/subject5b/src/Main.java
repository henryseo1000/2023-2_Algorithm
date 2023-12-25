public class Main {
    public static void main(String[] args) {
        int[][] M = {
                {0,0,0,0,1},
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        System.out.println(ways1(M, 6,5));
    }
    public static int ways1(int M[][], int m, int n){ // 1. 매개변수로 공사중인 위치를 나타낸 배열 M과, 동서로 뻗은 길의 개수 m, 남북으로 뻗은 길의 개수 n
        // 배열의 인덱스는 0 ~ m-1, 0 ~ n-1 까지 존재하므로
        if (M[m-1][n-1] == 1){ // 2-1. M 배열의 해당 인덱스가 1인 경우 공사장이 있다는 뜻이므로 0을 반환
            return 0;
        }
        else if(m - 1 == 0 && n - 1 == 0){ // 2-2. M 배열의 해당 인덱스가 0인 경우 1 반환
            return 1;
        }
        else if(m-1 == 0){ // 2-3. M 배열의 첫 번째 인덱스가 0인 경우 ways1(M, m, n-1) 반환
            return ways1(M, m, n-1);
        }
        else if(n-1 == 0){ // 2-4. M 배열의 두 번째 인덱스가 0인 경우 ways1(M, m-1, n) 반환
            return ways1(M, m-1, n);
        }
        else { // 2-5. 그 외의 경우는 ways1(M, m-1, n) + ways1(M, m, n-1) 반환
            return ways1(M, m-1, n) + ways1(M, m, n-1);
        }
    }
    public static int ways2(int M[][], int m, int n){ // 1. 매개변수로 공사중인 위치를 나타낸 배열 M과, 동서로 뻗은 길의 개수 m, 남북으로 뻗은 길의 개수 n
        int[][] A = new int[m][n]; // 2. M과 같은 크기의 2차원 배열 A를 생성
        for(int i = 0; i < m; i++){ // 3. 지역변수 i가 0 ~ m-1까지 증가하는 동안
            for(int j = 0; j < n; j++){ // 4. 그 반복문 속에서 지역변수 j가 0 ~ n-1까지 증가하는 동안
                if(M[i][j] == 1){ // 4-1. M[i][j]가 1인 경우 A[i][j] = 0
                    A[i][j] = 0;
                }
                else if(i == 0 && j == 0){ // 4-2. i가 0이고 j가 0인 경우 A[i][j] = 1
                    A[i][j] = 1;
                }
                else if(i == 0){ // 4-3. i가 0인 경우 A[i][j] = A[0][j - 1]
                    A[i][j] = A[0][j - 1];
                }
                else if(j == 0){ // 4-4. j가 0인 경우 A[i][j] = A[i - 1][0]
                    A[i][j] = A[i - 1][0];
                }
                else { // 4-5. 그 외에는 A[i][j] = A[i - 1][j] + A[i][j - 1]
                    A[i][j] = A[i - 1][j] + A[i][j - 1];
                }
            }
        }
        return A[m-1][n-1]; // 5. 최종적으로 A배열의 맨 오른쪽 아래 모서리의 값인 A[m-1][n-1]를 반환
    }
}