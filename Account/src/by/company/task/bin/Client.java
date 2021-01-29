package by.company.task.bin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client implements Serializable {
    private String name;
    private List<Account> accounts;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
        accounts = new ArrayList<Account>();
    }
    public void Add(Account account){
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accounts);
    }

    @Override
    public String toString() {
        return "Клиент{" +
                "фамилия='" + name + '\'' +
                ", счета=" + accounts +
                '}';
    }
}
