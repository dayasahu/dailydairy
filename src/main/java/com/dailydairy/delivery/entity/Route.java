package com.dailydairy.delivery.entity;

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
@Table(name = "Route")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdBy", "createdDate" ,"modifiedBy","modifiedDate"}, allowGetters = true)
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String primaryAgentId;
	private String source;
	private String destination;
	private String secondaryAgentId;
	private String isActive;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryAgentId() {
		return primaryAgentId;
	}

	public void setPrimaryAgentId(String primaryAgentId) {
		this.primaryAgentId = primaryAgentId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSecondaryAgentId() {
		return secondaryAgentId;
	}

	public void setSecondaryAgentId(String secondaryAgentId) {
		this.secondaryAgentId = secondaryAgentId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
