import java.util.Calendar;

public class DepositAccount extends BankAccount {


    private Calendar lastIncome;

    public double getAmount(){
        return super.getAmount();
    }
    public Calendar lastIncome(double money){
        super.put(money);
        return lastIncome;
    }
    private boolean check(Calendar date1){
        if (date1.before(lastIncome)){
            return false;
        }
        return true;
    }
    public void take(double money, Calendar date1){
        if (check(date1)){
            System.out.println("Месяц еще не прошел!");
        }
        else {
            super.take(money);
        }
    }
}
