package ru.job4j.bank;

import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User byPassport = findByPassport(passport);
        if (byPassport != null) {
            List<Account> value = users.get(byPassport);
            if (!(value.contains(account))) {
                value.add(account);
            }
        }
    }

    public User findByPassport(String passport) throws NumberFormatException {
        try {
            return users.keySet()
                    .stream()
                    .filter(e -> e.getPassport().equals(passport))
                    .findFirst().get();
        } catch (NullPointerException e) {
        return null;
    }

}

    public Account findByRequisite(String passport, String requisite) {
            return users.values()
                    .stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList())
                    .stream()
                    //.filter(Objects::nonNull)
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst().get();

    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            double difSrcAccount = srcAccount.getBalance() - amount;
            double difDestAccount = destAccount.getBalance() + amount;
            srcAccount.setBalance(difSrcAccount);
            destAccount.setBalance(difDestAccount);
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}
