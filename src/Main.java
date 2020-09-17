public class Main {

    public static void main(String[] args) {

        // Das unsortierte Integer-Array
        int[] nums = {6, 20, 8, 19, 56, 23, 87, 41, 49, 53};

        // Merge-Sort aufrufen
        nums = mergeSort(nums);

        // Das sortierte Array ausgeben
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }

    }

    public static int[] mergeSort(int[] unsorted) {

        // Wenn das unsortierte Array gleich 1 ist...
        if (unsorted.length == 1)
            //...muss es nicht mehr sortiert werden, daher wird es zurückgegeben
            return unsorted;

        // Abhängig von der Gesamtlänge des Arrays, werden 2 Halbarrays erzeugt
        int[] left = new int[unsorted.length / 2];

        // Das rechte Array wird erzeugt und mit null initialisiert
        int[] right = null;

        // Wenn die Länge des unsortierten Arrays teilbar ist..
        if (unsorted.length % 2 == 0) {
            // Teile das linke Array durch 2
            right = new int[unsorted.length / 2];
        } else {
            // Ansonsten teile das rechte Array durch 2
            right = new int[unsorted.length / 2 + 1];
        }

        // Iterieren über das unsortierte Array
        for (int i = 0; i < unsorted.length; i++) {
            if (i < unsorted.length / 2) {
                left[i] = unsorted[i];
            } else {
                right[i - unsorted.length / 2] = unsorted[i];
            }
        }

        // Rufe mergeSort rekursiv auf um das Splitting der Teilarrays bis 1 fortzuführen
        left = mergeSort(left);
        right = mergeSort(right);

        // Die sortierten Teilarrays werden methodisch empfangen und zurückgegeben
        return merge(left, right);

    }

    private static int[] merge(int[] left, int[] right) {

        // Die Größe vom merge-Array wird anhand der Größen von left und right definiert
        int[] merge = new int[left.length + right.length];

        // Variablen die durch das linke und rechte Array iterieren
        int i = 0;
        int j = 0;

        // Es werden mittels einer Hilfsvariable k (iteriert durch das merge-Array),
        // die beiden Teilarrays durchlaufen und geprüft...
        for (int k = 0; i < left.length || j < right.length; k++) {
            // Solange i und j kleiner als ihre Teilarray sind...
            if (i < left.length && j < right.length) {
                // Wenn der Wert an der Stelle i des linken Arrays kleiner oder gleich dem Wert
                // des rechten Arrays an der Stelle j ist...
                if (left[i] <= right[j]) {
                    // Trage den Wert des linken Arrays an der Stelle i in das sortierte Array (merge-Array) ein
                    merge[k] = left[i];
                    // Erhöhe die Stelle im linken Array um 1
                    i++;
                // Wenn der Wert an der Stelle i des linken Arrays NICHT kleiner oder gleich dem Wert
                // des rechten Arrays an der Stelle j ist...
                } else {
                    // Trage den Wert des rechten Arrays an der Stelle j in das sortierte Array ein
                    merge[k] = right[j];
                    // Erhöhe die Stelle im rechten Array um 1
                    j++;
                }
            // Sollten noch Reste in den jeweiligen Teil-Arrays übrigbleiben
            // werden sie nachgeschrieben
            } else if (i < left.length) {
                merge[k] = left[i];
                i++;
            } else if (j < right.length) {
                merge[k] = right[j];
                j++;
            }
        }
        // Das sortierte Array wird zurückgegeben
        return merge;
    }
}
