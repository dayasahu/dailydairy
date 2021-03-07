package com.dailydairy.delivery.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Vacation")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdBy", "createdDate" ,"modifiedBy","modifiedDate"}, allowGetters = true)
public class Vacation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long customerId;
	private LocalDate startDate;
	private LocalDate endDate;
	
	  @CreatedBy
	  @NotNull
	  @Column(name = "created_by", nullable = false, length = 50, updatable =  false)
	  private String createdBy="NA";

	  @CreatedDate
	  @NotNull
	  @Column(name = "created_date", nullable = false, updatable = false)
	  private LocalDateTime createdDate = LocalDateTime.now();

	  @LastModifiedBy
	  @Column(name = "modified_by", length = 50)
	  private String modifiedBy="NA";

	  @LastModifiedDate
	  @Column(name = "modified_date")
	  private LocalDateTime modifiedDate = LocalDateTime.now();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
