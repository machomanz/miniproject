package model.dto;

public class SellerBean {
	private String sell_id;
	private String sell_pw;

	public String getSell_id() {
		return sell_id;
	}

	public String getSell_pw() {
		return sell_pw;
	}

	public void setSell_id(String sell_id) {
		this.sell_id = sell_id;
	}

	public void setSell_pw(String sell_pw) {
		this.sell_pw = sell_pw;
	}

	@Override
	public String toString() {
		return "SellerBean [sell_id=" + sell_id + ", sell_pw=" + sell_pw + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sell_id == null) ? 0 : sell_id.hashCode());
		result = prime * result + ((sell_pw == null) ? 0 : sell_pw.hashCode());
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
		SellerBean other = (SellerBean) obj;
		if (sell_id == null) {
			if (other.sell_id != null)
				return false;
		} else if (!sell_id.equals(other.sell_id))
			return false;
		if (sell_pw == null) {
			if (other.sell_pw != null)
				return false;
		} else if (!sell_pw.equals(other.sell_pw))
			return false;
		return true;
	}

}
