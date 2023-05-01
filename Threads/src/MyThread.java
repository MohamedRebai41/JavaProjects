public class MyThread extends java.lang.Thread{
    private int counter;
    private int max;
    private int id;
    public boolean isPaused=false;
    private final JTableEx table;

    private final Object lock = new Object();
    public int  getCounter()
    {
        return this.counter;
    }
    MyThread(int id, int counter,JTableEx table)
    {
        this.id=id;
        this.counter=counter;
        this.max=counter;
        this.table=table;
    }
    public void run()
    {
        this.table.updateTable(this.id,this.counter);
        while(this.counter>0)
        {
            synchronized (lock) { // acquire lock
                if(this.isPaused)
                {
                    try {
                        lock.wait(); // release lock and wait
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.counter -- ;
            this.table.updateTable(this.id,this.counter);
        }
    }

    public void pauseThread() {
        this.isPaused = true;
    }

    public void resumeThread() {
        synchronized (lock) { // acquire lock
            this.isPaused = false;
            lock.notify(); // release lock and notify waiting threads
        }
    }

    public void resetThread() {
        this.counter = max;
        this.isPaused = false;
        this.table.updateTable(this.id,this.counter);
    }
}
