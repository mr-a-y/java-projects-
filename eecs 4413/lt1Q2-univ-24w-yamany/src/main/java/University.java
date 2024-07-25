
public class University {
	
	String code;
	String title;
	String province; //ast
	String city;
	
	public University(String code, String title, String area, String city) {
		super();
		this.code = code;
		this.title = title;
		province = area;
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
 
	
	

}
