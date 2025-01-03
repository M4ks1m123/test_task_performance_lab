package org.example.task2;


import java.io.*;
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

    public void run(String circleFilePath, String dotsFilePath) throws IOException {

        ArrayList<dot> dots = new ArrayList<>();
        File circle = new File(circleFilePath);
        File dot = new File(dotsFilePath);

        Scanner scanner = new Scanner(circle);
        dot circleCenterDot = new dot(scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
        double radius = scanner.nextInt();

        scanner = new Scanner(dot);

        while (scanner.hasNext()){

            if (dots.size()==99){
                System.out.println("Dot limit achieved("+dots.size()+")");
                break;
            }

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

    public static void main(String[] args) throws IOException {

        task2 task2 = new task2();
        task2.run(args[0], args[1]);
    }
}
