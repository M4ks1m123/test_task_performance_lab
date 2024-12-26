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
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i=0; i<=100; i++){

            if (i % (m-1) == 0){
                if (!res.isEmpty() && circle[i%n] == res.get(0)){
                    break;
                }
                res.add(circle[i%n]);
            }

        }
        for(int i=0; i<res.size(); i++)
            System.out.print(res.get(i));
    }
}
