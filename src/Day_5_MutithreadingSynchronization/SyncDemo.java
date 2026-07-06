package Day_5_MutithreadingSynchronization;

class BankAccount{
    private double balance;
    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount){
        double temp = balance;
        temp += amount;
        balance = temp;
    }

    public synchronized void withdraw(double amount){
        if(balance>=amount){
        double temp = balance;
        temp -= amount;
        balance = temp;
    }}

    public double getBalance(){
        return balance;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);

        Runnable depositTask = () ->{
            for (int i=0; i<10000;i++){
                account.deposit(1);
            }
        };

        Runnable withdrawTask = () ->{
            for (int i=0; i<10000;i++){
                account.withdraw(1);
            }
        };

        Thread t1 = new Thread(depositTask, "Depositor");
        Thread t2 = new Thread(withdrawTask, "Withdrawer");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Balance: " +account.getBalance());

        //With synchronized: only 1 thread accesses blance at a time updates don't get lost hence net change is 0.
        //With synchronized: Final Balance: 1000

        //Without synchronized: threads access balance simultaneously, upadtes overwrite each other race condition occurs
        //Without synchronized: Final Balance: (*Value keeps on changing*)



    }
}
