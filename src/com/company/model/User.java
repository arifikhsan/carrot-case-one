package com.company.model;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private Integer point;

    public User(int id, String name, Integer point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                '}';
    }

    public void sendPoint(ArrayList<History> histories, User receiver, Integer point) {
        if (this.getPoint() - point > 0) {
            this.setPoint(this.getPoint() - point);
            histories.add(new History(this, receiver, TransactionType.SEND, point, new Date()));

            receiver.setPoint(receiver.getPoint() + point);
            System.out.println(this.getName() + " successfully send " + point + " points to " + receiver.getName() + " (" + new Date() + ")");
            System.out.println("------------------------------");
            histories.add(new History(this, receiver, TransactionType.RECEIVE, point, new Date()));
        } else {
            System.out.println(this.getName() + " failed send " + point + " points to " + receiver.getName() + " (" + new Date() + ")");
            System.out.println("------------------------------");
        }
    }

    public void askPoint(ArrayList<History> histories, User sender, Integer point) {
        this.setPoint(this.getPoint() + point);
        histories.add(new History(sender, this, TransactionType.SEND, point, new Date()));

        sender.setPoint(sender.getPoint() - point);
        histories.add(new History(sender, this, TransactionType.RECEIVE, point, new Date()));
    }
}
