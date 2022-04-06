package ZZthrea;

public class Main {
    public static void main(String[] args) {
        t1.run();
        t2.run();
        Thread t3 = new Thread();

    }


    public static Runnable t1 = new Runnable() {
        @Override
        public void run() {
        for(int i=1; i<=10;i++){
            System.out.println("Thread 1 : "+i);
        }
        }
    };

    public static Runnable t2 = new Runnable() {
        @Override
        public void run() {
        for(int i=1; i<=10;i++){
            System.out.println("Thread 2 : "+i);
        }
        }
    };


}
