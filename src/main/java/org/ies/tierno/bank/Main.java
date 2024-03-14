package org.ies.tierno.bank;

import org.ies.tierno.bank.model.Account;
import org.ies.tierno.bank.model.Bank;
import org.ies.tierno.bank.reader.JsonBankReader;
import org.ies.tierno.bank.reader.Reader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader<Bank> bankReader = new JsonBankReader();
        var bank = bankReader.read();
        List<Account> accounts=bank.findAccountsByZip(28000);
        for (Account account:accounts){
            account.info();
        }

    }
}