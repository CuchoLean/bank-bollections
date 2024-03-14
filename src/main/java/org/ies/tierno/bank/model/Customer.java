package org.ies.tierno.bank.model;

import java.util.Objects;

public class Customer {
    private String nif;
    private String name;
    private String surname;
    private int zipCode;

    public Customer(String nif, String name, String surname, int zipCode) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.zipCode = zipCode;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return zipCode == customer.zipCode && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(nif, customer.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, nif, zipCode);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nif='" + nif + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public void info(){
        System.out.println(toString());
    }
}


