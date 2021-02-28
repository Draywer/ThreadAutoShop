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
            try {
                System.out.println("Производитель произвел автомобиль и отправил в автосалон...");
                Thread.sleep(timeForAuto);
                shop.receiveAuto();
                count++;
                Thread.sleep(timeForAuto);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
