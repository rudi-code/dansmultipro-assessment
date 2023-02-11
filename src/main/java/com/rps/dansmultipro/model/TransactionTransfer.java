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

//@Entity(name = "TRANSACTION_TRANSFER")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionTransfer {
	
	@Id
	@Column(nullable = false, unique = true)
	private Long trs_id;
	@Column(nullable = false, length = 13)
	private String trs_to_account;
	@Column(nullable = false, length = 2)
	private String trs_status;

}
