/**
 * Created by taitr on 8/6/2016.
 */
import java.lang.*;
import java.util.*;


public class task3 {

    static public int solution(int[] x, int[] y) {
        int total = sum(x.length);
        int x1[] = new int[total];
        int y1[] = new int[total];
        double arr[] = new double[total];
        int count = 0;
        for(int i = 0; i < x.length - 1; i++) {
            for(int j = i+1; j < x.length;j++) {
                arr[count] = length((double)x[i],(double)y[i],(double) x[j],(double)y[j]);
                count++;
            }
        }
        Arrays.sort(arr);

        int c =1;
        for(int i = 0; i < arr.length; i++) {
            if(i != arr.length -1) {
                if(arr[i] == arr[i+1]) {
                    c +=1;
                    continue;
                }
            }
                if(c < 4) {
                    if(arr.length-c < 4) {
                        return 0;
                    }
                    double temp[] = new double[arr.length-c];
                    int t = 0;
                    for(int j = 0; j < arr.length; j++) {
                        if(j == i+1-c) {
                            j = j+c-1;
                            continue;
                        }
                        temp[t] = arr[j];
                        t++;
                    }
                    arr = temp;
                    i = i - c;
                    c = 1;
                } else {
                    c = 1;
                }
            }
        int t = 0;
        for(int i =0; i < arr.length; i++) {
            if(arr[i] <= 1) {
                t++;
            }
        }
        double temp[] = new double[arr.length-t];
        for(int i = 0; i < arr.length; i++) {
           if(i+t >  arr.length-1) {
               break;
           } else {
               temp[i] = arr[i+t];
           }
        }
        arr = temp;

        double arr2[] = arr.clone();
        int totalArr[] = new int[arr.length*4];

        for(int i = 0; i < x.length - 1; i++) {
            for(int j = i+1; j < x.length;j++) {
                for(int u = 0; u < arr.length; u++) {
                    if(length((double)x[i],(double)y[i],(double) x[j],(double)y[j]) == arr[u]) {
                        totalArr[(u*4)] = x[i];
                        totalArr[(u*4)+1] = y[i];
                        totalArr[(u*4)+2] = x[j];
                        totalArr[(u*4)+3] = y[j];
                        arr[u] = 0;
                        break;
                    }
                }
            }
        }




        int diamond = 0;

        for(int i = 0; i < totalArr.length; i++) {
            int xx[] = new int[4];

            int cc = 1;
            for(int h = i/4; h < arr2.length; h++) {
                if(h != arr2.length-1){
                    if(arr2[h] == arr2[h+1]) {
                        cc++;
                    } else {
                        break;
                    }
                }
            }
            for(int k = i/4; k < arr2.length; k++) {
                if(totalArr[(k*4)] == totalArr[((k+1)*4)] && totalArr[(k*4)+1] == totalArr[((k+1)*4)+1]) {
                    xx[0] = totalArr[(k*4)+2];
                    xx[1] = totalArr[(k*4)+3];
                    xx[2] = totalArr[((k+1)*4)+2];
                    xx[3] = totalArr[((k+1)*4)+3];
                    totalArr[(k*4)+2] = 99999;
                    totalArr[(k*4)+3] = 99999;
                    totalArr[((k+1)*4)+2] = 99999;
                    totalArr[((k+1)*4)+3] = 99999;
                    break;
                } else if(totalArr[(k*4)] == totalArr[((k+1)*4)+2] && totalArr[(k*4)+1] == totalArr[((k+1)*4)+3]) {
                    xx[0] = totalArr[(k*4)+2];
                    xx[1] = totalArr[(k*4)+3];
                    xx[2] = totalArr[((k+1)*4)];
                    xx[3] = totalArr[((k+1)*4)+1];
                    totalArr[(k*4)+2] = 99999;
                    totalArr[(k*4)+3] = 99999;
                    totalArr[((k+1)*4)] = 99999;
                    totalArr[((k+1)*4)+1] = 99999;
                    break;
                } else if(totalArr[(k*4)+2] == totalArr[((k+1)*4)+2] && totalArr[(k*4)+3] == totalArr[((k+1)*4)+3]) {
                    xx[0] = totalArr[(k*4)];
                    xx[1] = totalArr[(k*4)+1];
                    xx[2] = totalArr[((k+1)*4)];
                    xx[3] = totalArr[((k+1)*4)+1];
                    totalArr[(k*4)] = 99999;
                    totalArr[(k*4)+1] = 99999;
                    totalArr[((k+1)*4)] = 99999;
                    totalArr[((k+1)*4)+1] = 99999;
                    break;
                }
                k = k+3;
            }

            for(int o = i/4; o < arr2.length; o++) {
                if((xx[0] != 99999 && xx[1]!= 99999) && (xx[2] != 99999 && xx[3]!= 99999)) {
                    if(xx[0] != 99999 && xx[1]!= 99999) {
                        if (xx[0] == totalArr[(o * 4)] && xx[1] == totalArr[(o * 4) + 1]) {
                            xx[0] = 99999;
                            xx[1] = 99999;
                            continue;
                        } else if (xx[0] == totalArr[(o * 4) + 2] && xx[1] == totalArr[(o * 4) + 3]) {
                            xx[0] = 99999;
                            xx[1] = 99999;
                            continue;
                        }
                    }


                    if(xx[2] != 99999 && xx[3]!= 99999) {
                        if (xx[2] == totalArr[(o * 4)] && xx[3] == totalArr[(o * 4) + 1]) {
                            xx[2] = 99999;
                            xx[3] = 99999;
                            continue;
                        } else if (xx[2] == totalArr[(o * 4) + 2] && xx[3] == totalArr[(o * 4) + 3]) {
                            xx[2] = 99999;
                            xx[3] = 99999;
                            continue;
                        }
                    }
                } else {
                    diamond++;
                    break;
                }
                o = o +3;
            }
            i = i + cc*4 - 1;

        }

        return diamond;
    }


    static public double length(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    static public int sum(int size) {
        int total = 0;
        for(int i = size-1; i > 0; i--) {
            total += i;
        }
        return total;
    }



    public static void main(String[] args) {

        int x[] = new int[] {1,1,2,2,2,3,3};
        int y[] = new int[] {3,4,1,3,5,3,4};
        //int x[] = new int[] {1,2,2,3};
        //int y[] = new int[] {4,5,3,4};
        System.out.println(solution(x,y));

    }
}
