import java.io.Reader;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        PercolationStats p = new PercolationStats(10,10);
        System.out.println(p.mean());
    }
}
