import java.util.Iterator;

public class Main {
    public static void main(final String[] args) {
        Integer[] arr = {1, 2, 4, 6, 18, 5};
        MyCollection<Integer> myCollection = new MyCollection<>();
        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(5);
        myCollection.add(12);

        Iterator<Integer> it = myCollection.iterator();

        //remove
        it.next();
        it.remove();
        for (Integer i : myCollection) {
            System.out.println(i);
        }

    }
}
