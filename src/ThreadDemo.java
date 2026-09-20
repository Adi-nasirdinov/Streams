
public class ThreadDemo {
    public static void main(String[] args) {

        Callme target = new Callme();

        NewThread[] threads = new NewThread[10];

        for(int i =0; i< threads.length ; i++) {
           int id = i+1;
            threads[i] = new NewThread(target, " "+ (i+1) +"- Thread", id);
        }

        for(NewThread nt : threads) {
            nt.t.start();
        }

        try {

            System.out.println("Ожидание завершения потоков");

            for(NewThread nt : threads) {
                nt.t.join();
            }

        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Завершение главного потока");

    }
}