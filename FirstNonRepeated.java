import java.util.Scanner;

public class FirstNonRepeated {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {

            char ch = sb.charAt(i);
            int count = 0;

            for (int j = 0; j < sb.length(); j++) {
                if (ch == sb.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.println("First non-repeated character: " + ch);
                sc.close();
                return;
            }
        }

        System.out.println("No non-repeated character found.");

        sc.close();
    }
}