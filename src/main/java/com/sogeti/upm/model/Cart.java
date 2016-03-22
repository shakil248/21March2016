package com.sogeti.upm.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart {
	
	@Id
    @Column(name="cart_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String cartId;
	private String loginId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="cart_detail_id")
	private Address address;
	
	private String cartDetailId;
	private Date createDate;
	private Date updateDate;
	
	

}
