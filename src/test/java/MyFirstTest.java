import com.sun.org.apache.xpath.internal.objects.XString;
import org.junit.jupiter.api.Test;

public class MyFirstTest {
    private String name = "Carl";

    @Test
    public void firstTest() {
        System.out.println("zdarova");


        int sum = slozenieDvuhChisel(17, 23);
        slozenieDvuhChisel(sum, 13);
        System.out.println("And the sum is:  " + sum);

        System.out.println(slozenieDvuhChisel(9, 13));
        System.out.println(name);
    }


    private int slozenieDvuhChisel(int a, int b) {
        System.out.println(name);
        int c = a + b;
        return a + b;
    }

}
