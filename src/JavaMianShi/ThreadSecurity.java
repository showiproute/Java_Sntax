package JavaMianShi;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSecurity {

	public static class Account{
		private final ReentrantLock lock=new ReentrantLock();
		
		/**
		 * @return the accountNo
		 */
		public String getAccountNo() {
			return accountNo;
		}

		/**
		 * @param accountNo the accountNo to set
		 */
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		/**
		 * @return the balance
		 */
		public double getBalance() {
			return balance;
		}

		/**
		 * @param balance the balance to set
		 */
		public void setBalance(double balance) {
			this.balance = balance;
		}

		private String accountNo;
		private double balance;
		
		public Account(String accountNo,double balance) {
			this.accountNo=accountNo;
			this.balance=balance;
		}
		
//		public synchronized void draw(String threadName,double drawMoney) {
//			if(this.getBalance()<drawMoney) {
//				System.out.println(threadName+":"+"取款金额:"+drawMoney+"余额不足");
//			}else {
//				System.out.println(threadName+":"+"取款金额:"+drawMoney+"取款成功");
//				this.setBalance(this.getBalance()-drawMoney);
//				System.out.println(threadName+":"+"余额更新为:"+this.getBalance());
//			}
//		}
		public void draw(String threadName,double drawMoney) {
			
			lock.lock();
			try {
			if(this.getBalance()<drawMoney) {
				System.out.println(threadName+":"+"取款金额:"+drawMoney+"余额不足");
			}else {
				System.out.println(threadName+":"+"取款金额:"+drawMoney+"取款成功");
				this.setBalance(this.getBalance()-drawMoney);
				System.out.println(threadName+":"+"余额更新为:"+this.getBalance());
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
	}
	
	public static class DrawMoneyThread extends Thread{
		public DrawMoneyThread(Account account, String drawAccountNo, double drawMoney,String name) {
			super(name);
			this.account = account;
			this.drawAccountNo = drawAccountNo;
			this.drawMoney = drawMoney;
		}
		/**
		 * @return the account
		 */
		public Account getAccount() {
			return account;
		}
		/**
		 * @param account the account to set
		 */
		public void setAccount(Account account) {
			this.account = account;
		}
		/**
		 * @return the drawAccountNo
		 */
		public String getDrawAccountNo() {
			return drawAccountNo;
		}
		/**
		 * @param drawAccountNo the drawAccountNo to set
		 */
		public void setDrawAccountNo(String drawAccountNo) {
			this.drawAccountNo = drawAccountNo;
		}
		/**
		 * @return the drawMoney
		 */
		public double getDrawMoney() {
			return drawMoney;
		}
		/**
		 * @param drawMoney the drawMoney to set
		 */
		public void setDrawMoney(double drawMoney) {
			this.drawMoney = drawMoney;
		}
		private Account account;
		private String drawAccountNo;
		private double drawMoney;
		
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			if(this.account.getAccountNo().equals(this.drawAccountNo)) {
//				synchronized (account) {
//				if(this.account.getBalance()<this.drawMoney) {
//					System.out.println(this.getName()+":"+"取款金额:"+this.drawMoney+"余额不足");
//				}else {
//					System.out.println(this.getName()+":"+"取款金额:"+this.drawMoney+"取款成功");
//					this.account.setBalance(this.account.getBalance()-this.drawMoney);
//					System.out.println(this.getName()+":"+"余额更新为:"+this.account.getBalance());
//				}
//				}
//			}else {
//				System.out.println(this.getName()+":"+"不是同一个卡号，取款失败");
//			}
//			
//		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(this.account.getAccountNo().equals(this.drawAccountNo)) {
				this.account.draw(this.getName(), drawMoney);
			}else {
				System.out.println(this.getName()+":"+"不是同一个卡号，取款失败");
			}
		}
	}
	
	public static void main(String[] args) {
		Account acc1 = new Account("888888", 1000.00);
		
		DrawMoneyThread draw1 = new DrawMoneyThread(acc1, "888888", 200,"第一次取钱");
		DrawMoneyThread draw2 = new DrawMoneyThread(acc1, "888888", 900,"第一次取钱");
		DrawMoneyThread draw3 = new DrawMoneyThread(acc1, "888888", 100,"第一次取钱");

		new Thread(draw1).start();
		new Thread(draw2).start();
		new Thread(draw3).start();
	
	}
}
