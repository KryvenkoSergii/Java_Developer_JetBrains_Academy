import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> companiesIncomes = new ArrayList<>();
        List<Integer> companiesTaxes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberCompanies = scanner.nextInt();
        for (int i = 0; i < numberCompanies; i++) {
            int income = scanner.nextInt();
            companiesIncomes.add(i, income);
        }
        for (int i = 0; i < numberCompanies; i++) {
            companiesTaxes.add(i, scanner.nextInt());
        }
        //
        int payMostTaxes = 0;
        for (int i = 1; i < numberCompanies; i++) {
            if (companiesIncomes.get(payMostTaxes) * companiesTaxes.get(payMostTaxes) < companiesIncomes.get(i) * companiesTaxes.get(i)) {
                payMostTaxes = i;
            }
        }
        System.out.println(payMostTaxes + 1);
    }
}