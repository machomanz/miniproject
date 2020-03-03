package product_DTO;

public class ProductBean {
	private String product_code;
	private String product_name;
	private int product_price;
	private String category;
	private String sell_id;
	private String product_img;

	public String getProduct_code() {
		return product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public String getCategory() {
		return category;
	}

	public String getSell_id() {
		return sell_id;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setSell_id(String sell_id) {
		this.sell_id = sell_id;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	@Override
	public String toString() {
		return "ProductBean [product_code=" + product_code + ", product_name=" + product_name + ", product_price="
				+ product_price + ", category=" + category + ", sell_id=" + sell_id + ", product_img=" + product_img
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((product_code == null) ? 0 : product_code.hashCode());
		result = prime * result + ((product_img == null) ? 0 : product_img.hashCode());
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result + product_price;
		result = prime * result + ((sell_id == null) ? 0 : sell_id.hashCode());
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
		ProductBean other = (ProductBean) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (product_code == null) {
			if (other.product_code != null)
				return false;
		} else if (!product_code.equals(other.product_code))
			return false;
		if (product_img == null) {
			if (other.product_img != null)
				return false;
		} else if (!product_img.equals(other.product_img))
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (product_price != other.product_price)
			return false;
		if (sell_id == null) {
			if (other.sell_id != null)
				return false;
		} else if (!sell_id.equals(other.sell_id))
			return false;
		return true;
	}

}
