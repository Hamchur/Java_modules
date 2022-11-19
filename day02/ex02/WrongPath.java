import java.io.IOException;

public class WrongPath extends IOException {
    @Override
    public String toString() {
        return new String ("Error: Wrong Path");
    }
}