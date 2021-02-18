package CS01b;

import java.util.Comparator;

public interface BinaryOp<T> {

	T op(T x, T y);



}

class ReverseComparator<T> implements Comparator<T> {
    
    Comparator<T> orig;
    
    ReverseComparator(Comparator<T> orig) {
        this.orig = orig;
    }
    
    public int compare(T a, T b) {
        
        return orig.compare(b, a);
        
    }
    
    // add the compare function here
}
