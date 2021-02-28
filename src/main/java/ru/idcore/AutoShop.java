package ru.idcore;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class AutoShop {
    private Seller seller;
    private Deque<Auto> autos;
    private int timeReceive;
    private int timeForSelling;

    public AutoShop(int timeReceive, int timeForSelling) {
        this.seller = new Seller(this);
        autos = new ArrayDeque<>();
        this.timeForSelling = timeForSelling;
        this.timeReceive = timeReceive;
    }

    public int getTimeReceive() {
        return timeReceive;
    }

    public void setTimeReceive(int timeReceive) {
        this.timeReceive = timeReceive;
    }

    public int getTimeForSelling() {
        return timeForSelling;
    }

    public void setTimeForSelling(int timeForSelling) {
        this.timeForSelling = timeForSelling;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Deque<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Deque<Auto> autos) {
        this.autos = autos;
    }

    public void receiveAuto() {
        seller.receiveAuto();
    }

    public void sellAuto() {
        seller.sellAuto();
    }
}
