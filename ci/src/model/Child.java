package model;

public class Child {
    
    private String name;    //Àà±ðÃû³Æ
   
    private String age;
    private String tiwen;
    private String tizhong;
    private String bmi;
    private String shengao;
	
	public String getTiwen() {
		return tiwen;
	}
	public void setTiwen(String tiwen) {
		this.tiwen = tiwen;
	}
	public String getTizhong() {
		return tizhong;
	}
	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBMI(String bMI) {
		this.bmi = bMI;
	}
	public String getShengao() {
		return shengao;
	}
	public void setShengao(String shengao) {
		this.shengao = shengao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setBirth(String birth) {
		this.age = birth;
	}
	

	@Override
	public String toString() {
		return "Child [name=" + name + ", age=" + age + ", tiwen=" + tiwen
				+ ", tizhong=" + tizhong + ", BMI=" + bmi + ", shengao="
				+ shengao + "]";
	}
	public Child(String name, String birth, String tiwen, String tizhong,
			String BMI, String shengao) {
		super();
		this.name = name;
	
		this.age = birth;
		this.tiwen = tiwen;
		this.tizhong = tizhong;
		this.bmi = BMI;
		this.shengao = shengao;
	}
	

    
} 