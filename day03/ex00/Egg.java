public class Egg extends Thread{
    private Integer count;

    public Egg() {

    }

    public Egg(Integer count){
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++){
            System.out.println("Egg");
        }
    }
}
