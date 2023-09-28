package com.indianbank.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction_dtls")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "transaction_id")
	private Long trnsactionId;

	@Column(name = "user_id")
	private Long userId;

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(double transactionAmount, String transactionType, double initialBalance, double finalbalance,
			Long trnsactionId, Long userId) {
		super();
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.initialBalance = initialBalance;
		this.finalbalance = finalbalance;
		this.trnsactionId = trnsactionId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", transactionDate=" + transactionDate + ", transactionAmount="
				+ transactionAmount + ", transactionType=" + transactionType + ", initialBalance=" + initialBalance
				+ ", finalbalance=" + finalbalance + ", trnsactionId=" + trnsactionId + ", userId=" + userId + "]";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getTrnsactionId() {
		return trnsactionId;
	}

	public void setTrnsactionId(Long trnsactionId) {
		this.trnsactionId = trnsactionId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

}
