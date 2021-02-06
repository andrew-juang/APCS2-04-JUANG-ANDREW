public class Recursion {
    /*
    *@param s any string
    *@return a string that is the reversed version of s, do NOT use built in methods to do so, use recursion.
    */
    public static String reverse(String s){
        if(s.length()<=1){
            return s;
        } else {
            return s.charAt(s.length()-1)+reverse(s.substring(0,s.length()-1));
        }
    }
}
