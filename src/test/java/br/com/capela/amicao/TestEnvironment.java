package br.com.capela.amicao;

import java.util.HashMap;
import java.util.Map;

import com.google.apphosting.api.ApiProxy;

public class TestEnvironment implements ApiProxy.Environment {
	@Override
	public String getAppId() {
		return "Unit Tests";
	}

	@Override
	public String getVersionId() {
		return "1.0";
	}

	@Override
	public String getRequestNamespace() {
		return "";
	}

	@Override
	public String getAuthDomain() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isLoggedIn() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getEmail() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isAdmin() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return new HashMap<String, Object>();
	}
}
