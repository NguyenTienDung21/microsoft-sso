package com.katalon.truetest.authentication

import com.kms.katalon.core.util.KeywordUtil


abstract class AuthenticationProcess implements StepProcess {
	protected boolean isRequired = false;
	private String name;

	public AuthenticationProcess(String name) {
		this(name, false)
	}

	public AuthenticationProcess(String name, boolean isRequired){
		this.name = name
		this.isRequired = isRequired
	}

	protected abstract boolean stepProcess();

	public void execute() {
		KeywordUtil.logInfo("Execute step: ${this.name}, is required step: ${this.isRequired}")
		def boolean result = stepProcess()
		if (this.isRequired == true && result == false) {
			throw StepFailedException("${this.name} failed to executed!")
		}
	}
}