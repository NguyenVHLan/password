package com.kma.at16.service;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Service;
@Service
public class LoginAttemptService {
	private final int MAX_LoginAttempt = 3;
	private static int loginAttempt = 0;
	public LoginAttemptService() {
		super();
		
	}
	public void loginSucceeded() {
        loginAttempt=0;
    }

    public void loginFailed() {
        loginAttempt++;
    }

    public boolean isBlocked() {
    	if (loginAttempt >= MAX_LoginAttempt) {
    		Timer t = new Timer();
    		TimerTask task = new TimerTask() {
    			public void run() {
    				loginAttempt=0;
    			}
    		};
    		t.schedule(task, 10000L);;
    		return true;
    	}
    	else return false;
    }
    
}
