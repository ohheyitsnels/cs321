import java.util.LinkedList;

public class SecondLevelCache<T> {
    private final int maxSize1;
    private final int maxSize2;
    private LinkedList<T> list = new LinkedList<T>();
    private LinkedList<T> list2 = new LinkedList<T>();
    private int hits1;
    private int hits2;
    private int refs1;
    private int refs2;


    public SecondLevelCache(int maxSize1, int maxSize2){
        this.maxSize1 = maxSize1;
        this.maxSize2 = maxSize2;
        hits1 = hits2 = refs1 = refs2 = 0;
    }

    public T getObject(T object){
        boolean found = false;
        refs1++;
        if (list.contains(object)) {
            list.remove(object);
            list.addFirst(object);
            found = true;
            hits1++;
        }
        else {
            refs2++;
        }
        if (list2.contains(object)) {
            list2.remove(object);
            list2.addFirst(object);
            if(list.size()>=maxSize1) {
                list.removeLast();
            }
            list.addFirst(object);
            found = true;
            hits2++;
        }
        if(list.size()>=maxSize1) {
            list.removeLast();
        }
        list.addFirst(object);
        if(list2.size()>=maxSize2) {
            list2.removeLast();
        }
        list2.addFirst(object);
        if (found) {
            return object;
        }
        return null;
    }

    public void addObject(T object){
        removeObject(object);
        if (list.size() >= maxSize1) {
                list.removeLast();
        }
        if (list2.size() >= maxSize2) {
            list2.removeLast();
        }
        list.addFirst(object);
        list2.addFirst(object);
    }

    public void removeObject(T object){
        if (list.contains(object)) {
            list.remove(object);
        }
        if (list2.contains(object)) {
            list2.remove(object);
        }
    }

    public void clearCache(){
        list = new LinkedList<>();
    }

    public int getHits1(){
        return hits1;
    }

    public int getHits2(){
        return hits2;
    }

    public int getRefs1(){
        return refs1;
    }

    public int getRefs2(){
        return refs2;
    }
}
