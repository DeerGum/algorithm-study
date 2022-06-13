import java.io.*;


public class Test2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

//		String result = formatting(num);
//		System.out.println(result);

		System.out.println("1235".compareTo("124"));
	}

	public static String formatting(int num) {
		
		StringBuilder format = new StringBuilder(String.valueOf(num));
		int mod = format.length() % 3;

		for (int i = 1; i < format.length(); i++) {
			if (i % 3 == mod) {
				format.insert(i, ',');
				
			}
		}

		return format.toString();
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