/**
 * 
 */
package com.rps.dansmultipro.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;

import com.rps.dansmultipro.domain.Role;
import com.rps.dansmultipro.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rudi_
 * Feb 11, 2023
 */

@Entity(name = "ACCOUNT")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	@Column(length = 13, unique = true)
	private String acc_number;
	
	@Column(nullable = false)
	private Long acc_owner;
	
	@Column(nullable = false)
	private Date acc_date_created;
	
	@Column(nullable = false, length = 10)
	@Type(type = "big_decimal")
	private Double acc_balance;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "trs_from_account", referencedColumnName = "acc_number")
	private List<Transaction> transaction;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "trs_to_account", referencedColumnName = "acc_number")
	private List<TransactionTransfer> TransactionTransfer;

}
