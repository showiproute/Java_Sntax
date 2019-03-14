package multithreading;

import multithreading.DrawMoneyThreadMyself.DrawMonyThread;

public class DrawMoneyThreadMyself {

	public static class DrawMonyThread implements Runnable{


		/**
		 * @return the account
		 */
		public AccountMyself getAccount() {
			return account;
		}

		/**
		 * @param account the account to set
		 */
		public void setAccount(AccountMyself account) {
			this.account = account;
		}

		/**
		 * @return the inputMoney
		 */
		public double getInputMoney() {
			return inputMoney;
		}

		/**
		 * @param inputMoney the inputMoney to set
		 */
		public void setInputMoney(double inputMoney) {
			this.inputMoney = inputMoney;
		}

		/**
		 * @return the inputAccount
		 */
		public String getInputAccount() {
			return inputAccount;
		}

		/**
		 * @param inputAccount the inputAccount to set
		 */
		public void setInputAccount(String inputAccount) {
			this.inputAccount = inputAccount;
		}

		public DrawMonyThread(AccountMyself account, double inputMoney, String inputAccount) {
			super();
			this.account = account;
			this.inputMoney = inputMoney;
			this.inputAccount = inputAccount;
		}

		private AccountMyself account;
		private double inputMoney;
		private String inputAccount;
		
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			if(this.inputAccount.equals(account.getAccountNo())) {
//				account.draw(this.inputAccount, this.inputMoney);
//			}else {
//				System.out.println("输入错误卡号");
//			}
//			
//		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(this.inputAccount.equals(account.getAccountNo())) {
				synchronized(account) {
					if(account.getBalance()>=this.inputMoney) {
						account.setBalance(account.getBalance()-this.inputMoney);
						System.out.println("取款成功:"+this.inputMoney+"余额:"+account.getBalance());
						
					}else{
						System.out.println("余额不足");
					}
					
				}
			}else {
				System.out.println("输入错误卡号");
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		AccountMyself accountMyself = new AccountMyself("888", 100.0);
		DrawMonyThread drawMonyThread = new DrawMonyThread(accountMyself, 20.0, "888");
		DrawMonyThread drawMonyThread2 = new DrawMonyThread(accountMyself, 44.0, "888");
		DrawMonyThread drawMonyThread3 = new DrawMonyThread(accountMyself, 66.0, "888");

		new Thread(drawMonyThread).start();
		new Thread(drawMonyThread2).start();
		new Thread(drawMonyThread3).start();
		
		
		
	}
}
