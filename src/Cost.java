import java.time.LocalDate;

public class Cost {
    private String typeCost;
    private final LocalDate date;
    private int cash;

    public Cost(String nameCost, int cash) {
        this.typeCost = nameCost;
        this.date = LocalDate.now();
        this.cash = cash;
    }

    public String getTypeCost() {
        return typeCost;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return  "Вид затраты: " + typeCost +
                ", Дата: " + date +
                ", Сумма: " + cash + "$";
    }
}
