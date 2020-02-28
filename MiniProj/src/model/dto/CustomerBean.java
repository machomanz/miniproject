package model.dto;

public class CustomerBean {
	private String cust_id;
	private String cust_pw;
	private String cust_tel;
	private String user_addr;
	private String cust_name;

	public String getCust_id() {
		return cust_id;
	}

	public String getCust_pw() {
		return cust_pw;
	}

	public String getCust_tel() {
		return cust_tel;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public void setCust_pw(String cust_pw) {
		this.cust_pw = cust_pw;
	}

	public void setCust_tel(String cust_tel) {
		this.cust_tel = cust_tel;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	@Override
	public String toString() {
		return "CustomerBean [cust_id=" + cust_id + ", cust_pw=" + cust_pw + ", cust_tel=" + cust_tel + ", user_addr="
				+ user_addr + ", cust_name=" + cust_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cust_id == null) ? 0 : cust_id.hashCode());
		result = prime * result + ((cust_name == null) ? 0 : cust_name.hashCode());
		result = prime * result + ((cust_pw == null) ? 0 : cust_pw.hashCode());
		result = prime * result + ((cust_tel == null) ? 0 : cust_tel.hashCode());
		result = prime * result + ((user_addr == null) ? 0 : user_addr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerBean other = (CustomerBean) obj;
		if (cust_id == null) {
			if (other.cust_id != null)
				return false;
		} else if (!cust_id.equals(other.cust_id))
			return false;
		if (cust_name == null) {
			if (other.cust_name != null)
				return false;
		} else if (!cust_name.equals(other.cust_name))
			return false;
		if (cust_pw == null) {
			if (other.cust_pw != null)
				return false;
		} else if (!cust_pw.equals(other.cust_pw))
			return false;
		if (cust_tel == null) {
			if (other.cust_tel != null)
				return false;
		} else if (!cust_tel.equals(other.cust_tel))
			return false;
		if (user_addr == null) {
			if (other.user_addr != null)
				return false;
		} else if (!user_addr.equals(other.user_addr))
			return false;
		return true;
	}
	
	

}
