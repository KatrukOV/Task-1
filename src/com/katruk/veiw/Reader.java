package com.katruk.veiw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    /**
     * reader of input stream
     */
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * read an integer from the range
     *
     * @param lo lowest integer
     * @param hi highest integer
     * @return input number
     */
    public int readInt(int lo, int hi) {

        int resultInt = 0;

        try {
            do {
                resultInt = Integer.parseInt(reader.readLine());
            } while (!((resultInt >= lo) && (resultInt <= hi)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultInt;
    }

//    /**
//     * read a double from the range
//     *
//     * @param lo lowest double
//     * @param hi highest double
//     * @return input double
//     */
//    public double readDouble(double lo, double hi) {
//
//        double resultDouble = 0;
//        try {
//            do {
//                resultDouble = Double.parseDouble(reader.readLine());
//
//            } while (!((resultDouble >= lo) && (resultDouble <= hi)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return resultDouble;
//    }

    /**
     * read text
     *
     * @return input String
     */
    public String readString() {

        String result = null;

        try {
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
