import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        String answer = "";
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        answer(magazine, ransom, m,n);
    }
    
    public static void answer(String[] mag, String[] rans, int m, int n){
              
       
        Hashtable<String,Integer> magazine = new Hashtable<String,Integer>();
       
        
        String answer = "Yes";
           
        for(String ma: mag){
            if (magazine.containsKey(ma)) {
                magazine.put(ma, magazine.get(ma) + 1);
            }else{
                magazine.put(ma,1);
            }
        }
         
        
         for(String ra: rans){
            if(!magazine.containsKey(ra)){
                answer = "No";
                break;
            }
         //count each word in mag to check if there are dups
           int counter = magazine.get(ra) - 1;
           
           //so if gets down to 0 means there are no more of that word in mag
           //hence would result in no if appeared in ransom again
           if(counter == 0){
               magazine.remove(ra);
           }else{
               magazine.put(ra, counter);//add the new counter to show
               //total number of that word in magazine
           }
       }
        
        System.out.println(answer);
    }
}
