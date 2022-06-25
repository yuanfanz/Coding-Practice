import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    Semaphore semafoo = new Semaphore(1);
    Semaphore semabar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            semafoo.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            semabar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            semabar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            semafoo.release();
        }
    }
}