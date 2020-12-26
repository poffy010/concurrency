package com.mmall.MainShiTi.sisuo;

public class TransforAmount implements Runnable{
    private Account fromAccount;//转出账户
    private Account toAccount;//转入账户
    private int amount;

    public TransforAmount(Account fromAccount,Account toAccount,int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        while(true){//模拟不断地转账
            synchronized (fromAccount){
                synchronized (toAccount){
                    if(fromAccount.getBalance() > amount){
                        fromAccount.debit(amount);
                        toAccount.credit(amount);
                    }
                }
            }

            System.out.println("转出账户的余额 fromAccount :" + fromAccount.getAccountName() + ",balance:" + fromAccount.getBalance());
            System.out.println("转入账户的余额 toAccount :" + toAccount.getAccountName() + ",balance:" + toAccount.getBalance());
        }
    }


}
