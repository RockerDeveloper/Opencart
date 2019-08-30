package test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import stupid.test.AddToCart;

import java.awt.*;

@Tag("Opencart")
public class OpenCartTest {
    private AddToCart meth = new AddToCart();

    @Test
    public void test() {
        meth.logInSearchingAddDelete();
    }

    @Test
    public void test2() throws InterruptedException {
        meth.noNameTest("100", "100", "100");
    }

    @Test
    public void testTestTesla() throws InterruptedException, AWTException {
        meth.blablabla();

    }

    @Test
    public void testWithoutLogIn() throws InterruptedException {
        meth.withoutLogIn();
    }
}
