package model;

import java.util.Date;

public class History {
    private User sender;
    private User receiver;
    private TransactionType type;
    private int point;
    private Date datetime;

    public History(User sender, User receiver, TransactionType type, int point, Date datetime) {
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
        this.point = point;
        this.datetime = datetime;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        if (type == TransactionType.SEND) {
            return sender.getName() + " send " + point + " points to " + receiver.getName() + " at " + datetime;
        } else {
            return receiver.getName() + " receive " + point + " points from " + sender.getName() + " at " + datetime;
        }
    }
}
