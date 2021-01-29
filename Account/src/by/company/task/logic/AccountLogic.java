package by.company.task.logic;

import by.company.task.bin.Account;
import by.company.task.bin.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountLogic {

    public long activeAmount(List<Client> clients) {
        long amount = 0;
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getStatus() == 1) {
                    amount += account.getAmount();
                }
            }
        }
        return amount;
    }


    public long lockAmount(List<Client> clients) {
        long amount = 0;
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getStatus() == 0) {
                    amount += account.getAmount();
                }
            }
        }
        return amount;
    }

    //сумма на счетах с положительным балансом
    public long positiveBalance(List<Client> clients) {
        long amount = 0;
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getAmount() >= 0) {
                    amount += account.getAmount();
                }
            }
        }
        return amount;
    }

    //сумма на счетах с отрицательным балансом
    public long negativeBalance(List<Client> clients) {
        long amount = 0;
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getAmount() < 0) {
                    amount += account.getAmount();
                }
            }
        }
        return amount;
    }

    //блокировка счета
    public void blockAmount(List<Client> clients, long number) {
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getNumber() == number) {
                    account.setStatus(0);
                }
            }
        }

    }

    //блокировка счета
    public void unlockAmount(List<Client> clients, long number) {
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getNumber() == number) {
                    account.setStatus(1);
                }
            }
        }

    }

    public List<Account> sort(List<Client> clients) {
        List<Account> accounts = new ArrayList<Account>();

        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                accounts.add(account);
            }
        }
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (o1.getAmount() - o2.getAmount() == 0) {
                    return 0;
                } else if (o1.getAmount() - o2.getAmount() > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return accounts;
    }
}
