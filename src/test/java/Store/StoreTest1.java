package Store;


import Store.item.Apple;
import Store.item.Constants;
import Store.item.Pasta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest1 {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private Apple apple;
    private Pasta pasta;

    @BeforeEach
    public void setup() {
            apple = new Apple();
            pasta = new Pasta();
    }

    @Test
    public void test1() {
        apple.setQuantity(0);
        assertEquals(Constants.APPLE_MESSAGE, outContent.toString());
    }

    @Test
    public void test2() {
        assertEquals(50, apple.getQuantity());
    }

    @Test
    public void test3() {
        apple.setNormalVoucher(true);
        assertEquals(13, apple.getPrice());
    }

    @Test
    public void test4() {
        apple.setSuperVoucher(true);
        assertEquals(7, apple.getPrice());
    }

    @Test
    public void test5() {
        pasta.setQuantity(0);
        assertEquals(Constants.PASTA_MESSAGE, outContent.toString());
    }
    
    @Test
    public void test6() {
        pasta.setSuperVoucher(true);
        assertEquals(25, pasta.getPrice());
    }

    @Test
    public void test7() {
        pasta.setNormalVoucher(true);
        assertEquals(48, pasta.getPrice());
    }
    

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


}
