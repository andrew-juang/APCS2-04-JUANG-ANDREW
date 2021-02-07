public class Tester {
    public static void main(String[] args){
        System.out.println(Recursion.reverse("oranges"));
        System.out.println(Recursion.reverse("o"));
        System.out.println(Recursion.reverse(""));
        System.out.println(Recursion.reverse("12345"));
        System.out.println(Recursion.countNoDoubleLetterWords(0,"")); //1
        System.out.println(Recursion.countNoDoubleLetterWords(1,"")); //26
        System.out.println(Recursion.countNoDoubleLetterWords(2,"")); //650
        System.out.println(Recursion.countNoDoubleLetterWords(3,"")); //16250
        System.out.println(Recursion.countNoDoubleLetterWords(4,"")); //406250
    }
}
