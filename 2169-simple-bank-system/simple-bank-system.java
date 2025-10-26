class Bank {
    long[] bank;
    public Bank(long[] balance) {
        bank=new long[balance.length];
        bank=balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        int n=bank.length;
        if(account1>=0 && account1<=n && account2>=0 && account2<=n){
            if(bank[account1-1]>=money){
                bank[account1-1]=bank[account1-1]-money;
                bank[account2-1]=bank[account2-1]+money;
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account>=0 && account<=bank.length){
            bank[account-1]=bank[account-1]+money;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean withdraw(int account, long money) {
        if(account>=0 && account<=bank.length){
            if( bank[account-1]>=money){
            bank[account-1]=bank[account-1]-money;
            return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */