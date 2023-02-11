/**
 * 
 */
package com.rps.dansmultipro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rudi_
 * Feb 11, 2023
 */

@Entity(name = "TRANSACTION")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	
	@Id
	@Column(unique = true)
	private Long trs_id;
	
	@Column(nullable = false, length = 13)
	private String trs_from_account;
	
	@Column(nullable = false)
	private Date trs_date;
	
	@Column(nullable = false, length = 10)
	@Type(type = "big_decimal")
	private Double trs_amount;
	
	@Column(nullable = false, length = 2)
	private String trs_type;

}
