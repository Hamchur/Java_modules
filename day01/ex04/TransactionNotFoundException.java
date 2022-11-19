public class TransactionNotFoundException extends RuntimeException {
    public String toString(){
        return "No such transaction";
    }
}

