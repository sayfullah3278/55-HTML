
package qushanofgeneric;


public class QushanOfGeneric {

    
    public static void main(String[] args) {
        Integer[] integers={1,2,3,4,5};
        String[] strings = {"London","Parise","New youk","Austaliea","Rasiya" };
          
        QushanOfGeneric.<Integer>print(integers);
        QushanOfGeneric.<String>print(strings);
    }
    public static <E>void print(E[] list){
    for(int i=0; i<list.length; i++){
        System.out.println(list[i]+" ");
    }
        System.out.println();
    }
    
}
