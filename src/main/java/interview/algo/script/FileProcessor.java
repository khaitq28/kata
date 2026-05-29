package interview.algo.script;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileProcessor {


    /*
    contract_id;amount;rate;date
    C1;1000;3.5;2026-01-01
    C1;500;3.6;2026-01-02
    C2;700;2.9;2026-01-01
    C2;INVALID;2.9;2026-01-02
    C3;300;4.1;2026-01-03
     */

    public static void main(String[] args) {
        List<Contract> batch = new ArrayList<>(50);
        Path inputPath = Paths.get("/Users/quangkhai/Desktop/DATA/WORKSPACE/kata/src/main/java/interview/algo/script/test.txt");
        Path errorFile = Paths.get("/Users/quangkhai/Desktop/DATA/WORKSPACE/kata/src/main/java/interview/algo/script/error.txt");
        int i = 1;
        try (   BufferedReader reader = Files.newBufferedReader(inputPath);
                BufferedWriter writer = Files.newBufferedWriter(errorFile)) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 4) {
                    System.out.println("Invalid line: " + i++);
                    writer.write("Invalid line: " + i++ + ":" + line);
                    continue;
                }
                try {
                    String contractId = parts[0];
                    BigDecimal amount = new BigDecimal(parts[1]);
                    BigDecimal rate = new BigDecimal(parts[2]);
                    LocalDate date = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    Contract contract = Contract.builder()
                            .id(contractId)
                            .amount(amount)
                            .rate(rate)
                            .date(date)
                            .build();

                    System.out.println(contract);
                    batch.add(contract);
                    if (batch.size() == 50) {
                        saveBatchToDb(batch);
                    }
                } catch (NumberFormatException e) {
                    writer.write("Invalid line: " + i++ + ":     " + line);
                    System.out.println("Invalid number in line: " + i);
                }
                i ++;
            }
            if (CollectionUtils.isNotEmpty(batch)) {
                saveBatchToDb(batch);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Transaction tx = new Transaction("abcd", new BigDecimal("123"), List.of("abc"));
        tx.getClients().add("vfdsfds");

        batch.stream().collect(Collectors.groupingBy(Contract::getId));


        Map<String, List<Contract>> all =  batch.stream()
                                            .filter(e -> e.getAmount().intValue() > 100)
                                            .collect(Collectors.groupingBy(Contract::getId));

        all.computeIfAbsent("k", k -> new ArrayList<>()).add(new Contract());


        all.computeIfAbsent("k", k -> new ArrayList<>()).add(new Contract());

        batch.stream().collect(Collectors.groupingBy(Contract::getId));

    }





    private static void saveBatchToDb(List<Contract> batch) {
        // save
        //flush
        batch.clear();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class Contract {
        String id;
        BigDecimal amount;
        BigDecimal rate;
        LocalDate date;
    }

    static class Transaction {
        private final String id;
        private final BigDecimal amount;
        private final List<String> clients;

        public  Transaction(String id, BigDecimal amount, List<String> clients) {
            this.id = id;
            this.amount = amount;
            this.clients = List.copyOf(clients);
        }

        public List<String> getClients() {
            return clients;
        }
    }
}
