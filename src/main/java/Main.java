import java.util.Iterator;

public class Main {
    public static void main(final String[] args) {
        //Integer[] arr = {1, 2, 4, 6, 18, 5};
        MyCollection<Integer> myCollection = new MyCollection<>();
        myCollection.add(0);
        myCollection.add(2);
        myCollection.add(null);
        myCollection.add(5);
        myCollection.add(2);

        Iterator<Integer> it = myCollection.iterator();

        for (Integer i : myCollection) {
            System.out.println(i);
        }

        Object result;
        result = myCollection.contains(null);

        System.out.println();
        System.out.println("result: " + result);
        System.out.println();
        if (result instanceof Object[]) {
            Object[] arrObj = (Object[]) result;
            for (Object o : arrObj) {
                System.out.println(o + " ");
            }
            System.out.println("");
        }
        for (Integer i : myCollection) {
            System.out.println(i);
        }
    }
}
