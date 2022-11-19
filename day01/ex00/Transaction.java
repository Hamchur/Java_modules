import java.util.UUID;

public class Transaction {
    private final UUID uuid;
    private User recipient;
    private User sender;
    private Integer amount;
    private final String type;

    public Transaction(User recipient, User sender, Integer amount){
        uuid = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.amount = amount;
        if (amount < 0){
            type = "CREDIT";
        }
        else{
            type = "DEBIT";
        }
    }

    public void makeTransaction(){
        if (sender.getBalance() < Math.abs(amount) || amount == 0){
            System.out.println("Sender's balance " + sender.getBalance() +
                    "\nInvalid transaction amount: " + amount);
            System.exit(-1);
        }

        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);

        System.out.println("[Transaction]" +
                "\nID: " + uuid +
                "\nTransaction Type: " + type +
                "\nSender: " + sender.getName() +
                "\nRecipient: " + recipient.getName() +
                "\nAmout: " + amount);
        System.out.println("[Sender]" +
                "\nID: " + sender.getId() +
                "\nName: " + sender.getName() +
                "\nBalance: " + sender.getBalance());
        System.out.println("[Recipient]" +
                "\nID: " + recipient.getId() +
                "\nName: " + recipient.getName() +
                "\nBalance: " + recipient.getBalance());
    }

    public UUID getUuid() {
        return uuid;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public Integer getAmount(){
        return amount;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
