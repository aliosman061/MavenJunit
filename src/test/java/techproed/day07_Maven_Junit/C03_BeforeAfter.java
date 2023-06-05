package techproed.day07_Maven_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C03_BeforeAfter {

    @Before
    public void setUp() throws Exception {
        System.out.println("her test methodu öncesi bir kez çalışır.");

    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("her test methodu sonrası bir kez çalışır");
    }
}
