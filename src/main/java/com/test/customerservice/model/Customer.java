package com.test.customerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;

/**
 * @author Agilan
 */
@Entity
@Table(name = "cust_data")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique identifier of the Customer.", example = "1", required = true, position = 0)
	private Long id;

	@NotBlank
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]{5,10}", message = "length between 5 and 10")
	@ApiModelProperty(notes = "Customer first Name", example = "Agilan", required = true, position = 1)
	@Size(max = 10, min = 5)
	@Column(name = "First_Name", nullable = false)
	private String customerFirstName;

	@NotBlank
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]{5,10}", message = "length between 5 and 10")
	@ApiModelProperty(notes = "Customer Last Name", example = "S", required = true, position = 2)
	@Size(max = 10, min = 5)
	@Column(name = "Last_Name", nullable = false)
	private String customerLastName;
    
	@ApiModelProperty(notes = "Gender", example = "Male/Female", required = true, position = 3)
	@Column(name = "Gender", nullable = false)
	private String customerGender;
    
    @ApiModelProperty(notes = "Date Of Birth", example = "Male/Female", required = true, position = 3)
	@Column(name = "DOB", nullable = false)
	private Date customerDob;
    
    @Pattern(regexp = "/\d{3}/", message = "less or equals to 3 digits allowed")
	@ApiModelProperty(notes = "Customer Age", example = "29", required = true, position = 4)
	@Size(max = 3, min = 1)
	@Column(name = "Age", nullable = false)
	private Integer customerAge;
    
    @Pattern(regexp = "^\\d{10}$", message = "10 digits only allowed")
	@ApiModelProperty(notes = "Customer Phone Number", example = "9345087978", required = true, position = 5)
	@Size(max = 10, min = 10)
	@Column(name = "Phone_Number", nullable = false)
	private Integer customerPhoneNumber;
    
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
    
    public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
    
    public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	public Date getCustomerDob() {
		return customerDob;
	}
    
    public Integer getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(Integer customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
    
     public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

}
