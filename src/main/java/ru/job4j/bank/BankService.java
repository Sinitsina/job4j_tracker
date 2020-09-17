package ru.job4j.bank;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> byPassport = findByPassport(passport);
        if (byPassport.isPresent()) {
            List<Account> value = users.get(byPassport.get());
            if (!(value.contains(account))) {
                value.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) throws NumberFormatException {
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();

    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        return users.entrySet().stream()
                .filter(e -> e.getKey().getPassport().equals(passport))
                .flatMap(u -> u.getValue().stream())
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount =
                (findByRequisite(srcPassport, srcRequisite));
        Optional<Account> destAccount =
                (findByRequisite(destPassport, destRequisite));
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            double difSrcAccount = srcAccount.get().getBalance() - amount;
            double difDestAccount = destAccount.get().getBalance() + amount;
            srcAccount.get().setBalance(difSrcAccount);
            destAccount.get().setBalance(difDestAccount);
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        /*List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());*/

        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> opt = bank.findByPassport("3211");
        if (opt.isPresent()) {
            System.out.println(opt.get().getUsername());
        }
    }
}
