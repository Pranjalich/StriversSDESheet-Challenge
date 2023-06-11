package ArraysI;

public class StockBuyAndCell {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);

    }

    private static int maxProfit(int[] arr) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int ele: arr) {
            minPrice = Math.min(minPrice,ele);
            maxPro = Math.max(maxPro,ele-minPrice);
        }
        return maxPro;
    }

}
