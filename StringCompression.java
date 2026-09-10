import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        StringBuilder result = new StringBuilder();

        int count = 1;

        for (int i = 0; i < str.length(); i++) {

            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(str.charAt(i));
                result.append(count);
                count = 1;
            }
        }

        System.out.println("Compressed string: " + result);

        sc.close();
    }
}