public class Percolation {
    private boolean[] display;
    private int gridLength;
    private Weighted_QU qu;

    public Percolation(int n) {
        display = new boolean[n * n + 2];
        gridLength = n;
        display[0] = true;
        display[n * n + 1] = true;
        for (int i = 1; i < (n * n); i++) {
            display[i] = false;
        }
        qu = new Weighted_QU(n * n + 2);
    }

    public void open(int row, int col) {
        if (row >= 1 && row <= gridLength && col >= 1 && col <= gridLength) { //makes sure input in range of grid

            int index = (row - 1) * gridLength + col;
            display[index] = true;


            if (index == 1) {// top left corner
                qu.union(index,0);
                if (isOpen(row + 1, col)) {// checks row below
                    qu.union(index, index + gridLength);
                }if(isOpen(row , col+1)) {// checks space to the right
                    qu.union(index, index + 1);
                }}
            else if (index == gridLength) {// top right corner
                qu.union(index,0);
                if (isOpen(row + 1, col)) {// checks row below
                    qu.union(index, index + gridLength);
                }if(isOpen(row , col-1)) {// checks space to the left
                    qu.union(index, index - 1);
                }
            }
            else if (index == gridLength * gridLength) {// bottom right corner
                qu.union(index,gridLength * gridLength+1);
                if (isOpen(row - 1, col)) {// checks row above
                    qu.union(index, index - gridLength);
                }if(isOpen(row , col-1)) {// checks space to the left
                    qu.union(index, index - 1);
                }
            }
            else if (index == gridLength * gridLength - gridLength + 1) {// bottom left corner
                qu.union(index,gridLength * gridLength+1);
                if (isOpen(row - 1, col)) {// checks row above
                    qu.union(index, index - gridLength);
                }if(isOpen(row , col+1)) {// checks space to the right
                    qu.union(index, index + 1);
                }
            }
            //check if index is in top row
           else if (index >= 1 && index <= gridLength) {
                qu.union(index, 0);
                if (isOpen(row + 1, col)) {// checks row below
                    qu.union(index, index + gridLength);
                }if(isOpen(row , col-1)) {// checks space to the left
                    qu.union(index, index - 1);
                }if(isOpen(row , col+1)) {// checks space to the right
                    qu.union(index, index + 1);
                }
           }
           //check if index is in bottom row
            else if (index >= gridLength * gridLength - gridLength + 1 && index <= gridLength * gridLength) {
                qu.union(index, gridLength * gridLength + 1);
                if (isOpen(row - 1, col)) {// checks row above
                    qu.union(index, index - gridLength);
                }
                if(isOpen(row , col-1)) {// checks space to the left
                    qu.union(index, index - 1);
                }if(isOpen(row , col+1)) {// checks space to the right
                    qu.union(index, index + 1);
                }
            }

            //checks if index is in left column
            else if(col==1){
                if (isOpen(row - 1, col)) {// checks row above
                    qu.union(index, index - gridLength);
                }
                if (isOpen(row + 1, col)) {// checks row below
                    qu.union(index,index + gridLength);
                }
                if (isOpen(row, col - 1)) {// checks space to the left
                    qu.union(index, index - 1);
                }
            }

            //checks if index is in right column
            else if(col==gridLength){
                if (isOpen(row - 1, col)) {// checks row above
                    qu.union(index, index - gridLength);
                }
                if (isOpen(row + 1, col)) {// checks row below
                    qu.union(index,index + gridLength);
                } if (isOpen(row, col + 1)) {  //checks space to the right
                    qu.union(index, index + 1);
                }
            }

            //anything in the middle
            else {
                if (isOpen(row - 1, col)) {// checks row above
                    qu.union(index, index - gridLength);
                }
                if (isOpen(row + 1, col)) {// checks row below
                    qu.union(index,index + gridLength);
                }
                if (isOpen(row, col - 1)) {// checks space to the left
                    qu.union(index, index - 1);
                }
                if (isOpen(row, col + 1)) {  //checks space to the right
                    qu.union(index, index + 1);
                }
            }


        }
    }


    public boolean percolates() {
        boolean b = false;
        if(qu.root(0)==qu.root(gridLength *gridLength +1)||qu.root(gridLength *gridLength +1)==qu.root(0))
            b =true;
        return b;
      }

    public boolean isOpen(int row, int col) {
        int index = (row-1)*gridLength + col;
        boolean passthrough = false;
        if (display[index]) {
            passthrough = true;
        }
        return passthrough;
    }
    public int numberOfOpenSites() {
        int numsit = 0;
        for (int i = 0; i <= gridLength * gridLength;i++) {
            if(display[i]) {
                numsit++;
            }
        }
        return numsit;
    }


    public boolean isFull(int row, int col){
        boolean full = false;
        int index = (row - 1) * gridLength + col;
        if (qu.root(index) == 0)
            full=true;
        return full;
        }

    public void print(){
        System.out.println(display.length);
        for(int i=0; i<(gridLength*gridLength + 2); i++){
            if(display[i]) {
                System.out.print("O");
            }
            if(!display[i]) {
                System.out.print("X");
            }
            if (i% gridLength == 0) {
                System.out.println("");
            }
        }
    }
}
