package org.banking;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BankingTxnAnalyzer {

    private static List<Transaction> findDebitTransactions(List<Transaction> list) {
        return list.stream()
                .filter(t -> t.getTransactionType().equals("DEBIT"))
                .toList();
    }

    private static List<Transaction> findTransactionsAbove50K(List<Transaction> list) {
        return list.stream()
                .filter(t -> t.getAmount() > 50000)
                .toList();
    }

    private static double calculateTotalCreditAmount(List<Transaction> list) {
        return list.stream()
                .filter(t -> t.getTransactionType().equals("CREDIT"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    private static Map<String, List<Transaction>> groupByTransactionType(List<Transaction> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Transaction::getTransactionType));
    }

    private static Optional<Transaction> findLatestTransaction(List<Transaction> list) {
        return list.stream()
                .max(Comparator.comparing(Transaction::getTransactionDate));
    }

    private static List<Transaction> sortByAmountDescending(List<Transaction> list) {
        return list.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .toList();
    }

    private static double totalAmountUsingParallel(List<Transaction> list) {
        return list.parallelStream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    private static List<Transaction> findFraudTransactions(List<Transaction> list) {
        return list.stream()
                .filter(t -> t.getAmount() > 100000)
                .toList();
    }

    private static Set<Double> findDuplicateAmounts(List<Transaction> list) {
        Set<Double> unique = new HashSet<>();

        return list.stream()
                .map(Transaction::getAmount)
                .filter(amount -> !unique.add(amount))
                .collect(Collectors.toSet());
    }

    private static List<Transaction> top5HighestTransactions(List<Transaction> list) {
        return list.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .limit(5)
                .toList();
    }

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, "ACC1", "DEBIT", 25000, LocalDate.of(2026, 5, 10)),
                new Transaction(2, "ACC2", "CREDIT", 75000, LocalDate.of(2026, 5, 12)),
                new Transaction(3, "ACC3", "DEBIT", 120000, LocalDate.of(2026, 5, 13)),
                new Transaction(4, "ACC01", "CREDIT", 45000, LocalDate.of(2026, 5, 14)),
                new Transaction(5, "ACC4", "DEBIT", 75000, LocalDate.of(2026, 5, 15)),
                new Transaction(6, "ACC5", "CREDIT", 90000, LocalDate.of(2026, 5, 16)),
                new Transaction(7, "ACC6", "DEBIT", 30000, LocalDate.of(2026, 5, 17)),
                new Transaction(8, "ACC7", "CREDIT", 120000, LocalDate.of(2026, 5, 18)),
                new Transaction(9, "ACC8", "DEBIT", 55000, LocalDate.of(2026, 5, 19)),
                new Transaction(10, "ACC9", "CREDIT", 75000, LocalDate.of(2026, 5, 20))
        );

        findDebitTransactions(transactions).forEach(System.out::println);
        System.out.println();

        findTransactionsAbove50K(transactions).forEach(System.out::println);
        System.out.println();

        System.out.println(calculateTotalCreditAmount(transactions));
        System.out.println();

        groupByTransactionType(transactions)
                .forEach((type, txnList) -> {
                    System.out.println(type + " : ");
                    txnList.forEach(System.out::println);
                });
        System.out.println();

        findLatestTransaction(transactions).ifPresent(System.out::println);
        System.out.println();

        sortByAmountDescending(transactions).forEach(System.out::println);
        System.out.println();

        System.out.println(totalAmountUsingParallel(transactions));
        System.out.println();

        findFraudTransactions(transactions).forEach(System.out::println);
        System.out.println();

        System.out.println(findDuplicateAmounts(transactions));
        System.out.println();

        top5HighestTransactions(transactions).forEach(System.out::println);
        System.out.println();
    }
}
