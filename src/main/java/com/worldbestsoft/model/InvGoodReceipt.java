package com.worldbestsoft.model;

// Generated Jul 16, 2013 3:46:49 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InvGoodReceipt generated by hbm2java
 */
@Entity
@Table(name = "inv_good_receipt", catalog = "onion")
public class InvGoodReceipt implements java.io.Serializable {

	private Long id;
	private Supplier supplier;
	private String runningNo;
	private Date receiptDate;
	private BigDecimal totalCost;
	private String remark;
	private Set<InvGoodReceiptItem> invGoodReceiptItems = new HashSet<InvGoodReceiptItem>(0);

	public InvGoodReceipt() {
	}

	public InvGoodReceipt(Supplier supplier) {
		this.supplier = supplier;
	}

	public InvGoodReceipt(Supplier supplier, String runningNo, Date receiptDate, BigDecimal totalCost, String remark, Set<InvGoodReceiptItem> invGoodReceiptItems) {
		this.supplier = supplier;
		this.runningNo = runningNo;
		this.receiptDate = receiptDate;
		this.totalCost = totalCost;
		this.remark = remark;
		this.invGoodReceiptItems = invGoodReceiptItems;
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
	@JoinColumn(name = "supplier_id", nullable = false)
	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Column(name = "running_no", length = 45)
	public String getRunningNo() {
		return this.runningNo;
	}

	public void setRunningNo(String runningNo) {
		this.runningNo = runningNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receipt_date", length = 19)
	public Date getReceiptDate() {
		return this.receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	@Column(name = "total_cost", precision = 10)
	public BigDecimal getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invGoodReceipt")
	public Set<InvGoodReceiptItem> getInvGoodReceiptItems() {
		return this.invGoodReceiptItems;
	}

	public void setInvGoodReceiptItems(Set<InvGoodReceiptItem> invGoodReceiptItems) {
		this.invGoodReceiptItems = invGoodReceiptItems;
	}

}
