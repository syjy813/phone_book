public class Person {

	//���� ����
	private String name, phone, kclass;
	private int age, adminnum;
	private String adminname;

	//������ ����
	public Person() {
	}

	public String getAdminName() {
		return adminname;
	}

	public void setAdminName( ) {
		if(adminnum == 0) {
			adminname = "�Ϲ� �����";
		}
		else if(adminnum == 1) {
			adminname = "���� ������";
		}
		else if(adminnum == 2) {
			adminname = "������";
		}
	}

	//�̸� ���
	public String getName() {
		return name;
	}

	//�̸� �Է�
	public void setName(String name) {
		this.name = name;
	}

	//��ȭ��ȣ ���
	public String getPhone() {
		return phone; // �䱸 ���׿��� ���ڸ� �Է� �����ϴٰ� �Ǿ� �־ �����߽��ϴ�.
	}

	//��ȭ��ȣ �Է�
	public void setPhone(String phone) {
		this.phone = phone; // �䱸 ���׿��� ���ڸ� �Է� �����ϴٰ� �Ǿ� �־ �����߽��ϴ�.
	}

	//���� ���
	public int getAge() {
		return age;
	}

	//���� �Է�
	public void setAge(int age) {
		this.age = age;
	}

	//���ѹ�ȣ ���
	public int getAdminNum() {
		return adminnum;
	}

	//���ѹ�ȣ �Է�
	public void setAdminNum(int adminnum) {
		this.adminnum = adminnum;
	}

	//�� ���
	public String getKclass() {
		return kclass;
	}
	
	//�� �Է�
	public void setKclass(String kclass) {
		this.kclass = kclass;
	}

	//�Էµ� ���� ���
	public String toString() {
		return  "|"+name +"\t"+"|"+   age  +"\t" +"|010-";
	}
}