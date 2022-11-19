public class UserNotTransferAmountException extends RuntimeException {
    @Override
    public String toString(){
        return "\nNo such money for transaction";
    }
}
