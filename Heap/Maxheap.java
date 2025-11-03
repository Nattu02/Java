import java.util.ArrayList;
import java.util.Collections;

public class Maxheap {
    ArrayList<Integer> heap;

    public Maxheap(){
        this.heap = new ArrayList<>();
    }

    public int leftChild(int i) {return (2*i)+1;}
    public int rightChild(int i) {return (2*i)+2;}
    public int getParent(int i) {return (i-1)/2;}

    public void add(int val){
        this.heap.add(val);
        int currIndex = this.heap.size() - 1;
        this.heapifyup(currIndex);
        
    }
    
    public void heapifyup(int index){
        while(index > 0){
            int parentIndex = this.getParent(index);
            if(this.heap.get(index) > this.heap.get(parentIndex)){
                Collections.swap(this.heap, index, parentIndex);
                this.heapifyup(parentIndex);
            }
            else{
                break;
            }
        }
    }

    public int extract(){
        int min = this.heap.get(0);
        Collections.swap(this.heap, 0, this.heap.size()-1);
        this.heap.remove(this.heap.size()-1);   
        heapifydown(0);
        return min;
    }

    public void heapifydown(int i){
        int min = i;
        int l = leftChild(i);
        int r = rightChild(i);

        if(l < this.heap.size() && this.heap.get(l) > this.heap.get(min)){
            min = l;
        }
        if(r < this.heap.size() && this.heap.get(r) > this.heap.get(min)){
            min = r;
        }

        if(min != i){
            Collections.swap(heap, min, i);
            this.heapifydown(min);
        }        
    }

    public void printHeap(){
        System.out.println(this.heap);
    }
}
