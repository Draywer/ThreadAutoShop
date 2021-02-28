package ru.idcore;

public class Factory extends Thread {
    private AutoShop shop;
    private int count;
    private int total;
    private int timeForAuto;

    public Factory(AutoShop shop, int total, int timeForAuto) {
        this.shop = shop;
        this.total = total;
        this.timeForAuto = timeForAuto;
        count = 0;
    }

    @Override
    public void run() {
        while (count < total) {
            shop.receiveAuto();
            count++;
            try {
                Thread.sleep(timeForAuto);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
