import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Test3 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 8;
        n =  (n - (1 << 4) >= 0)? n - (1 << 4) : 0;
        System.out.println(n);



    }


}

/*
1101
0100
1101

0 1 = 0
1 1 = 0


*/