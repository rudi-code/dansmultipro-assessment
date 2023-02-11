/**
 * 
 */
package com.rps.dansmultipro.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rudi_
 * Feb 11, 2023
 */

//@Entity(name = "CUSTOMER")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@Column(nullable = false, unique = true)
	private Long cust_id;
	
	@Column(nullable = false, length = 30)
	private String cust_firstname;
	
	@Column(length = 30)
	private String cust_lastname;
	
	private Date cust_birthdate;
	
	@Column(nullable = false, length = 1)
	private String cust_gender;
	
	@Column(length = 50)
	private String cust_address;
	
	@Column(length = 20)
	private String cust_city;
	
	@Column(length = 5)
	private String cust_postcode;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_owner", referencedColumnName = "cust_id")
	private List<Account> accounts;

}
