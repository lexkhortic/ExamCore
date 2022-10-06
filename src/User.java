import java.io.BufferedReader;
import java.io.InputStreamReader;

public class User {

    private String name;
    private long id;
    private Wallet wallet;

    public User(String name, long id, Wallet wallet) {
        this.name = name;
        this.id = id;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return
                "Имя: " + name +
                ", ID: " + id +
                ", Кошелек: " + wallet.getNameWallet();
    }
}
