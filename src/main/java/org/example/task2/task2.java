package org.example.task2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

public class task2 {
    private static class dot {
        double x;
        double y;

        public dot(double x, double y){
            this.x=x;
            this.y=y;
        }

        public double getY() {
            return y;
        }

        public double getX() {
            return x;
        }
    }

    public void run() throws FileNotFoundException {

        ArrayList<dot> dots = new ArrayList<>();
        File circle = new File("src/main/java/org/example/task2/circle.txt");
        File dot = new File("src/main/java/org/example/task2/dot.txt");

        Scanner scanner = new Scanner(circle);
        dot circleCenterDot = new dot(scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
        double radius = scanner.nextInt();

        scanner = new Scanner(dot);
        while (scanner.hasNext()){
            dots.add(new dot(scanner.nextInt(), scanner.nextInt()));

            if (scanner.hasNext())
                scanner.nextLine();

        }
        scanner.close();

        for(int i=0; i<dots.size(); i++){
            double xDiff = pow(dots.get(i).getX() - circleCenterDot.getX(), 2);
            double yDiff = pow(dots.get(i).getY() - circleCenterDot.getY(), 2);
            double res = xDiff + yDiff - pow(radius, 2);
            if(res == 0){
                System.out.println(0);
            }
            if(res < 0){
                System.out.println(1);
            }
            if(res > 0){
                System.out.println(2);
            }

        }
    }
}