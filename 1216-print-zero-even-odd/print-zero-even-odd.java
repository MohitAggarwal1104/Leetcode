import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    private Semaphore zeroSem = new Semaphore(1); // zero starts
    private Semaphore evenSem = new Semaphore(0);
    private Semaphore oddSem = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSem.acquire();        // wait for zero turn
            printNumber.accept(0);   // print 0

            if (i % 2 == 0)
                evenSem.release();   // allow even
            else
                oddSem.release();    // allow odd
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();       // wait for even turn
            printNumber.accept(i);   // print even
            zeroSem.release();       // allow zero
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();        // wait for odd turn
            printNumber.accept(i);   // print odd
            zeroSem.release();       // allow zero
        }
    }
}
