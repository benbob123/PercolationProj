import java.io.Reader;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Percolation p = new Percolation(10);
        p.open(1,10);
        p.open(2,10);
        p.open(3,10);
        p.open(3,10);
        p.open(4,10);
        p.open(5,10);
        p.open(6,10);
        p.open(7,10);
        p.open(8,10);
        p.open(9,10);
        p.open(9,10);
        p.open(9,10);
        p.open(10,10);
        if(p.isFull(7,10)) {
            System.out.println("is Full " + p.numberOfOpenSites());
        }



        System.out.println("percolates:" +p.percolates());
        //if (p.isOpen(4,3)){
         //   System.out.println("it works!");
       // }
        p.print();
    }
}
