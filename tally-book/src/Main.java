public class Main {
    public static void main(String[] args) {

        // from 2024-11-16
        Double principal = 2055.88;
        Double ratePerMonth = 0.015;
        Integer days = 6;

        System.out.println("The principal and interest is: " + calculateMoneyByDay(principal, ratePerMonth, days));
    }

    private static Double calculateMoneyByDay(Double principal, Double ratePerMonth, Integer days) {
        return principal * Math.pow(1 + ratePerMonth / 30, days);
    }
}
