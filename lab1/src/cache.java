import java.util.LinkedList;

public class cache<T> {
    private final int maxSize;
    private LinkedList<T> list = new LinkedList<T>();
    private int refs;
    private int hits;

    public cache(int maxSize){
        this.maxSize = maxSize;
        refs = hits = 0;
    }

    public T getObject(T object){
        refs++;
            if(list.contains(object)){
                list.remove(object);
                list.addFirst(object);
                hits++;
                return object;
            }
        list.addFirst(object);
        return null;
    }

    public void addObject(T object){
        removeObject(object);
        if (list.size() >= maxSize) {
            list.removeLast();
        }
        list.addFirst(object);
    }

    public void removeObject(T object){
        if (list.contains(object)){
            list.remove(object);
        }
    }

    public void clearCache(){
        list = new LinkedList<>();
    }

    public int getHits(){
        return hits;
    }

    public int getRefs(){
        return refs;
    }
}
