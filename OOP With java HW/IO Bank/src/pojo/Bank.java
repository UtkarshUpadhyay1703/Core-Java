package pojo;

import java.time.LocalDate;

public class Bank {
	private LocalDate transactionDate;
	private String narration;
	private double withdrawlAmount;
	private double depositeAmount;

	public Bank(LocalDate transactionDate, String narration, double withdrawlAmount, double depositeAmount) {
		super();
		this.transactionDate = transactionDate;
		this.narration = narration;
		this.withdrawlAmount = withdrawlAmount;
		this.depositeAmount = depositeAmount;
	}

	@Override
	public String toString() {
		return "Bank [transactionDate=" + transactionDate + ", narration=" + narration + ", withdrawlAmount="
				+ withdrawlAmount + ", depositeAmount=" + depositeAmount + "]";
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public double getWithdrawlAmount() {
		return withdrawlAmount;
	}

	public void setWithdrawlAmount(double withdrawlAmount) {
		this.withdrawlAmount = withdrawlAmount;
	}

	public double getDepositeAmount() {
		return depositeAmount;
	}

	public void setDepositeAmount(double depositeAmount) {
		this.depositeAmount = depositeAmount;
	}

}
