package DynamicProgrammingOnStocks;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuyAndSellStock {
    public static void main(String args[]) {

        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maximumProfit(Arr));
    }

    private static int maximumProfit(int[] arr) {
        int minPrice = arr[0], maxProfit = Integer.MIN_VALUE;
        for(int i=1;i< arr.length;i++) {
            int cost = arr[i]-minPrice;
            maxProfit=Math.max(maxProfit,cost);
            minPrice=Math.min(minPrice,arr[i]);
        }
        return maxProfit;
    }
}
