package com.kodilla.good.patterns.challenges.shopProvider;

public class ShopProvider {
    private String shopName;

    public ShopProvider(String shopName) {
        this.shopName = shopName;
        if (this.shopName.equals("GlutenFreeShop")) {
            new GlutenFreeShop();
        }
    }
//    public Shop create() {
//        if (this.shopName.equals("GlutenFreeShop")) {
//            return new GlutenFreeShop();
//        } else {
//            return new HealthyShop();
//        }
//    }
//}

    @Override
    public String toString() {
        return shopName;
    }
}
