package ru.idcore;

public class Seller {

    private AutoShop autoShop;

    public Seller(AutoShop autoShop) {
        this.autoShop = autoShop;
    }


    public AutoShop getAutoShop() {
        return autoShop;
    }

    public void setAutoShop(AutoShop autoShop) {
        this.autoShop = autoShop;
    }

    public synchronized void sellAuto() {
        try {
            System.out.printf("Продавец начал обрабатывать запрос от %s на продажу автомашины...\n", Thread.currentThread().getName());
            while (autoShop.getAutos().size() == 0) {
                System.out.printf("Ответ для - %s: Машин в продаже нет. Ожидайте!\n", Thread.currentThread().getName());
                wait();
            }
            Thread.sleep(autoShop.getTimeForSelling());
            autoShop.getAutos().pollFirst();
            System.out.printf("Машина продана. %s получил автомашину...\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void receiveAuto() {
        try {
            System.out.println("Продавец начал приемку автомашины...");
            Thread.sleep(autoShop.getTimeReceive());
            if (autoShop.getAutos().offer(new Auto())) {
                System.out.println("Продавец завершил приемку автомашины...");
                notifyAll();
            } else {
                System.out.println("Продавеци не принял автомашину...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
