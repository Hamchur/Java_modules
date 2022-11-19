public class Program {
    public static void main(String[] args) {
        User m1 = new User("Man1", 3600);
        User m2 = new User("Man2", 1000);
        User m3 = new User("Man3", -200);

        TransactionsService service = new TransactionsService();
        service.addUser(m1);
        service.addUser(m2);
        service.addUser(m3);

        System.out.println("\nUsers before transaction");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        service.transferTransaction(m1.getID(), m2.getID(), 1000);
        service.transferTransaction(m1.getID(), m3.getID(), 300);

        System.out.println("\nBalance after first transaction");
        System.out.println(service.retrieveUserBalance(m1));
        System.out.println(service.retrieveUserBalance(m2));
        System.out.println(service.retrieveUserBalance(m3));
        System.out.println("\nUser transaction");
        service.retrieveUserTransaction(m1).print();
        service.retrieveUserTransaction(m2).print();
        service.retrieveUserTransaction(m3).print();

        System.out.println("\nRemote transaction...");
        int transactionIndex = 1;
        service.removeTransactionFromUser(m1.getID(), service.retrieveUserTransaction(m1).toArray()[transactionIndex].getUID());
        transactionIndex = 0;
        service.removeTransactionFromUser(m3.getID(), service.retrieveUserTransaction(m3).toArray()[transactionIndex].getUID());

        System.out.println("\nUser transaction after remote transaction by ID");
        service.retrieveUserTransaction(m1).print();
        service.retrieveUserTransaction(m2).print();
        service.retrieveUserTransaction(m3).print();

        System.out.println("\nUnpaired transactions");
        printTransactionArray(service.checkValidityTransactions());
    }
    public static void printTransactionArray(Transaction[] transactionArray) {
        if (transactionArray.length == 0)
            System.out.println("No transactions\n");
        for (int count = 0; count < transactionArray.length; count++) {
            System.out.println(transactionArray[count]);
        }
    }
}
