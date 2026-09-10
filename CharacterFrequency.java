import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        StringBuffer str = new StringBuffer(sc.nextLine());

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (str.indexOf(String.valueOf(ch)) == i) {

                int count = 0;

                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == ch) {
                        count++;
                    }
                }

                System.out.println(ch + " = " + count);
            }
        }

        sc.close();
    }
}