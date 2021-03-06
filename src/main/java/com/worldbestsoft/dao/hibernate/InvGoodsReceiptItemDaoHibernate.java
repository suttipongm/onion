package com.worldbestsoft.dao.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.worldbestsoft.dao.InvGoodsReceiptItemDao;
import com.worldbestsoft.model.InvGoodsReceiptItem;

@Repository("invGoodsReceiptItemDao")
public class InvGoodsReceiptItemDaoHibernate extends GenericDaoHibernate<InvGoodsReceiptItem, Long> implements InvGoodsReceiptItemDao {

	public InvGoodsReceiptItemDaoHibernate() {
	    super(InvGoodsReceiptItem.class);
    }
	
	@Override
    public List<InvGoodsReceiptItem> findByInvGoodReceipt(Long id) {
		String hsql = "select o from InvGoodsReceiptItem o where 1=1 ";
		final Map<String, Object> params = new HashMap<String, Object>();
		hsql += " and o.invGoodsReceipt.id = :id";
		params.put("id", id);
		hsql += " order by o.id";
		Query queryObj = getSession().createQuery(hsql);
		queryObj.setProperties(params);
		return queryObj.list();
	} 
	
}
