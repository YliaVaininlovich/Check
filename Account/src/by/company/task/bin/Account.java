package by.company.task.bin;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
    private long number;
    private int status;
    private double amount;

    public Account() {

    }

    public Account(long number, int status, double amount) {
        this.number = number;
        this.status = status;
        this.amount = amount;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return number == account.number &&
                status == account.status &&
                Double.compare(account.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, status, amount);
    }

    @Override
    public String toString() {
        return "счет{" +
                "номер счета=" + number +
                ", статус (1-активный 0-блокирован)=" + status +
                ", сумма счета=" + amount +
                '}';
    }
}
