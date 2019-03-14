package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class AccountMyself {

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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountMyself [accountNo=" + accountNo + ", balance=" + balance + "]";
	}
	public AccountMyself(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

	
	ReentrantLock lock=new ReentrantLock();
	private String accountNo;
	private double balance;
	
//	public synchronized void draw(String accountNo,double money) {
//		if(accountNo.equals(this.getAccountNo())) {
//			if(this.getBalance()>=money) {
//				this.balance-=money;
//				System.out.println("成功取款"+money+"余额："+this.getBalance());
//			}else {
//				System.out.println("余额不足");
//			}
//			
//		}else {
//			System.out.println("输入错误卡号");
//		}
//		
//	}

	public void draw(String accountNo,double money) {
		lock.lock();
		try {
			if(accountNo.equals(this.getAccountNo())) {
				if(this.getBalance()>=money) {
					this.balance-=money;
					System.out.println("成功取款"+money+"余额："+this.getBalance());
				}else {
					System.out.println("余额不足");
				}
				
			}else {
				System.out.println("输入错误卡号");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	
}
