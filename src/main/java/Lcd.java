import java.util.HashMap;
import java.util.Map;

public class Lcd {
    private static final String _NONE = "   ";
    private static final String _LEFT = "  |";
    private static final String _MIDL = " _ ";
    private static final String _MDLT = " _|";
    private static final String _MDRT = "|_ ";
    private static final String _FULL = "|_|";
    private static final String _BOTH = "| |";

    private static final Map<Integer, String[]> SEGMENTS_FOR_DIGITS = new HashMap<Integer, String[]>() {
        {
            put(new Integer(1), new String[] { _NONE, _LEFT, _LEFT });
            put(new Integer(2), new String[] { _MIDL, _MDLT, _MDRT });
            put(new Integer(3), new String[] { _MIDL, _MDLT, _MDLT });
            put(new Integer(4), new String[] { _NONE, _FULL, _LEFT });
            put(new Integer(5), new String[] { _MIDL, _MDRT, _MDLT });
            put(new Integer(6), new String[] { _MIDL, _MDRT, _FULL });
            put(new Integer(7), new String[] { _MIDL, _LEFT, _LEFT });
            put(new Integer(8), new String[] { _MIDL, _FULL, _FULL });
            put(new Integer(9), new String[] { _MIDL, _FULL, _MDLT });
            put(new Integer(0), new String[] { _MIDL, _BOTH, _FULL });
        }
    };

    public static String numberToLCD(int number) {
        String[][] segments = getSegmentsForDigit(number);
        String[] result = arrangeSegmentMatrixHorizontally(segments);
        return segmentToTextLines(result);
    }

    public static String segmentToTextLines(String[] result) {
        return joinStringsWithDelimiter(result, '\n');
    }

    public static String[][] getSegmentsForDigit(int number) {
        String digits = Integer.toString(number);
        String[][] result = new String[digits.length()][];
        for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++) {
            result[digitIndex] = getSegmentsUsedByDigit(getDigitFromStringByPosition(digits, digitIndex));
        }
        return result;
    }

    public static int getDigitFromStringByPosition(String digits, int i) {
        return Integer.parseInt(Character.toString(digits.charAt(i)));
    }

    public static String[] getSegmentsUsedByDigit(int number) {
        String result[] = SEGMENTS_FOR_DIGITS.get(new Integer(number));
        if (null == result)
            throw new RuntimeException(String.format("Dígito %d no encontrado",
                    number));
        return result;
    }

    public static String joinStringsWithDelimiter(String[] strings, char delim) {
        StringBuffer sb = new StringBuffer();
        for (String string : strings) {
            if (sb.length() > 0)
                sb.append(delim);
            sb.append(string);
        }
        return sb.toString();
    }

    public static String[] arrangeSegmentMatrixHorizontally(String[][] data) {
        assert data.length > 0;

        String[] result = data[0].clone();
        for (int row = 1; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++)
                result[col] += data[row][col];
        }
        return result;
    }
}


