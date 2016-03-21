package com.sogeti.upm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.upm.dao.LoginDAO;
import com.sogeti.upm.dao.UserDAO;
import com.sogeti.upm.model.User;
import com.sogeti.upm.model.UserOTP;
import com.sogeti.upm.util.OTPUtil;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDAO loginDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean doLogin(String loginId, String password, String otp) {
			User user = userDAO.getUserByLoginId(loginId);
			UserOTP userOTP = loginDAO.getUserOTPByLoginId(loginId);
			if (null!=user && null!=userOTP && null!=password && null!= otp){
				if(password.equals(user.getPassword()) && otp.equals(userOTP.getOtp())){
					
					boolean isExpired = isExpiredOTP(userOTP);
					loginDAO.deleteUserOTP(userOTP);
					if(!isExpired){
						return true;
					}
				}
			}
		return false;
	}
	
	private boolean isExpiredOTP(UserOTP userOTP) {
		Date d1 = new Date();
		Date d2 = userOTP.getDateTime();
		long diff = d1.getTime() - d2.getTime();
		long minDiff = diff/60000;
		
		if(minDiff<=6){
			return false;	
		}
		return true;
	}


	@Override
	public UserOTP generateOTP(String loginId) {
		
		User user = userDAO.getUserByLoginId(loginId);
		if(null==user){
			return null;
		}
		
		UserOTP userOTP = loginDAO.getUserOTPByLoginId(loginId);
		if(null!=userOTP){
			loginDAO.deleteUserOTP(userOTP);
		}
		
		String otp = OTPUtil.genOTP();
		
		userOTP = new UserOTP();
		userOTP.setDateTime(new Date());
		userOTP.setLoginId(loginId);
		userOTP.setOtp(otp);
		loginDAO.createUserOTP(userOTP);
		return userOTP;
	}
	

}
