import java.util.*;
import java.io.*;

public class Main {
    public static boolean checkPerfect(int n) {
        if (n <= 5) return false;
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i * i != n) {
                    sum += n / i;
                }
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {


        try (Scanner sc = new Scanner(new File(args[0]));
             PrintWriter out = new PrintWriter(new FileWriter(args[1]))) {

            while (sc.hasNextInt()) {
                int checkX = sc.nextInt();
                List<Integer> perfectNumbers = new ArrayList<>();

                for (int i = 1; i <= checkX; i++) {
                    if (checkPerfect(i)) {
                        perfectNumbers.add(i);
                    }
                }


                out.print(perfectNumbers.size() + " ");
                out.println(perfectNumbers.toString());
            }
        } catch (IOException e) {
        }
    }
}