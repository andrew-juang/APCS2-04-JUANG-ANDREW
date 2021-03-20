import java.util.*;
import java.io.*;

public class MyDeque<E> {
    private E[] data;
    private int size, start, end;

    @SupressWarnings("unchecked")
    public MyDeque(){
        start = -1;
        end = 0;
        size = 0;
        data = (E[])new Object[10];
    }

    public MyDeque(int initialCapacity){
        start = -1;
        end = 0;
        size = initialCapacity;
        data = (E[])new Object[initialCapacity];
    }

    public int size(){
        return start-end+1;
    }

    public String toString(){
        if(isEmpty()) return "[]";
        String result = "[";
        result += data[start];
        for(int i=(start+1)%size;i!=end;i=(i+1)%size) {
            result += ", " + data[i];
        }
        return result + "]";

    }
    public void addFirst(E element){

    }
    public void addLast(E element){ }
    public E removeFirst(){ }
    public E removeLast(){ }
    public E getFirst(){ }
    public E getLast(){ }

    private boolean isFull(){
        return ((end==size-1&&start==0)||start==rear+1);
    }

    private boolean isEmpty(){
        return start==-1;
    }
}
