package org.ies.tierno.bank.model;

import java.util.Objects;

    public class Account {
        private String iban;
        private String nif;
        private double balance;

        public Account(String iban, String nif, double balance) {
            this.iban = iban;
            this.nif = nif;
            this.balance = balance;
        }

        public Account() {
        }

        public String getIban() {
            return iban;
        }

        public void setIban(String iban) {
            this.iban = iban;
        }

        public String getNif() {
            return nif;
        }

        public void setNif(String nif) {
            this.nif = nif;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Account)) return false;
            Account account = (Account) o;
            return Double.compare(balance, account.balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(nif, account.nif);
        }

        @Override
        public int hashCode() {
            return Objects.hash(iban, nif, balance);
        }

        @Override
        public String toString() {
            return "Account{" +
                    "iban='" + iban + '\'' +
                    ", nifClient='" + nif + '\'' +
                    ", balance=" + balance +
                    '}';
        }
        public void info(){
            System.out.println(toString());
        }
    }

