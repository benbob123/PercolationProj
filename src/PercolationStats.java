import java.math.*;
import java.util.Random;

public class PercolationStats {
    private int[] trialResults;
    private Random randomizer = new Random();
    public PercolationStats(int n, int trials) {
          trialResults  = new int[trials+1];
          Random rand = new Random();
          for(int i = 0; i <= trials; i++){
              Percolation p = new Percolation(n);
              while(!p.percolates()) {
                  int row = rand.nextInt(n)+1; //added plus one
                  int col = rand.nextInt(n)+1;
                 // if(row>=0 && col>=0) {  // figure this out, patch fix
                      if (!p.isOpen(row, col)){
                          p.open(row, col);
                          //p.print();
                      }
                 // }

              }
              trialResults[i] = p.numberOfOpenSites();
          }


    }

    public double mean(){
        double sum=0;
        double average = 0;
        for(int i=0; i<trialResults.length;i++){
            sum=trialResults[i]+sum;
        }
        average = sum / trialResults.length;
        return average;
    }
     public double stddev(){
        double sdSquared = 0;
        double average = this.mean();
        double numerator = 0;

        for(int i=0; i<trialResults.length;i++) {
            numerator = Math.pow(trialResults[i] - average,2)+numerator;
        }
        sdSquared=numerator/(trialResults.length-1);
        return Math.sqrt(sdSquared);
     }

     public double confidenceLo(){
        return this.mean()-((1.96*this.stddev())/Math.sqrt(trialResults.length));
     }

    public double confidenceHi(){
        return this.mean()+((1.96*this.stddev())/Math.sqrt(trialResults.length));
    }


}
