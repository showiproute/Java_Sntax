package multithreading;

public class DrawMoneyThread extends Thread {
	
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


	//账户
	private Account account;
	
	//取钱的卡号
	private String drawAccountNo;
	
	//取钱金额
	private double drawMoney;
	
	public DrawMoneyThread(Account account,String drawAccountNo,double drawMoney,String name) {
		super(name);
		this.account=account;
		this.drawAccountNo=drawAccountNo;
		this.drawMoney=drawMoney;
	}

	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		//判断卡号
//		if(this.account.getAccountNo().equals(this.drawAccountNo)) {
//			if(this.account.getBalance() < this.drawMoney) {
//				System.out.println(this.getName()+":"+"取款金额:"+this.drawMoney
//						+"余额不足");
//			}else {
//				System.out.println(this.getName()+":"+"取款金额:"+this.drawMoney+"取款成功");
//				this.account.setBalance(this.account.getBalance()-this.drawMoney);
//				System.out.println(this.getName()+":"+"余额更新为:"+this.account.getBalance());
//			
//			}
//		}	
//	}
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		//判断卡号
//		if(this.account.getAccountNo().equals(this.drawAccountNo)) {
//			//同步代码块，锁的就是account对象
//			synchronized (account) {
//				
//				if(this.account.getBalance() < this.drawMoney) {
//					System.out.println(this.getName()+":"+"取款金额:"+this.drawMoney
//							+"余额不足");
//				}else {
//					System.out.println(this.getName()+":"+"取款金额:"+this.drawMoney+"取款成功");
//					this.account.setBalance(this.account.getBalance()-this.drawMoney);
//					System.out.println(this.getName()+":"+"余额更新为:"+this.account.getBalance());
//				}
//			}
//		}else {
//			System.out.println(this.getName()+":"+"不是同一个卡号，取款失败");
//		}
//	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//判断卡号
		if(this.account.getAccountNo().equals(this.drawAccountNo)) {
			this.account.draw(this.getName(), drawMoney);
		}else {
			System.out.println(this.getName()+":"+"不是同一个卡号，取款失败");
		}
	}
	
	
	public static void main(String[] args) {
		
		Account acc1 = new Account("888", 100.0);
		//用的同步代码块
		DrawMoneyThread draw1 = new DrawMoneyThread(acc1, "888", 20.0, "第一次取");
		DrawMoneyThread draw2 = new DrawMoneyThread(acc1, "888",90.0, "第二次取");
		DrawMoneyThread draw3 = new DrawMoneyThread(acc1, "888", 40.0, "第三次取");
		
		new Thread(draw1).start();
		new Thread(draw2).start();
		new Thread(draw3).start();
		
	}
}
