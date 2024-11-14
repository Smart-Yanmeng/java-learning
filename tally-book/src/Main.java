public class Main {
    public static void main(String[] args) {

        // from 2024-11-11
        Integer principal = 2350;
        Double ratePerMonth = 0.015;
        Integer days = 3;

        System.out.println("The principal and interest is: " + calculateMoneyByDay(principal, ratePerMonth, days));
    }

    private static Double calculateMoneyByDay(Integer principal, Double ratePerMonth, Integer days) {
        return principal * Math.pow(1 + ratePerMonth / 30, days);
    }
}
