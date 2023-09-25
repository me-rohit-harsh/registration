package com.indianbank.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private Long id;
	@Column(name = "transaction_date")
	private final LocalDate transactionDate = LocalDate.now();
	@Column(name = "transaction_amount")
	private double transactionAmount;
	@Column(name = "transaction_type")
	private String transactionType;
	@Column(name = "initial_balance")
	private double initialBalance;
	@Column(name = "final_balance")
	private double finalbalance;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long id, LocalDate transactionDate, double transactionAmount, String transactionType,
			double initialBalance, double finalbalance) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.initialBalance = initialBalance;
		this.finalbalance = finalbalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public double getFinalbalance() {
		return finalbalance;
	}

	public void setFinalbalance(double finalbalance) {
		this.finalbalance = finalbalance;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", transactionAmount="
				+ transactionAmount + ", transactionType=" + transactionType + ", initialBalance=" + initialBalance
				+ ", finalbalance=" + finalbalance + "]";
	}
}