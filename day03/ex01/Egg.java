public class Egg extends Thread{
    private Integer count;
    private Object key;

    public Egg() {

    }

    public Egg(Integer count, Object key){
        this.count = count;
        this.key = key;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++){
            System.out.println("Egg");
            try {
                synchronized (key){
                    key.notify();
                    key.wait();
                }
            }
            catch (InterruptedException interruptedException){
                System.exit(-1);
            }
        }
    }
}
