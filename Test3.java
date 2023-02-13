import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Test3 {
    public static void main(String[] args) throws IOException {

        char[] letters = new char[26];
        Arrays.fill(letters, 'a');
        letters[1]++;
        letters[5]+= 5;
        System.out.println(String.valueOf(letters));


    }


}

/*
1101
0100
1101

0 1 = 0
1 1 = 0


*/