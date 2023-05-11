import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Test3 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 6, 2, 8, 1, 7, 4);
        Comparator<Integer> comparator = (o1, o2) -> o2.compareTo(o1);
        list.sort(comparator);

        System.out.println(list);
    }
}

/*
1101
0100
1101

0 1 = 0
1 1 = 0


*/