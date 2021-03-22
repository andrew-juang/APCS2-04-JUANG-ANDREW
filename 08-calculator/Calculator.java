import java.util.*;
import java.io.*;

public class Calculator {
    /*Evaluate a postfix expression stored in s.
    *Assume valid postfix notation, of ints doubles and operators separated by spaces.
    *Valid operators are + - / * and % (remainder not modulo)
    *All results are doubles even if the operands are both int.
    *@throws IllegalArgumentException when there are too many or too few operands.
    *        Use the string parameter of your exception to indicate what happened.
    */
    public static double eval(String s){
        String[] chars = s.split(" ");
        int digitcount = 0;
        for(int i=0;i<chars.length;i++){
            if(Character.isDigit(chars[i].charAt(0))) digitcount++;
        }
        if(digitcount*2-1!=chars.length) throw new IllegalArgumentException();
        ArrayDeque<Double> deque = new ArrayDeque<Double>();
        for(int i=0;i<chars.length;i++){
            if(Character.isDigit(chars[i].charAt(0))){
                deque.addLast(Double.parseDouble(chars[i]));
            } else {
                double val2=deque.removeLast(), val1=deque.removeLast();
                if (chars[i].equals("+")) deque.addLast(val1+val2);
                if (chars[i].equals("-")) deque.addLast(val1-val2);
                if (chars[i].equals("/")) deque.addLast(val1/val2);
                if (chars[i].equals("*")) deque.addLast(val1*val2);
            }
        }
        return deque.getLast();
    }
}
