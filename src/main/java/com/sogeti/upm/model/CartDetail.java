package com.sogeti.upm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CART_DETAIL")
public class CartDetail {
	
	
	@Id
    @Column(name="cart_detail_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String cartDetailId;
	
	private String cartId;
	private String productId;
	private String productName;
	private String productPrice;
	private Integer quantity;
	private Date createDate;
	private Date updateDate;
	

}
