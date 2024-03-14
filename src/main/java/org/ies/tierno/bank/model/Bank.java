package org.ies.tierno.bank.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Bank {
    private String name;

    private Map<String, Account> accountsByIban;
    private List<Customer> customers;

    public Bank(String name, Map<String, Account> accountsByIban, List<Customer> customers) {
        this.name = name;
        this.accountsByIban = accountsByIban;
        this.customers = customers;
    }

    public Bank() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, Account> getAccountsByIban() {
        return accountsByIban;
    }

    public void setAccountsByIban(Map<String, Account> accountsByIban) {
        this.accountsByIban = accountsByIban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.equals(customers, bank.customers) && Objects.equals(accountsByIban, bank.accountsByIban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customers, accountsByIban);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", clients=" + customers +
                ", accountMap=" + accountsByIban +
                '}';
    }

    public void info() {
        System.out.println(toString());
    }

    public Account ingresar(String iban, double amount) {
        for (Account account : accountsByIban.values()) {
            if (account.getIban().equals(iban)) {
                account.setBalance(account.getBalance() + amount);
            }
        }
        return null;
    }

    public Account retirar(String iban, double amount) {
        for (Account account : accountsByIban.values()) {
            if (account.getIban().equals(iban)) {
                account.setBalance(account.getBalance() - amount);
            }
        }
        return null;
    }

    public List<Account> findAccountsByNif(String nif) {
        List<Account> accounts = new LinkedList<>();
        for (Account account : accountsByIban.values()) {
            if (account.getNif().equals(nif)) {
                accounts.add(account);
            }
        }
        return accounts;
    }

    public void transferir(double amount, String ibanO, String ibanD) {
        Account Origen = retirar(ibanO, amount);
        if (Origen != null) {
            Account Destination = ingresar(ibanD, amount);
            if (Destination == null) {
                System.out.println("No se ecnuentra la cuenta destino");
            } else {
                System.out.println("Transeferencia hecha");
            }
        } else {
            System.out.println("No se encuentra la cuenta origen");
        }

    }

    public List<Account> findAccountsByZip(int zipCode) {
        List<Account> accounts = new LinkedList<>();
        for (Account account : accountsByIban.values()) {
            for (Customer customer : customers) {
                if (account.getNif().equals(customer.getNif())) {
                    if (customer.getZipCode() == zipCode) {
                        accounts.add(account);
                    }
                }
            }
        }
        return accounts;
    }
}


