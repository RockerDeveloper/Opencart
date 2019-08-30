import org.junit.experimental.ParallelComputer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.JUnitCore;

@Execution(ExecutionMode.CONCURRENT)
public class Parallel {
    @Test
    public void paralelization(){
        Class[] cart = {OpenCartTest.class};
        JUnitCore.runClasses(ParallelComputer.methods(), cart);
    }
}
