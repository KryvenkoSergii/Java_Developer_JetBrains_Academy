import java.util.Scanner;

class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = scanner.nextInt();;
        int b = scanner.nextInt();;
        int c = scanner.nextInt();;
        int d = scanner.nextInt();;
        for (int x = 0; x < 1000; x++) {
            int ax3 = a*x*x*x;
            int bx2 = b*x*x;
            int cx = c*x;
            if ((ax3+bx2+cx+d)==0){
                System.out.println(x);
            }
        }
    }
}