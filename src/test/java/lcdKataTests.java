import org.junit.Assert;
import org.junit.Test;

public class LcdKataTests {

    @Test
    public void stringShouldBeGottenByPosition(){
        String digits = "1234";
        int at = 2;
        int result = Lcd.getDigitFromStringByPosition(digits, at);
        Assert.assertEquals(result,3);
    }

    @Test
    public void arrayWithSegmentsUsedByDigitShouldBeReturned(){
        int number = 2;
        String[] result = Lcd.getSegmentsUsedByDigit(number);
        String[] expectedResult = new String[]{ " _ "," _|","|_ "};
        Assert.assertArrayEquals(result, expectedResult);
    }

    @Test
    public void arrayWithSegmentsForADigitShouldBeReturned(){
        int number = 2;
        String[][] result = Lcd.getSegmentsForDigit(number);
        String block1 = " _ ";
        String block2 = " _|";
        String block3 = "|_ ";
        String[][] expectedResult = new String[][]{ {block1, block2, block3}};
        Assert.assertArrayEquals(result, expectedResult);
    }

    @Test
    public void stringShouldBeJoinedUsingADelimiter(){
        String[] strings = new String[]{ " _ "," _|","|_ "};
        char delimiter = ' ';
        String result = Lcd.joinStringsWithDelimiter(strings,delimiter);
        String expectedResult = " _   _| |_ ";
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void segmentMatrixShouldBeArrangedHorizontally(){
        String block1 = " _ ";
        String block2 = " _|";
        String block3 = "|_ ";
        String[][] data = new String[][]{ {block2, block3, block1}};
        String[] result = Lcd.arrangeSegmentMatrixHorizontally(data);
        String[] expectedResult = new String[]{" _|", "|_ "," _ "};
        Assert.assertArrayEquals(result, expectedResult);
    }

    @Test
    public void singleDigitShouldBeDisplayedAsLcd(){
        String zero = Lcd.numberToLCD(0);
        String expectedZero = " _ \n| |\n|_|";
        Assert.assertEquals(zero, expectedZero);
        System.out.println(Lcd.numberToLCD(0));
        System.out.println(Lcd.numberToLCD(1));
        System.out.println(Lcd.numberToLCD(2));
        System.out.println(Lcd.numberToLCD(3));
        System.out.println(Lcd.numberToLCD(4));
        System.out.println(Lcd.numberToLCD(5));
        System.out.println(Lcd.numberToLCD(6));
        System.out.println(Lcd.numberToLCD(7));
        System.out.println(Lcd.numberToLCD(8));
        System.out.println(Lcd.numberToLCD(9));
    }

    @Test
    public void manyDigitsShouldBeDisplayedAsLcd(){
        String ten = Lcd.numberToLCD(10);
        String expectedTen = "    _ \n  || |\n  ||_|";
        Assert.assertEquals(ten, expectedTen);
        System.out.println(Lcd.numberToLCD(1234567890));
    }
}
