
package threatcooperation;


public class ThreatCooperation {
 private static Account account=new Account();
    
    public static void main(String[] args) {
       
        
    }
      
    }
    
    public static class DipositTask implements Runnable{

        @Override
        public void run() {
            try {
                  while(true){
           Account.deposit((int)(Math.random() * 10) + 1);
                 Thread.sleep(1000);
           }
            } catch (InterruptedException ex) {
            }
        }
    
    }
    public static class WithdrawTask implements Runnable{

        @Override
        public void run() {
            
        }
    
    }
    private static class Account {
    
        private static Lock lock = new ReentrantLock();
        
        private int balance = 0;

        public static Lock getLock() {
            return lock;
        }

        public static void setLock(Lock lock) {
            Account.lock = lock;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
        
        
        public void withdraw(int amount) {
                    lock.lock(); // Acquire the lock
         try {
        while (balance < amount) {
        System.out.println("\t\t\tWait for a deposit");
        newDeposit.await();


    System.out.println("\t\t\tWait for a deposit");
    newDeposit.await();
 }
       
    }
    
}
