package org.example.task3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class task3 {
    static HashMap<Long, String> idsAndValues = new HashMap<Long, String>();

    private static class Test {
        Long id;
        String title;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Test[] values;

        public Test() {
        }

        public Test[] getValues() {
            return values;
        }

        public void setValues(Test[] values) {
            this.values = values;
        }

        public Test(Long id, String title,  String value, Test[] values) {
            this.id = id;
            this.title = title;
            this.value = value;
            this.values = values;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        String value;
    }

    private static class Value {
        Long id;
        String value;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private static class Values {
        Value[] values;

        public Value[] getValues() {
            return values;
        }

        public void setValues(Value[] values) {
            this.values = values;
        }

        public Values() {
        }

        public Values(Value[] values) {
            this.values = values;
        }
    }

    private static class Tests {
        Test[] tests;

        public Tests(Test[] test) {
            this.tests = test;
        }

        public Test[] getTests() {
            return tests;
        }

        public void setTests(Test[] tests) {
            this.tests = tests;
        }

        public Tests() {
        }
    }

    static void mapValues(Test test) {
        test.setValue(idsAndValues.get(test.id));

        if (test.values !=null){

            for(int i=0; i<test.values.length; i++){
                mapValues(test.values[i]);
            }
        }
    }

    public void run() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Enter tests.json file path");
        String testsFilePath = reader.readLine();

        System.out.println("Enter values.json file path");
        String valuesFilePath = reader.readLine();

        System.out.println("Enter directory path where report.json will be saved");
        String reportDirectoryPath = reader.readLine();

        ObjectMapper objectMapper = new ObjectMapper();

        File testsFile = new File(testsFilePath);
        Tests tests = objectMapper.readValue(testsFile, Tests.class);

        File valuesFile = new File(valuesFilePath);
        Values values = objectMapper.readValue(valuesFile, Values.class);


        for(int i=0; i<values.values.length; i++){
            idsAndValues.put(values.values[i].id, values.values[i].value);
        }

        for(int i=0; i<tests.tests.length; i++){
            mapValues(tests.tests[i]);
        }

        objectMapper.writeValue(new File(reportDirectoryPath + "/report.json"), tests);
    }


}
