package org.example.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class task4 {
    public void run(String filePath) throws IOException {
        Scanner scanner = new Scanner(new File(filePath));

        ArrayList<Integer> numbers = new ArrayList<>();

        int sum = 0;

        while (scanner.hasNext()) {
            int number = Integer.parseInt(scanner.nextLine());
            numbers.add(number);
            sum += number;
        }
        int mean = sum / numbers.size();

        int lowestDiff = abs(mean - numbers.getFirst());
        int pivot = numbers.getFirst();

        for(int i=0; i<numbers.size();i++){
            if (lowestDiff>abs(mean - numbers.get(i))){
                lowestDiff=abs(mean - numbers.get(i));
                pivot=numbers.get(i);
            }
        }

        int sumSteps = 0;
        for (int i=0; i<numbers.size(); i++){
            int diffWithMean = abs(numbers.get(i)-pivot);
            sumSteps+=diffWithMean;
        }
        System.out.println(sumSteps);
    }

    public static void main(String[] args) throws IOException {

        task4 task4 = new task4();
        task4.run(args[0]);
    }
}