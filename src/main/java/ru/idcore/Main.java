package ru.idcore;

public class Main {
    public static void main(String[] args) {
        int timeReceive = 3000;
        int timeForSelling = 2000;
        int timeForAuto = 5000;
        int totalAutos = 5;
        int totalBuyers = 5;

        AutoShop autoShop = new AutoShop(timeReceive, timeForSelling);

        Factory factory = new Factory(autoShop, totalAutos, timeForAuto);

        factory.start();

        for (int i = 0; i < totalBuyers; i++) {
            new Thread(autoShop::sellAuto, "Покупатель-" + i).start();
        }
    }
}
