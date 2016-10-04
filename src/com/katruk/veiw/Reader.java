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
