package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

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
		return "Account [accountNo=" + accountNo + ", balance=" + balance + "]";
	}

	//添加可重入锁属性
	private final ReentrantLock lock=new ReentrantLock();
	
	//账号
	private String accountNo;
	
	//余额
	private double balance;
	
	public Account(String accountNo,double balance) {
		this.accountNo=accountNo;
		this.balance=balance;
	}
	
//	public synchronized void draw(String threadName,double drawMoney) {
//		if(this.getBalance()<drawMoney) {
//			System.out.println(threadName+":"+"取款金额:"+drawMoney+"余额不足，取款失败");
//		}else {
//			System.out.println(threadName+":"+"取款金额"+drawMoney+"取款成功");
//			this.setBalance(this.getBalance()-drawMoney);
//			System.out.println(threadName+":"+"余额更新为："+this.getBalance());
//		}
//	}
	
	//通过调用lock锁的方式
	public void draw(String threadName,double drawMoney) {
		//调用锁的lock方式进行加锁
		//加锁后，其他线程需要等待锁释放才能进入
		lock.lock();
		//锁里面的逻辑需要用try..catch块包在里面
		try {
			if(this.getBalance()<drawMoney) {
				System.out.println(threadName+":"+"取款金额"
			+drawMoney+"余额不足，取款失败");
			}else {
				System.out.println(threadName+":"+"取款金额"+drawMoney+"取款成功");
				this.setBalance(this.getBalance()-drawMoney);
				System.out.println(threadName+":"+"余额更新为:"+this.getBalance());
			}
		}
		//无论锁里面的逻辑执行成功与否，都要释放，需要用finall块释放锁
		finally {
			lock.unlock();
		}
	}
	
	
}
