package lotto.util;

import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;

public final class InputVerifier {
    private static final Pattern numberPattern = Pattern.compile("\\d+");

    private InputVerifier() {
    }

    public static void validateIsNumberInRange(String input, int minInclusive, int maxInclusive) {
        validateIsNumber(input);
        int number = Integer.parseInt(input);
        if (number < minInclusive || number > maxInclusive) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public static void validateIsNumber(String input) {
        if (!numberPattern.matcher(input).matches())
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
    }
}
