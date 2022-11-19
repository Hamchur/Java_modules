public class TransactionListEmptyException extends RuntimeException {
    @Override
    public String toString() {
        return "The transaction list is empty";
    }
}
