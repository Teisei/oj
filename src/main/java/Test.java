import java.util.Arrays;

/**
 * Created by Teisei on 2016/4/25.
 */
public class Test {
    public static void main(String[] args) {
        new Test().run();
        Arrays.sort(new int[3]);
    }

    public void run() {
        int[] a = new int[]{9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
        quick_sort(a, 0, a.length - 1);
    }

    public static void quick_sort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = findPosition(a, l, r);
        quick_sort(a, l, p - 1);
        quick_sort(a, p + 1, r);
    }

    public static int findPosition(int[] a, int l, int r) {
        int p = (l + r) / 2;
        p = r;
        int pivot = a[p];
        int i = l, j = r;
        while (i <= j) {
            while (a[i] < pivot && i <= j) i++;
            if (i <= j) {
                a[p] = a[i];
                p = i++;
            }

            while (a[j] >= pivot && i <= j) j--;
            if (i <= j) {
                a[p] = a[j];
                p = j--;
            }
        }
        a[p] = pivot;
        return p;
    }
}
