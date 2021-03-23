import java.util.*;
import java.io.*;

public class Calculator {
    public static double eval(String s){
        String[] chars = s.split(" ");
        ArrayDeque<Double> deque = new ArrayDeque<Double>();
        for(int i=0;i<chars.length;i++){
            if("+-*/%".contains(chars[i])){
                if(deque.size()<=1)throw new IllegalArgumentException("Too few operands");
                double val2=deque.removeLast(), val1=deque.removeLast();
                if (chars[i].equals("+")) deque.addLast(val1+val2);
                if (chars[i].equals("-")) deque.addLast(val1-val2);
                if (chars[i].equals("/")) deque.addLast(val1/val2);
                if (chars[i].equals("*")) deque.addLast(val1*val2);
                if (chars[i].equals("%")) deque.addLast(val1%val2);
            } else {
                deque.addLast(Double.parseDouble(chars[i]));
            }
        }
        if(deque.size()>1)throw new IllegalArgumentException("Too many operands");
        return deque.getLast();
    }
}
