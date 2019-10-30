package edu.umb.cs.cs681;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount2 {
	private double balance = 0;
	private ReentrantLock lock;
	private Condition sufficientFundsCondition, belowUpperLimitFundsCondition;
	private ThreadSafeBankAccount2 account;

	int generateAccoNo() {
		lock.lock();
		try {
			Random random = new Random();
			int value = random.nextInt(10000);
			return value;
		} finally {
			lock.unlock();
		}

	}

	public ThreadSafeBankAccount2() {
		lock = new ReentrantLock();
		sufficientFundsCondition = lock.newCondition();
		belowUpperLimitFundsCondition = lock.newCondition();
		account = this;
	}

	public void deposit(double amount) {
		lock.lock();
		try {
			System.out.println("Lock obtained");
			System.out.println(Thread.currentThread().getId() + " (d): current balance: " + balance);
			while (balance >= 300) {
				System.out.println(Thread.currentThread().getId() + " (d): await(): Balance exceeds the upper limit.");
				belowUpperLimitFundsCondition.await();
			}
			balance += amount;
			System.out.println(Thread.currentThread().getId() + " (d): new balance: " + balance);
			sufficientFundsCondition.signalAll();
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("Lock released");
		}
	}

	public void withdraw(double amount) {
		lock.lock();
		try {
			System.out.println("Lock obtained in withdraw");
			System.out.println(Thread.currentThread().getId() + " (w): current balance: " + balance);
			while (balance <= 0) {
				System.out.println(Thread.currentThread().getId() + " (w): await(): Insufficient funds");
				sufficientFundsCondition.await();
			}
			balance -= amount;
			System.out.println(Thread.currentThread().getId() + " (w): new balance: " + balance);
			belowUpperLimitFundsCondition.signalAll();
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("Lock released in withdraw");
		}
	}

	public static void main(String[] args) {
		System.out.println("This is Ordered	Locking	with Instance IDs");
		ThreadSafeBankAccount2 bankAccount = new ThreadSafeBankAccount2();
		ThreadSafeBankAccount2 account2 = new ThreadSafeBankAccount2();
		for (int i = 0; i < 5; i++) {
			new Thread(bankAccount.new DepositRunnable()).start();
			new Thread(bankAccount.new WithdrawRunnable()).start();
			new Thread(bankAccount.new transferRunnable(account2)).start();
		}

		try {
			Thread.sleep(125);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);

	}

	private class DepositRunnable implements Runnable {
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					account.deposit(100);
					Thread.sleep(2);
				}
			} catch (InterruptedException exception) {
			}
		}
	}

	private class WithdrawRunnable implements Runnable {
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					account.withdraw(100);
					Thread.sleep(2);
				}
			} catch (InterruptedException exception) {
			}
		}
	}

	private class transferRunnable implements Runnable {
		private ThreadSafeBankAccount2 ac2;

		public transferRunnable(ThreadSafeBankAccount2 abc2) {
			ac2 = abc2;
		}

		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					account.transfer(account, ac2, 100);
					Thread.sleep(2);
				}
			} catch (InterruptedException exception) {
			}
		}
	}

	public void transfer(ThreadSafeBankAccount2 source, ThreadSafeBankAccount2 destination, double amount)
			throws InterruptedException {
		lock.lock();

		int sourceID = System.identityHashCode(source.generateAccoNo());
		int destID = System.identityHashCode(destination.generateAccoNo());
		// this.sourceAccNo = source.generateAccoNo();
		// this.destAccNo = destination.generateAccoNo();

		try {
			System.out.println("Lock obtained in transfer!");
			if (sourceID < destID) {
				System.out.println("Call when Source account sourceID is less than Destination account destID");
				source.lock.lock();
				destination.lock.lock();
				if (source.balance < amount) {
					System.out.println("You can not able to transfer amount!");
				} else {
					// System.out.println("test inside the transfer: " +
					// amount);

					lock.lock();
					try {
						source.withdraw(amount);
					} finally {
						lock.unlock();
					}
					lock.lock();
					try {
						destination.deposit(amount);
					} finally {
						lock.unlock();
					}
				}
				source.lock.unlock();
				destination.lock.unlock();
			} else if (sourceID > destID) {

				System.out.println("Call when Source account sourceID is greater than Destination account destID");
				destination.lock.lock();
				source.lock.lock();
				if (destination.balance < amount) {
					System.out.println("You can not able to transfer amount!");
				} else {
					// System.out.println("test inside the transfer: " +
					// amount);

					lock.lock();
					try {
						destination.withdraw(amount);
					} finally {
						lock.unlock();
					}
					lock.lock();
					try {
						source.deposit(amount);
					} finally {
						lock.unlock();
					}
				}

				destination.lock.unlock();
				source.lock.unlock();
			}

		} finally {
			lock.unlock();
			System.out.println("Lock release in transfer!");
		}

	}

}
