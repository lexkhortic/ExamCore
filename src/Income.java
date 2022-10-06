import java.time.LocalDate;

public class Income {
    private String typeIncome;
    private final LocalDate date;
    private int cash;

    public Income(String typeIncome, int cash) {
        this.typeIncome = typeIncome;
        this.date = LocalDate.now();
        this.cash = cash;
    }

    public String getTypeIncome() {
        return typeIncome;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return  "Вид дохода: " + typeIncome +
                ", Дата: " + date +
                ", Сумма: " + cash + "$";
    }

}
