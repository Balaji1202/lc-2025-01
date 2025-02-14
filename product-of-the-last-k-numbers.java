// https://leetcode.com/problems/product-of-the-last-k-numbers/

class ProductOfNumbers {

    private ArrayList<Integer> productHistory = new ArrayList<>();
    private int currentLength = 0;

    public ProductOfNumbers() {
        this.productHistory.add(1);
        this.currentLength = 0;
    }

    public void add(int num) {
        if (num == 0) {
            this.productHistory = new ArrayList<Integer>();
            this.productHistory.add(1);
            this.currentLength = 0;
        } else {
            this.productHistory.add(this.productHistory.get(currentLength) * num);
            this.currentLength++;
        }
    }

    public int getProduct(int k) {
        if (k > this.currentLength) return 0;
        return this.productHistory.get(this.currentLength) / this.productHistory.get(this.currentLength - k);
    }
}
