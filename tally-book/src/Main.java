public class Main {
    public static void main(String[] args) {

        // from 2024-10-16
        Integer principal = 2310;
        Double ratePerMonth = 0.02;
        Integer days = 25;

        System.out.println("The principal and interest is: " + calculateMoneyByDay(principal, ratePerMonth, days));
    }

    private static Double calculateMoneyByDay(Integer principal, Double ratePerMonth, Integer days) {
        return principal * Math.pow(1 + ratePerMonth / 30, days);
    }
}
