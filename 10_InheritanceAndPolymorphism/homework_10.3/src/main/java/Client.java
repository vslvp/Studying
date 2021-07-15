public abstract class Client {

    private double money;

    public double getAmount() {
        return money;
    }

    public void put(double amountToPut) {
        if (amountToPut >= 0){
            money += amountToPut;
        }
        else {
            money = money;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake < money){
            money -= amountToTake;
        }
        else {
            money = money;
        }
    }

}
