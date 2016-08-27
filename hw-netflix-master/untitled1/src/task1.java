/**
 * Created by taitr on 8/6/2016.
 */
public class task1 {

    int solution(int P, int C) {
        // write your code in C99 (gcc 4.8.2)
        int count = 0;
        while(C > 0) {
            P = P - 2;
            if(P >= 0) {
                count++;
            }else {
                C = 0;
            }
            C--;
        }
        return count;
    }
}
