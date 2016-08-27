import java.util.*;

/**
 * Created by taitr on 8/6/2016.
 */
public class task2 {
        static public int solution(int K, int[] C, int[] D) {
            int count = 0;
            Arrays.sort(C);
            Arrays.sort(D);
            for(int i = 0; i < C.length; i++) {
                if (i != C.length - 1) {
                    if (C[i] == C[i + 1]) {
                        count++;
                        i++;
                        continue;
                    }
                }

                if (K > 0) {
                    int j;
                    int length = D.length;
                    int length1 = length;
                    for (j = 0; j < D.length; j++) {
                        if (C[i] == D[j]) {
                            count++;
                            length--;
                            K--;
                            break;
                        }
                    }


                    int s = 0;
                    if (length != length1) {
                        int temp[] = new int[length];
                        for (int u = 0; u < D.length-1; u++) {
                            if (j == u) {
                                s++;
                                u--;
                                j = 100000;
                                continue;
                            }
                            temp[u] = D[s];
                            s++;
                        }
                        D = temp;
                    }
                }
            }
                for(int i = 0; i < D.length; i++) {
                    if (K >= 2 && i != D.length - 1) {
                        if (D[i] == D[i+1]) {
                            K -= 2;
                            count++;
                            i++;
                        }
                    } else {
                        break;
                    }
                }

            return count;
        }

    public static void main(String [] args) {
        int C[] = new int[] {0};
        int D[] = new int[] {4, 3, 2, 1, 4};
        System.out.println(solution(50, C, D));
    }
}
