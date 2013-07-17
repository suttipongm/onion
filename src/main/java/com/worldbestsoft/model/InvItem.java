package com.worldbestsoft.model;

// Generated Jul 16, 2013 3:46:49 PM by Hibernate Tools 4.0.0

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
 * InvItem generated by hbm2java
 */
@Entity
@Table(name = "inv_item", catalog = "onion")
public class InvItem implements java.io.Serializable {

	private Integer id;
	private InvItemGroup invItemGroup;
	private String code;
	private String name;
	private String description;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
	private Set<Catalog> catalogs = new HashSet<Catalog>(0);
	private Set<InvGoodMovementItem> invGoodMovementItems = new HashSet<InvGoodMovementItem>(0);
	private Set<InvGoodReceiptItem> invGoodReceiptItems = new HashSet<InvGoodReceiptItem>(0);
	private Set<CatalogItem> catalogItems = new HashSet<CatalogItem>(0);

	public InvItem() {
	}

	public InvItem(InvItemGroup invItemGroup, String code, String name) {
		this.invItemGroup = invItemGroup;
		this.code = code;
		this.name = name;
	}

	public InvItem(InvItemGroup invItemGroup, String code, String name, String description, Date createDate, String createUser, Date updateDate, String updateUser, Set<Catalog> catalogs, Set<InvGoodMovementItem> invGoodMovementItems, Set<InvGoodReceiptItem> invGoodReceiptItems, Set<CatalogItem> catalogItems) {
		this.invItemGroup = invItemGroup;
		this.code = code;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.catalogs = catalogs;
		this.invGoodMovementItems = invGoodMovementItems;
		this.invGoodReceiptItems = invGoodReceiptItems;
		this.catalogItems = catalogItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inv_item_group_id", nullable = false)
	public InvItemGroup getInvItemGroup() {
		return this.invItemGroup;
	}

	public void setInvItemGroup(InvItemGroup invItemGroup) {
		this.invItemGroup = invItemGroup;
	}

	@Column(name = "code", nullable = false, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invItem")
	public Set<Catalog> getCatalogs() {
		return this.catalogs;
	}

	public void setCatalogs(Set<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invItem")
	public Set<InvGoodMovementItem> getInvGoodMovementItems() {
		return this.invGoodMovementItems;
	}

	public void setInvGoodMovementItems(Set<InvGoodMovementItem> invGoodMovementItems) {
		this.invGoodMovementItems = invGoodMovementItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invItem")
	public Set<InvGoodReceiptItem> getInvGoodReceiptItems() {
		return this.invGoodReceiptItems;
	}

	public void setInvGoodReceiptItems(Set<InvGoodReceiptItem> invGoodReceiptItems) {
		this.invGoodReceiptItems = invGoodReceiptItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invItem")
	public Set<CatalogItem> getCatalogItems() {
		return this.catalogItems;
	}

	public void setCatalogItems(Set<CatalogItem> catalogItems) {
		this.catalogItems = catalogItems;
	}

}