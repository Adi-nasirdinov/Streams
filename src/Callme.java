public class Callme {
    int activeThread = 1;
    int count = 1;
    int max = 1000000;




    synchronized void call(int id, String name) {
        while(id!=activeThread && count<=max) {
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("call прерван ");
            }
        }
        if (count>max){
            notifyAll();
            return;
        }
        System.out.println(name + " вывел " + count);
        count++;
        activeThread = (activeThread%10) + 1;
       notifyAll();



    }

}
