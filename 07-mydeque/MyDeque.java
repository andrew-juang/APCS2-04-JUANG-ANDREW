import java.util.*;
import java.io.*;

public class MyDeque<E> {
    private E[] data;
    private int size, start, end;

    @SupressWarnings("unchecked")
    public MyDeque(){
        start = -1;
        end = 0;
        size = 10;
        data = (E[])new Object[10];
    }

    public MyDeque(int initialCapacity){
        start = -1;
        end = 0;
        size = initialCapacity;
        data = (E[])new Object[initialCapacity];
    }
    public int size(){
        return data.size;
    }
    public String toString(){ }
    public void addFirst(E element){ }
    public void addLast(E element){ }
    public E removeFirst(){ }
    public E removeLast(){ }
    public E getFirst(){ }
    public E getLast(){ }
}
