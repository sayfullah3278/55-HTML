
package mldimantionalarray;

import java.util.Scanner;


public class MlDimantionalArray {

   
    public static void main(String[] args) {
        Scanner s =new Scanner (System.in);
        System.out.println("Ent row num");
        int rows=s.nextInt();
        
        System.out.println("ent col num");
        int colmm=s.nextInt();
       Arrrraeay kms = new Arrrraeay();
        
       int[][] newArray= kms.creatArray(rows,colmm);
       int sumofArr= kms.doSum(newArray);
       
       System.out.println(sumofArr); 
//       int [][] number= {{1,2,3,4},{5,6,7,8}};
//       
//       int [][] marks = new int[5][3];
       
//        System.out.println(newArray.deepToString(marks));

//       
//        System.out.println("number is"+kms.doSum(numbers));
//        System.out.println("marks is "+kms.doSum(mards));
    }
    
}
