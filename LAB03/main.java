import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;

public class main {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        File file = new File("D:/Study/FALL 21/CSE420/LAB/CSE420_Lab_Compiler_Design/LAB03/input.txt");
        Scanner sc = new Scanner (file);
        int in = sc.nextInt();
        sc.nextLine();
        String re[] = new String[in];
        for (int i = 0; i<in; i++) {
            re[i] = sc.nextLine().trim();
        }
        int op = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<op; i++) {
            boolean f = false;
            String S = " ";
            String check = sc.nextLine().trim();
            for (int j=0; j<in; j++) {
                if (Pattern.matches(re[j], check)) {
                    f = true;
                    S = S + (j + 1) + " ";
                }
            }
            if (f) {
                System.out.println("YES," + S);
            } else {
                System.out.println("NO, " + 0);
            }

        }

    }
}