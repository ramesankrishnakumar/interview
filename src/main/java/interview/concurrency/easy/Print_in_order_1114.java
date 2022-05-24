package interview.concurrency.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class Print_in_order_1114 {
	class Foo {
	    
	    private AtomicInteger counter;
	    
	    public Foo() {
	        this.counter = new AtomicInteger(3);
	    }

	    public void first(Runnable printFirst) throws InterruptedException {
	        
	        // printFirst.run() outputs "first". Do not change or remove this line.
	        while(counter.intValue() != 3) {
	            Thread.sleep(10);
	        }
	        counter.decrementAndGet();
	        printFirst.run();
	    }

	    public void second(Runnable printSecond) throws InterruptedException {
	        
	        // printSecond.run() outputs "second". Do not change or remove this line.
	        while(counter.intValue() != 2) {
	            Thread.sleep(10);
	        }
	        counter.decrementAndGet();
	        printSecond.run();
	    }

	    public void third(Runnable printThird) throws InterruptedException {
	        
	        // printThird.run() outputs "third". Do not change or remove this line.
	        
	        while(counter.intValue() != 1) {
	            Thread.sleep(10);
	        }
	        counter.decrementAndGet();
	        printThird.run();
	    }
	}
}
