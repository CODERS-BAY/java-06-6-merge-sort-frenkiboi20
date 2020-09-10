public class Main {

    public static void main(String[] args) {

        int[] zahlen = {6, 20, 8, 19, 56, 23, 87, 41, 49, 53};

        zahlen = mergeSort(zahlen);

        for (int i = 0; i < zahlen.length; i++) {
            System.out.print(zahlen[i] + ", ");
        }

    }

    public static int[] mergeSort(int[] unsorted) {

        if (unsorted.length <= 1)
            return unsorted;

        int[] left = new int[unsorted.length / 2];
        int[] right;

        if (unsorted.length % 2 == 0) {
            right = new int[unsorted.length / 2];
        } else {
            right = new int[unsorted.length / 2 + 1];
        }

        for (int i = 0; i < unsorted.length; i++) {
            if (i < unsorted.length / 2) {
                left[i] = unsorted[i];
            } else {
                right[i - unsorted.length / 2] = unsorted[i];
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);

    }

    private static int[] merge(int[] left, int[] right) {

        int[] merge = new int[left.length + right.length];

        int i = 0;
        int j = 0;

        for (int k = 0; i < left.length || j < right.length; k++) {
            if (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    merge[k] = left[i];
                    i++;
                } else {
                    merge[k] = right[j];
                    j++;
                }
            } else if (i < left.length) {

                merge[k] = left[i];
                i++;
            } else if (j < right.length) {
                merge[k] = right[j];
                j++;
            }
        }

        return merge;
    }
}
