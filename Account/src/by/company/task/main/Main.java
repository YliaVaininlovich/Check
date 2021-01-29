package by.company.task.main;

import by.company.task.bin.Account;
import by.company.task.bin.Client;
import by.company.task.logic.AccountLogic;
import by.company.task.view.AccountView;
import by.company.task.view.ClientView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client client;
        Account account;
        ClientView clientView = new ClientView();
        AccountLogic accountLogic = new AccountLogic();
        AccountView accountView = new AccountView();

        List<Client> clients = new ArrayList<Client>();
        List<Account> accounts = new ArrayList<Account>();

        client = new Client("Иванов");
        clients.add(client);
        client = new Client("Петров");
        clients.add(client);
        client = new Client("Сидорова");
        clients.add(client);
        client = new Client("Козлова");
        clients.add(client);

        account = new Account(72543624, 1, 123.50);
        clients.get(0).Add(account);
        account = new Account(67676788, 1, 5676.23);
        clients.get(0).Add(account);
        account = new Account(66565667, 1, -456.54);
        clients.get(1).Add(account);
        account = new Account(6767687, 0, 3456.29);
        clients.get(1).Add(account);
        account = new Account(65767688, 1, 3456.27);
        clients.get(2).Add(account);
        account = new Account(45654767, 1, -100.54);
        clients.get(2).Add(account);
        account = new Account(54657688, 0, 567.78);
        clients.get(3).Add(account);
        account = new Account(23435466, 1, 3466.17);
        clients.get(3).Add(account);

        //полная информция
        clientView.viewAll(clients);

        System.out.println("\nТест::поиск по счету");
        clientView.viewClient(clients, 6767687);

        //сумма на активных счетах
        long amount = accountLogic.activeAmount(clients);
       accountView.generalPositiveAmount(amount);

        //сумма на блокированных счетах
        amount = accountLogic.lockAmount(clients);
        accountView.generalNegativeAmount(amount);

        //сумма на счетах с положительным балансом
        amount = accountLogic.positiveBalance(clients);
        accountView.balancePositive(amount);

        //сумма на счетах с отрицательным балансом
        amount = accountLogic.negativeBalance(clients);
        accountView.balanceNegative(amount);

        System.out.println("\nТест::блокируем счет");
        clientView.viewClient(clients, 67676788);
        accountLogic.blockAmount(clients, 67676788);
        clientView.viewClient(clients, 67676788);


        System.out.println("\nТест::разблокируем счет");
        clientView.viewClient(clients, 6767687);
        accountLogic.unlockAmount(clients, 6767687);
        clientView.viewClient(clients, 6767687);

        //сортировка по счетам
        accounts = accountLogic.sort(clients);
        accountView.viewAll(accounts);
    }
}
