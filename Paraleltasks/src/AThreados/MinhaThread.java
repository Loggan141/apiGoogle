package AThreados;

public class MinhaThread extends Thread{
    private String nome;
    private Long tempo;

    MinhaThread(String nome, Long tempo){
        this.nome=nome;
        this.tempo=tempo*1000;

    }

    @Override
    public void run() {

       try{
            for(int i=1; i<6;i++){
                System.out.println("Nome : "+nome+ " Contador: "+i);
                 Thread.sleep(this.tempo);
       }
         }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}
