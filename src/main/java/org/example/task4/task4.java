package org.example.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class task4 {
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter file path");
        String filePath = reader.readLine();
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
            sumSteps+=abs(diffWithMean);
        }
        System.out.println(sumSteps);
    }
}
