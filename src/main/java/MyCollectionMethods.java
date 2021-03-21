import java.util.ArrayList;
import java.util.Collection;

public class MyCollectionMethods {
    public static void main(final String[] args) {

        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(5);
        collection.add(12);

        //Collection<Integer> newCollection = new ArrayList<>();
        //newCollection.add(1);
        //newCollection.add(2);

        System.out.println("\nbefore: " + collection);
        Object result;

        result = collection.toArray();


        System.out.println();
        System.out.println("result: " + result);
        if (result instanceof Object[]) {
            Object[] arrObj = (Object[]) result;
            for (Object o : arrObj) {
                System.out.println(o + " ");
            }
            System.out.println("");
        }
        System.out.println("after: " + collection);
    }
}
