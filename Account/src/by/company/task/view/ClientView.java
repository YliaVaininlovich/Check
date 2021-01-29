package by.company.task.view;

import by.company.task.bin.Account;
import by.company.task.bin.Client;

import java.util.List;

//все клиенты
public class ClientView {

    public void viewAll(List<Client> clients) {
        System.out.println("Полная информация обо всех клиентах");
        for (Client client : clients) {
            System.out.println(client);
        }

    }

    //информация о счете
    public void viewClient(List<Client> clients, long number) {
        System.out.println("Информация по номеру счета");
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getNumber() == number) {
                    System.out.print("Фамилия клиента="+client.getName()+" ");
                    System.out.println(account);
                }
            }
        }
    }
}
