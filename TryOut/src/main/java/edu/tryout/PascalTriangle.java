package edu.tryout;

import java.util.concurrent.TimeUnit;

/**
 * Created by vdemidov on 30.12.16.
 */
public class PascalTriangle {


    int [] range = {1};
    final static int DEFAULT_INIT_NUMBER = 1;


    public void exec() throws InterruptedException {

        TimeUnit.SECONDS.sleep(2);

        long rangeLength = range.length;

        if(rangeLength < 2) {
            System.out.println("Init Array range length is " + rangeLength);
            range = increaseArrayLengthInit();
            range[1] = DEFAULT_INIT_NUMBER;
            System.out.println("");

        } else {

            System.out.println("");
            System.out.println("Array range length is " + rangeLength);
            range = calculateRange();
            range = increaseArrayLength();

            System.out.println("");
            System.out.println("Add values to start\\end position of array");
            range = addDefaultValuesToRange();
            iterateAndShowArrayData();

        }

        exec();
    }



    //Increase array length to one point
    private int[] increaseArrayLength() {

        int[] newArrayRangeIncreased = new int[range.length + 2];
        System.arraycopy(range, 0, newArrayRangeIncreased, 1, range.length);
        return newArrayRangeIncreased;

    }


    //Increase array length to one point
    private int[] increaseArrayLengthInit() {

        int[] newArrayRangeIncreased = new int[range.length + 1];
        System.arraycopy(range, 0, newArrayRangeIncreased, 0, range.length);
        return newArrayRangeIncreased;

    }


    //Add Default values to array range
    private int[] addDefaultValuesToRange() {

        range[0] = DEFAULT_INIT_NUMBER;
        range[range.length-1] = DEFAULT_INIT_NUMBER;

        return range;
    }



    private int[] calculateRange() {

        //Take length - 1 because while iteration will always increase term to one cursor
        int calcRangeLength = (range.length-1);

        int[] newCalculatedArray = new int[calcRangeLength];

        for(int i = 0; i<calcRangeLength; i++) {
            int value = range[i] + range[i + 1];
            newCalculatedArray[i] = value;
        }

        range = newCalculatedArray;
        return range;

    }




    public static void main(String[] args) throws InterruptedException {

        PascalTriangle pascalTriangle = new PascalTriangle();
        pascalTriangle.exec();

    }



    private void iterateAndShowArrayData() {
        for(int i : range)
            System.out.print(i + " ");
    }





}
