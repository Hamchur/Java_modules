public class User {
    private Integer id;
    private String name;
    private Integer balance;

    public User(String name, Integer balance){
        this.id = UserIdsGenerator.getInstance().getUuid();
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void display() {

    }

    public Integer getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public Integer getBalance(){
        return balance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Integer balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
        else {
            System.err.println("Incorrect balance!");
        }
    }
}
