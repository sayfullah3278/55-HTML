
package mldimantionalarray;
public class Arrrraeay {
public int [][] creatArray( int rows , int colo){
int [][] myArray = new int [rows][colo];

        for (int ro=0; ro<myArray.length; ro++){
           for(int col=0; col<myArray[ro].length; col++){
                myArray[ro][col]= (int)(Math.random()*100);
           }
       }
        return myArray;
}


    public int  doSum(int [][] myArray) {
        int total=0;
        for(int row=0; row<myArray.length; row++){
                for(int colm=0; colm<myArray[row].length; colm++){
                     total += myArray[row][colm];
                     
                     
                }
        }
        return total;
    }
}
