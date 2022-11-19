public class Hen  extends Thread{
    private  Integer count;

    public Hen(){

    }

    public Hen(Integer count){
        this.count = count;
    }

    @Override
    public void run(){
        for (int i = 0; i < count; i++){
            System.out.println("Hen");
        }
    }
}
