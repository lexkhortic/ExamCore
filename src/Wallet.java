import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Wallet implements TotalSumWallet, ShowLastCost, ShowLastIncome, AddNewCost, AddNewIncome{

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String NameWallet;
    private long totalSum;
    private ArrayList<Cost> costList;
    private ArrayList<Income> incomeList;

    public Wallet(String nameWallet, long totalSum) {
        NameWallet = nameWallet;
        this.totalSum = totalSum;
        costList = new ArrayList<>();
        incomeList = new ArrayList<>();
    }

    public Wallet(String nameWallet, long totalSum, ArrayList<Cost> costList, ArrayList<Income> incomeList) {
        NameWallet = nameWallet;
        this.totalSum = totalSum;
        this.costList = costList;
        this.incomeList = incomeList;
    }

    public String getNameWallet() {
        return NameWallet;
    }

    public void setNameWallet(String nameWallet) {
        NameWallet = nameWallet;
    }

    public long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(long totalSum) {
        this.totalSum = totalSum;
    }

    public ArrayList<Cost> getCostList() {
        return costList;
    }

    public ArrayList<Income> getIncomeList() {
        return incomeList;
    }

    @Override
    public void totalSumWallet() {
        System.out.print("Текущий баланс кошелька: " + totalSum + "$\n");
    }

    @Override
    public void addNewCost(){
        String nameCost;
        int cash;
        try {
            System.out.print("Введите название затраты: ");
            nameCost = reader.readLine();
            System.out.print("Введите сумму затраты: ");
            cash = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Cost newCost = new Cost(nameCost, cash);

        if ((totalSum - cash) < 0) {
            System.out.println("Оперция не выполнена, не достаточно стредств!\n");
        } else {
            totalSum -= cash;
            costList.add(newCost);
            System.out.println("Затрата " + nameCost + " проведена!\n");
        }
    }

    @Override
    public void addNewIncome(){
        String nameIncome;
        int cash;
        try {
            System.out.print("Введите вид прихода: ");
            nameIncome = reader.readLine();
            System.out.print("Введите сумму прихода: ");
            cash = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Income newIncome = new Income(nameIncome, cash);

        totalSum += cash;
        incomeList.add(newIncome);
        System.out.println("Доход " + nameIncome + " проведен!\n");
    }

    @Override
    public void showLastCost() {
        System.out.println(costList.toString());
    }

    @Override
    public void showLastIncome() {
        System.out.println(incomeList.toString());
    }
}
