import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class FooBarBazTest {

    @Test
    public void testisDivisableByThree() throws Exception {
        FooBarBaz fooBarBaz = new FooBarBaz();
            assertTrue(fooBarBaz.isDivisableByThree(3));
    }
    
    @Test
    public void testisDivisableByFive() throws Exception {
        FooBarBaz fooBarBaz = new FooBarBaz();
            assertTrue(fooBarBaz.isDivisableByFive(5));
    }

}
