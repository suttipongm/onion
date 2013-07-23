package com.worldbestsoft.model;

// Generated Jul 23, 2013 9:54:03 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * InvStock generated by hbm2java
 */
@Entity
@Table(name = "inv_stock", catalog = "onion", uniqueConstraints = @UniqueConstraint(columnNames = "inv_item_id"))
public class InvStock implements java.io.Serializable {

	private Long id;
	private InvItem invItem;
	private BigDecimal qty;

	public InvStock() {
	}

	public InvStock(InvItem invItem) {
		this.invItem = invItem;
	}

	public InvStock(InvItem invItem, BigDecimal qty) {
		this.invItem = invItem;
		this.qty = qty;
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
	@JoinColumn(name = "inv_item_id", unique = true, nullable = false)
	public InvItem getInvItem() {
		return this.invItem;
	}

	public void setInvItem(InvItem invItem) {
		this.invItem = invItem;
	}

	@Column(name = "qty", precision = 10)
	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

}