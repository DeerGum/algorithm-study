import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Test3 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = null;
        if (str == null) {
            throw new NullPointerException();
        } else {
            str = "hello";
        }


        try {
            System.out.println(2/0);
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {

        }



    }


}

/*

*/