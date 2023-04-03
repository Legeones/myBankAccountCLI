package TD1;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(double balance){
        this.balance = balance;
    }

    public void deposit(double amount) {
        System.out.println("Solde initiale de "+this.balance+":");
        balance += amount;
        System.out.println("Vous avez déposer "+amount+", votre solde est désormais à "+this.balance);
    }

    public void withdraw(double amount) {
        if(amount>balance){
            throw new IllegalArgumentException("Le solde est insuffisant");
        }
        System.out.println("Solde initiale de "+this.balance+":");
        balance -= amount;
        System.out.println("Vous avez retirer "+amount+", votre solde est désormais à "+this.balance);
        return;
    }

    public double checkBalance() {
        return balance;
    }
}

