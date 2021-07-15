public class CardAccount extends BankAccount {

    public double getAmount(){
       return super.getAmount();
    }

    public void take(double amountToTake){
        super.take(amountToTake * 1.01);
    }

    public void put(double money){
        super.put(money);
    }
}
