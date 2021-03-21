import java.util.*;
import java.io.*;

public class MyDeque<E> {
    private E[] data;
    private int size, start, end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
        start = -1;
        end = 0;
        size = 0;
        data = (E[])new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        start = -1;
        end = 0;
        size = 0;
        data = (E[])new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public String toString(){
        if(isEmpty()) return "[]";
        String result = "[";
        if(start < end){
            for(int i=(start)%data.length;i!=end;i=(i+1)%data.length) {
                result += data[i] + ", ";
            }
            return result + data[end] + "]";
        } else {
            result += data[start];
            for(int i=(start+1)%data.length;i!=end+1;i=(i+1)%data.length) {
                result += ", " + data[i];
            }
            return result + "]";
        }
    }

    public void addFirst(E element){
        if (isFull()){
            resize();
        }
        if(start==-1){
            start = 0;
            end = 0;
        } else if (start==0){
            start = data.length-1;
        } else {
            start--;
        }
        data[start] = element;
        size++;
    }

    public void addLast(E element){
        if(isFull()){
            resize();
        }
        if(start==-1){
            start = 0;
            end = 0;
        } else {
            end++;
        }
        data[end] = element;
        size++;
    }

    public E removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Empty Deque");
        }
        E value = data[start];
        if(start==0&&end==0){
            start = -1;
            end = -1;
        } else if(start==data.length-1) {
            start = 0;
        } else {
            start++;
        }
        return value;
    }

    public E removeLast(){
        
    }
    public E getFirst(){ }
    public E getLast(){ }*/

    private boolean isFull(){
        return ((end==data.length-1&&start==0)||start==end+1);
    }

    private boolean isEmpty(){
        return start==-1;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        E[] newarr = (E[]) new Object[2*data.length];
        int ind = 0;
        for(int i=(start)%data.length;i!=end;i=(i+1)%data.length) {
            newarr[ind] = data[i];
            ind++;
        }
        newarr[ind] = data[end];
        start = 0;
        end = data.length-1;
        data = newarr;
    }
}
