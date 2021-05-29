package Understanding;


//public class MyFavoriteException extends Throwable {       // in this case it is checked - throw in every signature in method call stack
public class DivisionByZeroException extends RuntimeException {  // unchecked, no calls
    public DivisionByZeroException(String s) {
        super(s);
    }

    public DivisionByZeroException(String s, Throwable e) {
        super(s, e);
    }
}
