package AThreados;


public class Zzthread {
      public static void main(String[] args) {
      Thread t = Thread.currentThread();
      System.out.println(t.getName());

      MinhaThread thread = new MinhaThread("Thread #1",2L);
      MinhaThread thread2 = new MinhaThread("Thread #2", 1L);


     thread.start();
     thread2.start();

     Thread m1 = new Thread(new MeuRunnable());
     m1.start();

     Thread m2 = new Thread(()-> System.out.println("Novo Runnable"));
     m2.start();

     //.start() instruindo a jvm para chamar o metodo run da thread quando puder
      // mas é a jvm quem vai decidir quando iniciar assim que possivel, EXECUTA NA MESMA THREAD
      // .run() esta somente executando na mesma thread


        }

    }




