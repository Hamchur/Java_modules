public class Program {
    public static void main(String[] args) {
        User m1 = new User("Man1", 2600);
        User m2 = new User("Man2", 1000);
        User m3 = new User("Man3",-200);
        User m4 = new User("Man4", 0);

        UsersArrayList p1 = new UsersArrayList();
        p1.add(m1);
        p1.add(m2);
        p1.add(m3);

        System.out.println(p1.findId(0));
        System.out.println(p1.findIndex(2));
        System.out.println(p1.findIndex(3));
        System.out.println(p1.getAmount());
    }
}