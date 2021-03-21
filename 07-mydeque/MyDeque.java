import java.util.*;
import java.io.*;

public class MyDeque<E> {
    private E[] data;
    private int size, start, end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
        start = 0;
        end = 0;
        size = 0;
        data = (E[])new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        start = 0;
        end = 0;
        size = 0;
        data = (E[])new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public String toString(){
        if(isEmpty()) return "{}";
        String result = "{";
        for(int i=start; i<start+size; i++) {
            result += data[i%data.length];
            if(i!=start+size-1){
                result += ", ";
            }
        }
        result += "}";
        return result;
    }

    public void addFirst(E element){
        if(element == null) throw new NullPointerException();
        if (isFull()||size==0) resize();
        if (start==0){
            start = data.length-1;
        } else {
            start--;
        }
        data[start] = element;
        size++;
    }

    public void addLast(E element){
        if(element == null) throw new NullPointerException();
        if (isFull()||size==0) resize();
        data[end] = element;
        end++;
        size++;
    }

    public E removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        E value = data[start];
        if(start==data.length-1) {
            start = 0;
        } else {
            start++;
        }
        size--;
        return value;
    }

    public E removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        E value;
        if(end!=0){
            value = data[end-1];
            end--;
        } else {
            value = data[data.length-1];
            end = data.length-1;
        }
        size--;
        return value;
    }

    public E getFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return data[start];
    }

    public E getLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(end!=0){
            return data[end-1];
        } else {
            return data[data.length-1];
        }
    }

    private boolean isFull(){
        return size == data.length-1 || data.length==0;
    }

    private boolean isEmpty(){
        return size==0;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        E[] newarr = (E[]) new Object[2*data.length+10];
        int ind = 0;
        for(int i=start; i<start+size; i++){
            newarr[i-start] = data[i%data.length];
        }
        start = 0;
        end = size;
        data = newarr;
    }
}
