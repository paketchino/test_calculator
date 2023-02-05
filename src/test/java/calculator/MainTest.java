package calculator;

import calculator.exception.MyException;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void checkArithmeticOperationAdditionWithArabicNumber() throws Exception {
        Assert.assertEquals(Main.calc("2 + 2"), "4");
    }

    @Test
    public void checkArithmeticOperationMultiplicationWithArabicNumber() throws Exception {
        Assert.assertEquals(Main.calc("2 * 2"), "4");
    }

    @Test
    public void checkArithmeticOperationDivisionWithArabicNumber() throws Exception {
        Assert.assertEquals(Main.calc("4 / 2"), "2");
    }

    @Test
    public void checkArithmeticOperationSubtractionWithArabicNumber() throws Exception {
        Assert.assertEquals(Main.calc("4 - 2"), "2");
    }

    @Test
    public void checkArithmeticOperationDivisionWithRomanNumber() throws Exception {
        Assert.assertEquals(Main.calc("IV / II"), "II");
    }

    @Test(expected = MyException.class)
    public void checkArithmeticOperationSubtractionWithRomanNegativeNumber() throws Exception {
        Main.calc("VII - X");
    }

    @Test
    public void checkArithmeticOperationAdditionWithRomanNumber() throws Exception {
        Assert.assertEquals(Main.calc("IV + II"), "VI");
        Assert.assertEquals(Main.calc("VI / III"), "II");
    }

    @Test
    public void checkArithmeticOperationMultiplicationWithRomanNumber() throws Exception {
        Assert.assertEquals(Main.calc("IV * II"), "VIII");
    }

    @Test
    public void checkArithmeticOperationSubtractionWithRomanNumber() throws Exception {
        Assert.assertEquals(Main.calc("IV - II"), "II");
    }


    @Test(expected = MyException.class)
    public void checkExceptionWhenWeAdditionRomanWithArabicNumber() throws Exception {
        Main.calc("II - 1");
    }

    @Test(expected = MyException.class)
    public void checkExceptionWhenWeAdditionArabicWithRomanNumber() throws Exception {
        Main.calc("1 - II");
    }

    @Test(expected = MyException.class)
    public void checkTryEnterNumberLarge10() throws Exception {
        Main.calc("11 - 2");
    }

    @Test()
    public void tryToEnterNumberWhichLess1() throws Exception {
        Main.calc("0 + 2");
    }

    @Test(expected = MyException.class)
    public void tryToEnterArithmeticOperation() throws Exception {
        Main.calc("1 ^ 3");
    }

    @Test(expected = MyException.class)
    public void tryToEnterSoloNumber() throws Exception {
        Main.calc("1");
    }


}