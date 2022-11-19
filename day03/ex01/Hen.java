public class Hen  extends Thread{
    private Integer count;
    private Object key;

    public Hen(){

    }

    public Hen(Integer count, Object key){
        this.count = count;
        this.key = key;
    }

    @Override
    public void run(){
        for (int i = 0; i < count; i++){
            synchronized (key) {
                try {
                    key.wait();
                } catch (InterruptedException interruptedException) {
                    System.exit(-1);
                }
                System.out.println("Hen");
                key.notify();
            }
        }
    }
}
