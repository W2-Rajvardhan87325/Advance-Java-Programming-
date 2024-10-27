/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"user", "details"})
@Entity
@Table(name = "orders")
public class Order {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ordDate;
	private String status; // pending, dispatched, delivered, or cancelled
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> details;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
