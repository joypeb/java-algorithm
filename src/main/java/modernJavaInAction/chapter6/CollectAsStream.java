package modernJavaInAction.chapter6;

import java.util.*;
import java.util.stream.Collectors;

public class CollectAsStream {
    /*
    * 스트림으로 데이터 수집
    *
    * filter, map 등의 중간연산은 스트림의 요소를 소비하지 않는다.
    * 하지만 최종연산은 스트림의 연산을 소비하여 최종 결과를 도출한다.
    *
    * 이전 챕터에서 collect를 활용해 스트림을 소비하여 리스트로 만들었다.
    *
    * */

    public static void main(String[] args) {

        //통화별로 트랜잭션을 그룹화한 다음에 해당 통화로 일어난 모든 트랜잭션 합계를 계산
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);

            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }

            transactionsForCurrency.add(transaction);
        }

        //위의 코드를 stream으로 변경하게 되면
        Map<Currency, List<Transaction>> transactionsByCurrenciesStream =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));

        //너무 당황스러울정로도 간결해졌다

        System.out.println(transactionsByCurrencies);
        System.out.println(transactionsByCurrenciesStream);

    }


    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0)
    );
}


