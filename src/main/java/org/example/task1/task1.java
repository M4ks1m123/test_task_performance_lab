package org.example.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class task1 {
    private int m;
    private int n;

    private int[] circle;
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));


    public void run() throws IOException {
        System.out.println("Enter n:");
        n = Integer.parseInt(reader.readLine());
        System.out.println("Enter m:");
        m = Integer.parseInt(reader.readLine());

        circle = new int[n];

        for (int i=1; i<=n; i++) {
            circle[i-1] = i;
        }
//        int count = 0;
//        int goalNumber = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i=0; i<=100; i++){
//            System.out.println(i%5);
//            int j = i;
//            int stop = j%m;
//            if(stop==0) {
//                System.out.println(j + " " + i);
//            }

            if (i % (m-1) == 0){
//                System.out.println("number:" + circle[i%n] + " index: " + i%n);
                if (!res.isEmpty() && circle[i%n] == res.get(0)){
                    break;
                }
                res.add(circle[i%n]);
//                System.out.println(res.get(0));
            }

//            count++;
//            System.out.print(circle[i%5] + " ");
//            if (i%4 ==0) {
//                System.out.println(circle[i%4]);
//            }
        }
        for(int i=0; i<res.size(); i++)
            System.out.print(res.get(i));
    }
}
