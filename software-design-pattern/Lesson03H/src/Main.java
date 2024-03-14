import order.*;
import store.KFC;
import store.McD;
import store.Shop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, 蒋天宇211308121!\nPlease select an order selection: KFC, McD, Spe");
        if (scan.hasNext()) {
            String selected = scan.next();
            configure(selected).render();
        }
    }

    public static Shop configure(String selectShop) {
        return switch (selectShop) {
            case "KFC" -> new KFC();
            case "McD" -> new McD();
            case "Spe" -> new Shop() {
                @Override
                public FriedChicken createFriedChicken() {
                    return new McNuggets();
                }

                @Override
                public Cola createCola() {
                    return new Coca();
                }

                @Override
                public Hamburg createHamburg() {
                    return new BigMac();
                }
            };

            default -> throw new IllegalArgumentException("Invalid shop: " + selectShop);
        };
    }
}
