import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.awt.*;
//sddsa
@Execution(ExecutionMode.CONCURRENT)
@Tag("Opencart")
//@RunWith(JUnitPlatform.class)
public class OpenCartTest {
    private AddToCart meth = new AddToCart();

    @Test
    public void test() throws InterruptedException {
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
