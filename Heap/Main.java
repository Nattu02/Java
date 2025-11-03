public class Main {

    public static void main(String[] args) {
        Maxheap maxheap = new Maxheap();
        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
		for(int i : arr) maxheap.add(i);
        maxheap.printHeap();
        
        Minheap minheap = new Minheap();
		for(int i : arr) minheap.add(i);
        minheap.printHeap();

    }
}