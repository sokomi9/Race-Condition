class Count{
    int count;
    public synchronized void increment(){
        count++;
    }
}
public class Index {

    public static void main(String[] args) {
        Count c = new Count();
        Runnable obj1 = () -> {
              for(int i = 1; i <= 10; i++)
                    c.increment();
                
            };
        
        Runnable obj2 = () -> {
                for(int i = 1; i <= 10; i++){
                    c.increment();
                }
            };
        

        Thread t1Thread = new Thread(obj1);
        Thread t2Thread = new Thread(obj2);

        t1Thread.start();
        t2Thread.start();
        
        try {
            t1Thread.join();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        try {
            t2Thread.join();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }

        System.out.println(c.count);
    }
}