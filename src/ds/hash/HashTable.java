package ds.hash;

public class HashTable {
    private int[] arr;
    private int c1;
    private int c2;
    private int c3;

    public HashTable(int n) {
        arr = new int[n];
    }

    public void Start(String policy, int constant1, int constant2, int constant3) {
        if(policy.equals("linear")){
            c1=0;
            c2=constant1;
            c3=0;
        }
        else if(policy.equals("quadratic")) {
            c1 = constant1;
            c2 = constant2;
            c3 = constant3;
        }
        else{
            System.out.println("?????");
        }
    }

    public void Insert(int value) {
        int key = value % 1001;
        int home;
        int pos = home = key;
        for (int i = 1; arr[pos] != 0; i++) {
            //assert arr[pos] != value : "Duplicates not allowed";
            pos = (home + probe(i)) % 1001;
            if (arr[pos] == value) System.out.println("Duplicates not allowed");
        }
        arr[pos] = value;
        System.out.println("INSERT: "+value);
    }

    public int find(int value) {
        int key = value % 1001;
        int home;
        int pos = home = value % 1001;
        for(int i=1; arr[pos]!=0 && arr[pos]!=key; i++)
            pos = (home + probe(i)) % 1001;
        if (arr[pos]==0) return -1;
        else return arr[pos];
    }

    public int probe(int i) {
        return c1 * i * i + c2 * i + c3;
    }

    public void print(){
        for (int i: arr ) {
            System.out.print(i+" ");
        }
    }


}
