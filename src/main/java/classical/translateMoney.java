package src.main.java.classical;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class translateMoney {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        int count = Integer.parseInt(sc.nextLine());
        Pattern pattern = Pattern.compile("(\\d+(?:\\.\\d+)?)([A-Za-z]+)");
        for (int i = 0; i < count; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                double amount = Double.parseDouble(matcher.group(1));
                String currency = matcher.group(2);
                total += exchange(currency, amount);
            }
        }
        System.out.println(Math.round(Math.floor(total)));
    }
    private static double exchange(String currency, double amount) {
        Map<String, Double> map = new HashMap<String, Double>() {
            {
                put("CNY", 100.0);
                put("fen", 1.0);
                put("JPY", 10000.0 / 1825);
                put("sen", 100.0 / 1825);
                put("HKD", 10000.0 / 123);
                put("cents", 100.0 / 123);
                put("EUR", 10000.0 / 14);
                put("eurocents", 100.0 / 14);
                put("GBP", 10000.0 / 12);
                put("pence", 100.0 / 12);
            }
        };
        return map.getOrDefault(currency, 0.0) * amount;
    }
}
