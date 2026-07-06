package Day_5_MutithreadingSynchronization;

class MessagePrinter extends Thread{
    private String message;

    public MessagePrinter(String name, String message){
        super(name);
        this.message = message;
    }

    @Override
    public void run(){
        for (int i = 1; i<=3 ;i++){
            System.out.println(Thread.currentThread().getName() + ": " + message + " (" + i +") ");
        }
    }
}

class TaskRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() +" is running");
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) throws InterruptedException{
        MessagePrinter t1 = new MessagePrinter("Thread-A", "Hello from A");
        MessagePrinter t2 = new MessagePrinter("Thread-B", "Hello from B");
        t1.start();
        t2.start();

        Thread r1 = new Thread(new TaskRunnable(), "Worker-1");
        Thread r2 = new Thread(new TaskRunnable(), "Worker-2");
        r1.start();
        r2.start();

        Thread first = new Thread(new TaskRunnable(), "First");
        first.start();
        first.join();

        Thread second = new Thread(new TaskRunnable(), "Second");
        second.start();

    }
}
