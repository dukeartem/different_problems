package iterator;

import com.sun.istack.internal.NotNull;

import java.util.Iterator;

public class Main {

    public static void main(String[] argc) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        SOList<Integer> my = new SOList<>(arr);
        for (Integer i: my) {
            System.out.println(i);
        }

    }

    private static class SOList<Type> implements Iterable<Type> {

        private Type[] arrayList;
        private int currentSize;

        private SOList(Type[] newArray) {
            this.arrayList = newArray;
            this.currentSize = arrayList.length;
        }

        @NotNull
        @Override
        public Iterator<Type> iterator() {
            Iterator<Type> it = new Iterator<Type>() {

                private int currentIndex = 0;

                @Override
                public boolean hasNext() {
                    return currentIndex < currentSize && arrayList[currentIndex] != null;
                }

                @Override
                public Type next() {
                    return arrayList[currentIndex++];
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
            return it;
        }
    }

}
