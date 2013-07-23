package com.worldbestsoft.model;

// Generated Jul 23, 2013 9:54:03 PM by Hibernate Tools 4.0.0

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
import javax.persistence.UniqueConstraint;

/**
 * InvGoodsReceipt generated by hbm2java
 */
@Entity
@Table(name = "inv_goods_receipt", catalog = "onion", uniqueConstraints = @UniqueConstraint(columnNames = "running_no"))
public class InvGoodsReceipt implements java.io.Serializable {

	private Long id;
	private Supplier supplier;
	private String runningNo;
	private Date receiptDate;
	private BigDecimal totalCost;
	private String memo;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private Set<InvGoodsReceiptItem> invGoodsReceiptItems = new HashSet<InvGoodsReceiptItem>(0);

	public InvGoodsReceipt() {
	}

	public InvGoodsReceipt(Supplier supplier, String runningNo) {
		this.supplier = supplier;
		this.runningNo = runningNo;
	}

	public InvGoodsReceipt(Supplier supplier, String runningNo, Date receiptDate, BigDecimal totalCost, String memo, Date createDate, String createUser, Date updateDate, String updateUser, Set<InvGoodsReceiptItem> invGoodsReceiptItems) {
		this.supplier = supplier;
		this.runningNo = runningNo;
		this.receiptDate = receiptDate;
		this.totalCost = totalCost;
		this.memo = memo;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.invGoodsReceiptItems = invGoodsReceiptItems;
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

	@Column(name = "running_no", unique = true, nullable = false, length = 20)
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

	@Column(name = "memo")
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invGoodsReceipt")
	public Set<InvGoodsReceiptItem> getInvGoodsReceiptItems() {
		return this.invGoodsReceiptItems;
	}

	public void setInvGoodsReceiptItems(Set<InvGoodsReceiptItem> invGoodsReceiptItems) {
		this.invGoodsReceiptItems = invGoodsReceiptItems;
	}

}