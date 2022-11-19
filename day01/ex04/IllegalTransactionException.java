public class IllegalTransactionException extends RuntimeException {
    public String toString(){
        return "No such money for transfer";
    }
}
