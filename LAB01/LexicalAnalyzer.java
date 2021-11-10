package LAB01;

import java.io.File;
import java.util.*;
import java.util.Set;

public class LexicalAnalyzer {

    String kW = "if|else|int|float|double|boolean|char|String|else if|for|while|break|continue";
    String id = "[A-Za-z][A-Za-z0-9_]*";
    String mo = "\\+|-|\\*|/|=";
    String lO = ">|<|=>|==|=<";
    String nV = "[-+]?[0-9]*\\.?[0-9]+";
    String ot = ".*[{|}|;|,|/(|/)].*";

    Set<String> keyWords = new HashSet<String>();
    Set<String> identifiers = new HashSet<String>();
    Set<String> mathOperators = new HashSet<String>();
    Set<String> logicalOperators = new HashSet<String>();
    Set<String> numericalValues = new HashSet<String>();
    Set<String> others = new HashSet<String>();

    public void Analyze() {
        try {

            File InputFile = new File("D:/Study/FALL 21/CSE420/LAB/CSE420_Lab_Compiler_Design/LAB01/input.txt");
            Scanner sc = new Scanner(InputFile);

            String sign = "";
            while (sc.hasNextLine()) {

                String x = "";
                x = x + sc.nextLine();
                String arr0[] = x.split("");

                for (int i = 0; i < arr0.length; i++) {
                    String rh = "" + arr0[i];

                    if (rh.matches(mo)) {
                        mathOperators.add(rh);
                        sign += " ";
                    }

                    else if (rh.equals("\t"))
                        sign += " ";

                    else if (rh.matches(lO)) {
                        logicalOperators.add(rh);
                        sign += " ";
                    }

                    else if (rh.matches(ot)) {
                        others.add(rh);
                        sign += " ";
                    }

                    else
                        sign += rh;

                }
            }

            String arr1[] = sign.split(" ");

            for (int i = 0; i < arr1.length; i++) {
                String rh1 = arr1[i];

                if (rh1.matches(kW))
                    keyWords.add(rh1);

                else if (rh1.matches(nV))
                    numericalValues.add(rh1);

                else if (rh1.matches(id))
                    identifiers.add(rh1);

            }

            System.out.print("Keywords: ");
            System.out.println(keyWords.toString());

            System.out.print("Identifiers: ");
            System.out.println(identifiers.toString());

            System.out.print("Math Operators: ");
            System.out.println(mathOperators.toString());

            System.out.print("Logical Operators: ");
            System.out.println(logicalOperators.toString());

            System.out.print("Numerical Values: ");
            System.out.println(numericalValues.toString());

            System.out.print("Others: ");
            System.out.println(others.toString());
        } catch (Exception e) {
            System.out.println("Exception happended.");
        }
    }
}
