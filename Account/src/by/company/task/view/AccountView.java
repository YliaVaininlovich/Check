package by.company.task.view;

import by.company.task.bin.Account;

import java.util.List;

public class AccountView {

    public void generalPositiveAmount(long amount) {
        System.out.println("\nОбщая сумма активных счетов равна " + amount);
    }

    public void generalNegativeAmount(long amount) {
        System.out.println("\nОбщая сумма заблокированных счетов равна " + amount);
    }

    public void balancePositive(long amount) {
            System.out.println("\nОбщая сумма счетов с положительным балансом равна " + amount);
    }
    public void balanceNegative(long amount) {
            System.out.println("\nОбщая сумма  счетов с отрицательным балансом равна " + amount);
    }

    public void viewAll(List<Account> accounts){
        System.out.println("\nСортировка по сумме на счете");
        for (Account account : accounts){
            System.out.println(account);
        }
    }
}
