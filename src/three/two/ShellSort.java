package three.two;

public class ShellSort {

    private ShellSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){

        int h = data.length / 2;
        while (h >= 1){
            for (int start = 0; start < h; start++) {
                for (int i = start + h; i < data.length; i+=h) {
                    E t = data[i];
                    int j;
                    for ( j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j-=h) {
                        data[j] = data[j - h];
                        data[j] = t;
                    }
                }
            }

            h /= 2;
        }
    }
}
