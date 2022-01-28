public class Weighted_QU {
    private int[] id;
    private int[] sz;

    public Weighted_QU(int n) {
        int arrayLength = n*n+2;
        id = new int[arrayLength];
        sz = new int[arrayLength];
        for (int i = 0; i<arrayLength; i++) {
            id[i] = i;
            sz[i] = i;
        }
    }
    public int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }
    public boolean connected(int p, int q) {
        return (root(p) == root(q));
    }
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i==j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }else {
            id[i] = j;
            sz[j] += sz[i];
        }
    }
}