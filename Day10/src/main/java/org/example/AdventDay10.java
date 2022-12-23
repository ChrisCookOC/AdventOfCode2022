package org.example;

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AdventDay10 {

    String fileName;
    CPU cpu;

    public AdventDay10() {
        cpu = new CPU();
    }

    public AdventDay10(String fileName) {
        this.fileName = fileName;
        cpu = new CPU();
    }

    public static void main(String[] args) {
        AdventDay10 adventDay10 = new AdventDay10();
        adventDay10.run();
    }

    private void run() {
        fileName = "src/input.txt";

        int sum = sumSignalStrengths();
        System.out.printf("The sum of signals is %d\n", sum);

        System.out.printf("The CRT looks like: \n %s", displayCRT());
    }

    public int sumSignalStrengths() {
        AtomicInteger sum = new AtomicInteger();

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            List<Instruction> instructions = fileParser.getInstructions();

            cpu.runInstructions(instructions);

            cpu.cycles.stream().filter(cycle -> (cycle.cycleNo + 21) % 40 == 0)
                    .forEach(cycle -> sum.addAndGet(cycle.calculateSignalStrength()));


        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return sum.get();
    }

    public String displayCRT() {
        return cpu.crt.display();

    }
}