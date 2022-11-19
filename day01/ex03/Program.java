public class Program {
    public static void main(String[] args) {
        User m1 = new User("Man1", 2600);
        User m2 = new User("Man2", 1000);
        User m3 = new User("Man3", -200);

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        System.out.println("\n||Transactions||");
        Transaction t1 = new Transaction(m1, m2, 1000);
        t1.doTransaction();
        System.out.println(t1);
        Transaction t2 = new Transaction(m1, m2, -500);
        t2.doTransaction();
        System.out.println(t2);
        Transaction t3 = new Transaction(m2, m3, 200);
        t3.doTransaction();
        System.out.println(t3);
        Transaction t4 = new Transaction(m2, m3, 400);
        t4.doTransaction();
        System.out.println(t4);

        TransactionsLinkedList tl = new TransactionsLinkedList();
        tl.addTransaction(t1);
        tl.addTransaction(t2);
        tl.addTransaction(t3);
        tl.addTransaction(t4);
        System.out.println("\nRemote ID: " + t2.getUID());
        tl.removeTransaction(t2.getUID());

        System.out.println("\n|Transactions|");
        tl.print();
    }
}
