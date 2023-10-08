
package dowhiletest;

public class Arreay {
    public int  main(int [][] myArray) {
        int total=0;
        for(int row=0; row<myArray.length; row++){
                for(int colm=0; colm<myArray[row].length; colm++){
                     total += myArray[row][colm];
                     
                     
                }
        }
        return total;
    }
}
