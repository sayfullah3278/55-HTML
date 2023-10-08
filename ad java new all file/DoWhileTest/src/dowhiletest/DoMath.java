
package dowhiletest;


public class DoMath {
    
//   public int doMathes(int kafi, int safi){
//                    
//        int result= kafi+safi;
//                    
//             return result;
    
//    public String grat(String name){
//    String massage = name + "good morning";
//      return massage;
    public String prinNumber(int nume){
      int count=0;
      
      for (int i=1; i<=nume; i++ ){
            if (nume%i==0){
            count+=1;
            }
      }
      if (count==2){
          return "prim";
          
    }
      else{
      return "not ptim";
      }
    
}
}
