
import java.util.Scanner;

public class PrimosA3D {

    /**
     * @author Daniel Alvarez (a3dany)
     */
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        int n = e.nextInt();
        int c = 1;
        int p = 2;
        int d = 2;
        while (c <= n) {
            if (p % d == 0) {
                if (p == d) {
                    System.out.print(p + ", ");
                    c++;
                }
                d = 2;
                p++;
            } else {
                d++;
            }
        }
    }
}
