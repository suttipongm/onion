package com.worldbestsoft.model;

// Generated Jul 23, 2013 9:54:03 PM by Hibernate Tools 4.0.0

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
 * JobOrder generated by hbm2java
 */
@Entity
@Table(name = "job_order", catalog = "onion")
public class JobOrder implements java.io.Serializable {

	private Long id;
	private Employee employee;
	private SaleOrderItem saleOrderItem;
	private String status;
	private Date startDate;
	private Date endDate;
	private Date actualEndDate;

	public JobOrder() {
	}

	public JobOrder(Employee employee, SaleOrderItem saleOrderItem) {
		this.employee = employee;
		this.saleOrderItem = saleOrderItem;
	}

	public JobOrder(Employee employee, SaleOrderItem saleOrderItem, String status, Date startDate, Date endDate, Date actualEndDate) {
		this.employee = employee;
		this.saleOrderItem = saleOrderItem;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.actualEndDate = actualEndDate;
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
	@JoinColumn(name = "employee_id", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sale_order_item_id", nullable = false)
	public SaleOrderItem getSaleOrderItem() {
		return this.saleOrderItem;
	}

	public void setSaleOrderItem(SaleOrderItem saleOrderItem) {
		this.saleOrderItem = saleOrderItem;
	}

	@Column(name = "status", length = 3)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "actual_end_date", length = 19)
	public Date getActualEndDate() {
		return this.actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

}
