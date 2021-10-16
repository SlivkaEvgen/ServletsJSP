package org.homework.util;

import java.io.Serializable;

public class Validator implements Serializable {

    private static final long serialVersionUID = 10000000117L;

    public static boolean validNumber(String hasNumbers) {
        return hasNumbers.matches("\\d+");
    }

    public static boolean validString(String hasLetters) {
        return hasLetters.matches("\\d+");
    }
}
