package com.sogeti.upm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_OTP")
public class UserOTP {
	
	@Id
    @Column(name="otp_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String otpId;
	private String loginId;
	private String otp;
	private Date dateTime;
	
	public String getOtpId() {
		return otpId;
	}
	public void setOtpId(String otpId) {
		this.otpId = otpId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
}
