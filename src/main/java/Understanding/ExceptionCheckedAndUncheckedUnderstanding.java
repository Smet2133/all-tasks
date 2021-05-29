package Understanding;

public class ExceptionCheckedAndUncheckedUnderstanding {

    public void a1()  {
        try {
            a2();
        } catch (Throwable e) {
            System.out.println("Before outer printStackTrace");
            e.printStackTrace(System.out);
            //throw new DivisionByZeroException("Some random exception", e);
        }
    }

    private void a2() {
        System.out.println("Before a3 call");
        try {
            a3();
        } catch (Exception e) {
            //System.out.println("Before exception in a2");
            //e.printStackTrace(System.out);
            throw new DivisionByZeroException("new place", e);
        }
        System.out.println("After a3 call");
    }

    private void a3() {
        int b = 0;
        try {
            int a = 3 / b;
        } catch (ArithmeticException e) {
            //e.printStackTrace(System.out);
            System.out.println("Chillout, bro");
            if (b == 0) {
                throw new DivisionByZeroException("Yes, it is / 0", e);
            }
        }

    }

}
