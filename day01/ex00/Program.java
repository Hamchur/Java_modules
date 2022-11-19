public class Program {
    public static void main(String[] args) {
        User recipient = new User(0, "Sam", 1000);
        User sender = new User(1, "Alex", 1000);
        System.out.println(recipient);
        System.out.println(sender);

        Transaction transaction = new Transaction(recipient, sender, -500);
        transaction.makeTransaction();
    }
}
