public class NewThread implements Runnable{
    Callme target;
    String name;
    Thread t;
    int id;



    NewThread( Callme targ, String threadname, int id){
        name = threadname;
        target = targ;
        this.id = id;
        t = new Thread(this,name);
        System.out.println("Дочерний поток" + t);
    }
    @Override
    public void run() {

        System.out.println(name);
        while(target.count<=target.max) {
            target.call(this.id, this.name);
        }
        System.out.println(name + " Заврешен");
        }

    }





