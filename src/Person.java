public class Person {

	//변수 설정
	private String name, phone, kclass;
	private int age, adminnum;
	private String adminname;

	//생성자 생성
	public Person() {
	}

	public String getAdminName() {
		return adminname;
	}

	public void setAdminName( ) {
		if(adminnum == 0) {
			adminname = "일반 사용자";
		}
		else if(adminnum == 1) {
			adminname = "보조 관리자";
		}
		else if(adminnum == 2) {
			adminname = "관리자";
		}
	}

	//이름 출력
	public String getName() {
		return name;
	}

	//이름 입력
	public void setName(String name) {
		this.name = name;
	}

	//전화번호 출력
	public String getPhone() {
		return phone; // 요구 사항에서 숫자만 입력 가능하다고 되어 있어서 수정했습니다.
	}

	//전화번호 입력
	public void setPhone(String phone) {
		this.phone = phone; // 요구 사항에서 숫자만 입력 가능하다고 되어 있어서 수정했습니다.
	}

	//나이 출력
	public int getAge() {
		return age;
	}

	//나이 입력
	public void setAge(int age) {
		this.age = age;
	}

	//권한번호 출력
	public int getAdminNum() {
		return adminnum;
	}

	//권한번호 입력
	public void setAdminNum(int adminnum) {
		this.adminnum = adminnum;
	}

	//반 출력
	public String getKclass() {
		return kclass;
	}
	
	//반 입력
	public void setKclass(String kclass) {
		this.kclass = kclass;
	}

	//입력된 정보 출력
	public String toString() {
		return  "|"+name +"\t"+"|"+   age  +"\t" +"|010-";
	}
}