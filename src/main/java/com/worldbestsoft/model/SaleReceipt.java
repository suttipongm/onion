package com.worldbestsoft.model;

// Generated Jul 24, 2013 12:06:40 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SaleReceipt generated by hbm2java
 */
@Entity
@Table(name = "sale_receipt", catalog = "onion")
public class SaleReceipt implements java.io.Serializable {

	private Long id;
	private SaleOrder saleOrder;
	private String receiptNo;
	private Date receiptDate;
	private String receiptType;
	private BigDecimal receiptAmount;
	private String chequeNo;
	private String chequeBank;
	private Date chequeDate;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;

	public SaleReceipt() {
	}

	public SaleReceipt(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public SaleReceipt(SaleOrder saleOrder, String receiptNo, Date receiptDate, String receiptType, BigDecimal receiptAmount, String chequeNo, String chequeBank, Date chequeDate, Date createDate, String createUser, Date updateDate, String updateUser) {
		this.saleOrder = saleOrder;
		this.receiptNo = receiptNo;
		this.receiptDate = receiptDate;
		this.receiptType = receiptType;
		this.receiptAmount = receiptAmount;
		this.chequeNo = chequeNo;
		this.chequeBank = chequeBank;
		this.chequeDate = chequeDate;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sale_order_id", nullable = false)
	public SaleOrder getSaleOrder() {
		return this.saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	@Column(name = "receipt_no", length = 20)
	public String getReceiptNo() {
		return this.receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receipt_date", length = 19)
	public Date getReceiptDate() {
		return this.receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	@Column(name = "receipt_type", length = 3)
	public String getReceiptType() {
		return this.receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}

	@Column(name = "receipt_amount", precision = 10)
	public BigDecimal getReceiptAmount() {
		return this.receiptAmount;
	}

	public void setReceiptAmount(BigDecimal receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	@Column(name = "cheque_no", length = 50)
	public String getChequeNo() {
		return this.chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	@Column(name = "cheque_bank", length = 50)
	public String getChequeBank() {
		return this.chequeBank;
	}

	public void setChequeBank(String chequeBank) {
		this.chequeBank = chequeBank;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cheque_date", length = 19)
	public Date getChequeDate() {
		return this.chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "create_user", length = 50)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "update_user", length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
