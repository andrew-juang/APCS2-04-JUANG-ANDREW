public class Recursion {
    public static String reverse(String s){
        if(s.length()<=1){
            return s;
        } else {
            return s.charAt(s.length()-1)+reverse(s.substring(0,s.length()-1));
        }
    }

    public static long countNoDoubleLetterWords(int length,String word){
        long ans = 0;
        if(length==0){
            return 1;
        } else {
            for(int i=0;i<26;i++){
                if(word.length()==0||(char)('a'+i)!=word.charAt(word.length()-1)){
                    ans += countNoDoubleLetterWords(length-1,word+(char)('a'+i));
                }
            }
        }
        return ans;
    }
}
