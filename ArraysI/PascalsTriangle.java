package ArraysI;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int n=5;
        List<List<Integer>> result = pascal(n);
        for (List<Integer> it : result) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> pascal(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for(int rowNum=1;rowNum<numRows;rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = triangle.get(rowNum-1);
            row.add(1);
            for(int j=1;j<rowNum;j++) {
                row.add(prev.get(j-1)+prev.get(j));
            }
            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }

}
