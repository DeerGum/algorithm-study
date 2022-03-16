import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Test3 {
    public static void main(String[] args) throws IOException {
//        int[] input = {2, 1, 2, 1, 2};
//
//        long[][] result = solution(input);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(Arrays.toString(result[i]));
//        }
        int[] input1 = {5,7,6,6};
        int[] input2 = {3,9,5,4};

        System.out.println(isOverlap(input1,input2));
    }

    private static boolean isOverlap(int[] o1, int[] o2) {
        int o1LeftX = o1[0] < o1[2]? o1[0] : o1[2];
        int o1UnderY = o1[1] < o1[3]? o1[1] : o1[3];
        int o1RightX = o1[0] > o1[2]? o1[0] : o1[2];
        int o1TopY = o1[1] > o1[3]? o1[1] : o1[3];

        int o2LeftX = o2[0] < o2[2]? o2[0] : o2[2];
        int o2UnderY = o2[1] < o2[3]? o2[1] : o2[3];
        int o2rightX = o2[0] > o2[2]? o2[0] : o2[2];
        int o2TopY = o2[1] > o2[3]? o2[1] : o2[3];

        if(o1LeftX > o2rightX || o1RightX > o2LeftX)
            return false;
        if(o1TopY < o2UnderY || o1UnderY > o2TopY)
            return false;

        return true;
    }

    public static long[][] solution(int[] H) {
        int n = H.length;
        int maxH = 0;
        for (int i = 0; i < n; i++)
            maxH = Math.max(H[i], maxH);

        long[][] answer = new long[maxH][2];
        for (int k = 1; k <= maxH; k++) {
            answer[k - 1][0] = k;
            int hCount = 0;
            for (int i = 0; i < n; i++) {
                boolean isTight = false;
                for (int j = i; j < n; j++) {
                    if (k == H[j])
                        isTight = true;
                    else if (k > H[j])  //현재 위치가 히스토그램을 벗어나면
                        break;

                    if (isTight)
                        hCount++;
                }
            }
            answer[k - 1][1] = hCount;
        }

        return answer;
    }


}

/*
1,000 size = 4 mod3 = 1
0 123

10,000 size = 5 mod3 = 2
01 234

100,000 size = 6 mod3 = 0
012 345

1,000,000 size = 7 mod3 = 1
0 123 456

*/