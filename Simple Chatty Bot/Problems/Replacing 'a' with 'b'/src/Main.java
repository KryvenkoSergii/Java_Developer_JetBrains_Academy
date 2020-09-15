import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        char[] symbols = scanner.nextLine().toCharArray();
//        int i=0;
//        for (char symbol: symbols){
//            String s = String.valueOf(symbol);
//            if(s.equals("a")){
//                System.out.print("b");
//            } else {
//                System.out.print(s);
//            }
//        }
        //
        String str = scanner.nextLine();
        System.out.println(str.replaceAll("a", "b"));
    }
}