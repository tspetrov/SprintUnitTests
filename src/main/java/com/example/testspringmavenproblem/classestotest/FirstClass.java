package com.example.testspringmavenproblem.classestotest;

public class FirstClass {

    private SomeDataService someDataService;

    public int calculateSum (int ... data) {
        int sum = 0;
        for (int datum : data) {
            sum += datum;
        }
        return sum;
    }

    public int calculateSumUsingDataService () {
        int sum = 0;
        int[] data = someDataService.reteriveAllData();
        for (int datum : data) {
            sum += datum;
        }
        return sum;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public static void main(String[] args) {
        System.out.println(new FirstClass().calculateSum(1, 2, 3,45));
        FirstClass myTestClassWithDataService = new FirstClass();
        myTestClassWithDataService.setSomeDataService(() -> new int[] {1,2,3,4,5});
        System.out.println(myTestClassWithDataService.calculateSumUsingDataService());
    }
}
