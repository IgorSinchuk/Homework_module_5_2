
import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    public List<Integer> sort(List<Integer> intergers) {
        if (intergers.size() <= 1) return intergers;

        int middle = intergers.size() / 2;
        List<Integer> left = intergers.subList(0, middle);
        List<Integer> right = intergers.subList(middle, intergers.size());

        List<Integer> leftSorted = sort(left);
        List<Integer> rightSorted = sort(right);

        return merge(leftSorted, rightSorted);
    }

    private List<Integer> merge(List<Integer> leftSorted, List<Integer> rightSorted) {
        List<Integer> result = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftSorted.size() || rightIndex < rightSorted.size()) {
            if (leftIndex == leftSorted.size()) {
                result.addAll(rightSorted.subList(rightIndex, rightSorted.size()));
                rightIndex = rightSorted.size();
            } else if (rightIndex == rightSorted.size()) {
                result.addAll(leftSorted.subList(leftIndex, leftSorted.size()));
                leftIndex = leftSorted.size();
            } else {


                int left = leftSorted.get(leftIndex);
                int right = rightSorted.get(rightIndex);
                if (left < right) {
                    result.add(left);
                    leftIndex++;
                } else {
                    result.add(right);
                    rightIndex++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Sort Sorter = new Sort();
        List<Integer> integers = Arrays.asList(3, 1, 6, 9, 12, 4, 23, 10, 7);
        List<Integer> sortIntegers = Sorter.sort(integers);
        System.out.println(sortIntegers);
    }
}
