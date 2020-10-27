import java.util.*;

public class Book {

	//���� ����
	private int adminnum, count, checknum, selectnum;
	private String namecode;
	Scanner sc = new Scanner(System.in);
	ArrayList<Person> people;   
	private String regExp;


	//������ ���� �Ϸ�, �ʱ갪 ����
	public Book() {
		adminnum = 0;
		checknum = 0;
		people = new ArrayList<>();
		count =5;
		regExp = "^[0-9]+$";
		data();
	}

	//���� �Է� �޼ҵ�
	public void add() {
		int checknum =0 ;
		while(true) {
			people.add(new Person());

			//�̸��� �Է��ϴ� �ݺ���
			while(true) {
				System.out.print("�̸��� �Է��ϼ���.>>  ");
				people.get(count).setName(sc.next());
				if(people.get(count).getName().length() < 3) {
					System.out.println("3���� �̻� �Է��ϼž� �մϴ�. �ٽ� �Է��ϼ���.");
				}
				for(int i = 0; i<people.get(count).getName().length();i++) {
					char ch = people.get(count).getName().charAt(i);
					if(Character.isDigit(ch) == true) { 
						System.out.println("���ڰ� �ԷµǾ����ϴ�.�ٽ� �Է��ϼ���.");
						checknum = 1;
						break;
					}
				}
				if(checknum == 1) {
					checknum = 0;
					continue;
				}
				if(checknum == 0) {
					System.out.println("�ԷµǾ����ϴ�.");
					break;
				}
			}

			//���̸� �Է��ϴ� �ݺ��� try-catch���� ���� int Ÿ�Կ� ���� ������ Ÿ���� �ԷµǾ��� �� ������ ó���߽��ϴ�.
			while(true) {
				try {
					System.out.print("���̸� �Է��ϼ���.>>  ");
					people.get(count).setAge(sc.nextInt());   
					System.out.println("�ԷµǾ����ϴ�.");
					break;
				}
				catch(InputMismatchException e) {  
					sc = new Scanner(System.in);
					System.out.println("���ڸ� �Է� �����մϴ�. �ٽ� �Է��ϼ���.");
				}
			}

			//��ȭ��ȣ�� �Է��ϴ� �ݸ�
			while(true) {
				System.out.println("��ȭ��ȣ�� 010�� (-) �Է¾��� 8�ڸ��� �Է��ϼ���.  ");
				people.get(count).setPhone(sc.next());

				/*���ڰ� �ԷµǾ��� �� ���Ͻ�Ű�� if��. intŸ������ ������ �ް� �Ǹ� �� �տ� 0�� ���� �� ���� ������, 
            StringŸ������ ������ �޾ҽ��ϴ�.*/
				if(!people.get(count).getPhone().matches(regExp)) { 
					System.out.println("���ڸ� �Է� �����մϴ�. �ٽ� �Է����ּ���.");
					continue;
				}

				//8�� �̻� ���ڸ� �Է� �� ���Ͻ�Ű�� if��.
				else if(people.get(count).getPhone().length() > 8) {
					System.out.println("8�ڸ� �̻� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");   
					continue;
				}

				else if(people.get(count).getPhone().length() < 8) {
					System.out.println("8�ڸ� ���Ϸ� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");   
					continue;
				}

				//ArrayList�� ù ��° ��ü�� �޾��� �� �Է¹޴� if��.
				else if(count == 0) {
					System.out.println("�ԷµǾ����ϴ�.");
					break;
				}

				//ArrayList�� ��ϵǾ� �ִ� ��ȣ�� ���� �Է��� ��ȣ�� �����ϴ� if��.
				else if(count != 0) {
					for(int i = 0; i<count;i++) {
						if(people.get(count).getPhone().equals(people.get(i).getPhone())) {
							checknum = 1;
						}
					}
				}
				if(checknum == 1) {
					System.out.println("�̹� ��ϵ� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
					checknum = 0;
					continue;
				}
				System.out.println("�ԷµǾ����ϴ�.");
				people.get(count).setAdminNum(getAdmiNnum());
				people.get(count).setAdminName();
				break;
			}
			while(true) {
				System.out.println("������� �������ּ���.");
				System.out.println("(1) Java");
				System.out.println("(2) C���");
				System.out.println("(3) Python");
				System.out.println("(4) ����");
				int selectnum = sc.nextInt();

				if(selectnum == 1) {
					people.get(count).setKclass("Java");
					System.out.println("�ԷµǾ����ϴ�.");
					break;
				}
				else if(selectnum == 2) {
					people.get(count).setKclass("C���");
					System.out.println("�ԷµǾ����ϴ�.");
					break;            
				}
				else if(selectnum == 3) {
					people.get(count).setKclass("Python");
					System.out.println("�ԷµǾ����ϴ�.");
					break;
				}
				else if(selectnum == 4) {
					people.get(count).setKclass("����");
					System.out.println("�ԷµǾ����ϴ�.");
					break;
				}else {
					continue;
				}
			}
			count++;

			while(true) {
				System.out.println("�߰��� �Է��Ͻðڽ��ϱ�? ��/�ƴϿ�");
				String answer = sc.next();

				if(answer.equals("��")) {
					break;
				}
				if (answer.equals("�ƴϿ�")) {
					return;
				}else
				{
					System.out.println("��/�ƴϿ��θ� �Է°����մϴ�");
					continue;
				}
			}
		}
	}

	//������ �����ϴ� �޼ҵ��Դϴ�.
	public void modify() {
		while(true) {
			int temp = 0;
			String selectname;
			int peoplecount = 0;
			System.out.println("�����Ͻ� �ڷ��� �̸��� �Է��ϼ���. (���� �޴��� ���ư��÷���, 0�� �����ּ���.)");
			selectname = sc.next();
			if(selectname.equals("0")) {
				break;
			}
			System.out.println("No\t �̸�\t ����\t ��ȭ��ȣ        �ۼ���\t �����");                  
			System.out.println("------------------------------------------------------------");

			for (int i = 0; i < people.size(); i++) { 
				if(people.get(i).getName().equals(selectname)) { //�������� ���� ��ȣ�� ������ �Է��� �ۼ��� ��ȣ�� �����ϴ� if��.
					String Ph = people.get(i).getPhone();
					System.out.println(++peoplecount+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ namecode +"\t|" +people.get(i).getKclass());
					temp = i;
				}
			}

			if(peoplecount >1) {
				while(true) {
					System.out.println("�����ι��� �ֽ��ϴ�. ��ȭ��ȣ�� �Է����ּ���.");
					String newphone = sc.next();
					for(int j = 0; j<people.size();j++) {
						if(people.get(j).getName().equals(selectname) && people.get(j).getPhone().equals(newphone)) {
							if(!(people.get(j).getAdminNum() <= getAdmiNnum())) {
								System.out.println("���� �α����� �����ڴ� ������ �� �����ϴ�.");
								peoplecount = 0;
								return;
							}
							people.get(j).setPhone(newphone);
							temp = j;
							peoplecount = 1;
							break;
						}
					}
					break;
				}
			}
			else if(peoplecount == 0) {
				System.out.println("�Է��Ͻ� �̸��� ������ �����ϴ�.");
				return;
			}
			else if(peoplecount == 1) {
				if(people.get(temp).getAdminNum() > getAdmiNnum()) {
					System.out.println("���� �α����� �����ڴ� ������ �� �����ϴ�.");
					return;
				}
			}

			System.out.println("�޴�");
			System.out.println("(1) �̸� ����");
			System.out.println("(2) ���� ����");
			System.out.println("(3) ��ȭ��ȣ ����");
			System.out.println("(4) ���� ����");
			System.out.println("(5) �̸� �Է�â���� ���ư���");

			selectnum = sc.nextInt();

			if(selectnum == 1) {
				while(true) {
					int checknum = 0;
					String newname;
					System.out.println("�����Ͻ� �̸��� �Է��ϼ���.(���� �̸� ����: "+people.get(temp).getName()+")");
					newname = sc.next();

					if(newname.length() < 3) {
						System.out.println("3���� �̻� �Է��ϼž� �մϴ�. �ٽ� �Է��ϼ���.");
						continue;
					}
					
					for(int i = 0; i<newname.length();i++) {
						char ch = newname.charAt(i);
						if(Character.isDigit(ch) == true) { 
							System.out.println("���ڰ� �ԷµǾ����ϴ�.�ٽ� �Է��ϼ���.");
							checknum = 1;
							break;
						}
					}
					if(checknum == 1) {
						continue;
					}
					if(checknum == 0) {
						if( people.get(temp).getName().equals(newname)) {
							System.out.println("������ ���̿� �����ϰ� �ԷµǾ����ϴ�. �ٽ� �Է��Ͻðڽ��ϱ�? ��/�ƴϿ�");
							String answer = sc.next();
							if (answer.equals("�ƴϿ�")) {
								System.out.println("�����Ǿ����ϴ�.");
								return;
							}
							else if(answer.equals("��")) {
								continue;
							}
						}
						else {
							people.get(temp).setName(newname);
							System.out.println("�ԷµǾ����ϴ�.");
							return;
						}
					}
				}
			}
			else if(selectnum == 2) {
				while(true) {
					int age = 0;
					System.out.println("�����Ͻ� ���̸� �Է��ϼ���.(���� ���� ����: "+people.get(temp).getAge()+")");
					age = sc.nextInt();
					if(age == people.get(temp).getAge()) {
						System.out.println("������ ���̿� �����ϰ� �ԷµǾ����ϴ�. �ٽ� �Է��Ͻðڽ��ϱ�? ��/�ƴϿ�");
						String answer = sc.next();
						if (answer.equals("�ƴϿ�")) {
							System.out.println("�����Ǿ����ϴ�.");
							break;
						}
						else if(answer.equals("��")) {
							continue;
						}
					}
					else {
						people.get(temp).setAge(age);
						System.out.println("�����Ǿ����ϴ�.");
						break;
					}
				}
				break;
			}

			else if(selectnum == 3) {
				while(true) {
					System.out.println("��ȭ��ȣ�� 010�� (-) �Է¾��� 8�ڸ��� �Է��ϼ���.(���� ��ȭ��ȣ: "+people.get(temp).getPhone()+")");
					String newnum = sc.next();

					if(!newnum.matches(regExp)) {
						System.out.println("���ڸ� �Է� �����մϴ�. �ٽ� �Է����ּ���.");
						continue;
					}
					else if(newnum.length() > 8) {
						System.out.println("8�ڸ� �̻� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");   
						continue;
					}
					else if(newnum.equals(people.get(temp).getPhone())) {
						System.out.println("������ ��ȣ�� �����ϰ� �ԷµǾ����ϴ�. �ٽ� �Է��Ͻðڽ��ϱ�? ��/�ƴϿ�");
						String answer = sc.next();
						if (answer.equals("�ƴϿ�")) {
							people.get(checknum-1).setPhone(newnum);
							System.out.println("�����Ǿ����ϴ�.");
							break;
						}
						else if(answer.equals("��")) {
							continue;
						}
					}
					people.get(temp).setPhone(newnum);
					System.out.println("�����Ǿ����ϴ�.");
					break;
				}
				break;
			}
			else if(selectnum == 4) {

				System.out.println("�����Ͻ� ������ �������ּ���.(���� ����: "+people.get(temp).getKclass()+")");
				System.out.println("(1) Java");
				System.out.println("(2) C���");
				System.out.println("(3) Python");
				System.out.println("(4) ����");
				System.out.println("(5) ���� �޴��� ���ư���");
				int selectnum = sc.nextInt();

				if(selectnum == 1) {
					people.get(temp).setKclass("Java");
					System.out.println("����Ǿ����ϴ�.");
					break;
				}

				else if(selectnum == 2) {
					people.get(temp).setKclass("C���");
					System.out.println("����Ǿ����ϴ�.");
					break;
				}
				else if(selectnum == 3) {
					people.get(temp).setKclass("Python");
					System.out.println("����Ǿ����ϴ�.");
					break;
				}
				else if(selectnum == 4)  {
					people.get(temp).setKclass("����");
					System.out.println("����Ǿ����ϴ�.");
					break;
				}
			}
			else if(selectnum == 5) {

			}

		}
	}

	//������ �˻��ϴ� �޼ҵ�
	public void search() {
		int count = 1;
		for(;;) {
			try {
				System.out.println("\n\n");
				System.out.println("������������������������������������������������");
				System.out.println("         SEARCH");
				System.out.println("������������������������������������������������");

				System.out.println("(1) �̸����� �˻�");
				System.out.println("(2) ���̷� �˻�");
				System.out.println("(3) ��ȭ��ȣ�� �˻�");
				System.out.println("(4) �ڷ� ����");
				System.out.println("������������������������������������������������");

				System.out.print("�����Ͻô� �޴����� : ");

				selectnum = sc.nextInt();

				if (selectnum == 1) {
					System.out.print("���̸� �Է� : ");
					String sreachname = sc.next();//�̸��Է¹ޱ�
					System.out.println("No\t �̸�\t ����\t ��ȭ��ȣ        �ۼ���\t �����");                  
					System.out.println("����������������������������������������������������������������������������������������������������������������");
					{
						for (int i = 0; i < people.size(); i++) {
							if (sreachname.equals(people.get(i).getName())) {
								String Ph = people.get(i).getPhone();
								System.out.println(count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ namecode +"\t|" +people.get(i).getKclass());
								checknum = 1;
								count++;
								continue;
							}
						}
						if(checknum == 1) {
							checknum = 0;
							break;
						}
						else if(checknum == 0) {
							System.out.println("�ذ˻���� ������");
							break;
						}
					} //for
				}//if (selectnum == 1)


				if (selectnum == 2) {
					count = 1;
					System.out.print("������ �Է� : ");
					int srAge = sc.nextInt();//�����Է¹ޱ�
					System.out.println("No\t �̸�\t ����\t ��ȭ��ȣ        �ۼ���\t �����");                  
					System.out.println("����������������������������������������������������������������������������������������������������������������");
					{
						for (int i = 0; i < people.size(); i++) {
							if (srAge==(people.get(i).getAge())) {
								String Ph = people.get(i).getPhone();
								System.out.println(count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" +people.get(i).getKclass());
								checknum = 1;
								count++;
								continue;
							}
						}
						if(checknum == 1) {
							checknum = 0;
							break;
						}
						else if(checknum == 0) {
							System.out.println("�ذ˻���� ������");
							break;
						}
					} //for
				}// if (selectnum == 2)

				if (selectnum == 3) {
					count = 1;
					String srPhone;

					while(true) {
						System.out.print("����ȭ��ȣ �Է�(��4�ڸ��� �Է����ּ���) : ");
						srPhone = sc.next();//��ȭ��ȣ�Է¹ޱ�

						if(!srPhone.matches(regExp)) { //�����Է������� �ٽ��Է��ϰ� ó��
							System.out.println("�ؼ��ڸ� �Է� �����մϴ�. �ٽ� �Է����ּ����");
							continue;
						}else if (srPhone.length() != 4) { //���̰� 4�� �ƴҰ�� �ٽ� �Է��ϰ� ó��
							System.out.println("�س��ڸ��� �Է����ּ����");
							continue;
						}else  {
							break;
						}
					}//while(True)

					System.out.println("No\t �̸�\t ����\t ��ȭ��ȣ        �ۼ���\t �����");                  
					System.out.println("����������������������������������������������������������������������������������������������������������������");
					{
						for (int i = 0; i < people.size(); i++) {
							String Ph = people.get(i).getPhone();
							if (srPhone.equals(Ph.substring(4,8))) {
								System.out.println(count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" +people.get(i).getKclass());
								checknum = 1;
								count++;
								continue;
							}
						}
						if(checknum == 1) {
							checknum = 0;
							break;
						}
						else if(checknum == 0) {
							System.out.println("�ذ˻���� ������");
							break;
						}
					} //for
				}//if (selectnum == 3)


				if (selectnum ==4) {
					continue;
				}




				else {//1~3�ƴ� ��� �ٽ��Է�
					System.out.println("�شٽ��Է����ּ����");
				}
				//menu if�� ����


			} catch (InputMismatchException  e) {//�����Է½� ����ó��
				sc = new Scanner(System.in);
				System.out.println("�ؼ��ڸ� �Է� �����մϴ�. �ٽ� �Է����ּ����");
			}
		}
	}

	//�Էµ� ������ ��ü ����ϴ� �޼ҵ�
	public void print() {
		System.out.println("(1) ������ ���");
		System.out.println("(2) ���� ���");
		int tmpselect = sc.nextInt();
		if(tmpselect == 1) {
			System.out.println("\n\n");
			System.out.println("����������������������������������������������������������������������������������������������������������������");
			System.out.println("                     Phone List                           ");
			System.out.println("No\t �̸�\t ����\t ��ȭ��ȣ        �ۼ���\t �����");
			System.out.println("����������������������������������������������������������������������������������������������������������������");

			for (int i = 0; i < people.size(); i++) {
				String Ph = people.get(i).getPhone();
				System.out.println((i+1)+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" +people.get(i).getKclass());

			}
			System.out.println("����������������������������������������������������������������������������������������������������������������");
		}
		else if(tmpselect ==2){
			System.out.println("\n\n");
			System.out.println("����������������������������������������������������������������������������������������������������������������");
			System.out.println("                     Phone List                           ");
			System.out.println("�����\t No\t �̸�\t ����\t ��ȭ��ȣ        �ۼ���\t ");
			System.out.println("����������������������������������������������������������������������������������������������������������������");

			int count =1;
			for (int i = 0; i < people.size(); i++) {
				if(people.get(i).getKclass().equals("Java")) {
					String Ph = people.get(i).getPhone();
					System.out.println(people.get(i).getKclass()+"\t"+count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" );
					count++;
				}
			} 
			count =1;
			System.out.println("����������������������������������������������������������������������������������������������������������������");
			for (int i = 0; i < people.size(); i++) {
				if(people.get(i).getKclass().equals("C���")) {
					String Ph = people.get(i).getPhone();
					System.out.println(people.get(i).getKclass()+"\t"+count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" );
					count++;         }
			}
			count =1;
			System.out.println("����������������������������������������������������������������������������������������������������������������");
			for (int i = 0; i < people.size(); i++) {
				if(people.get(i).getKclass().equals("Python")) {
					String Ph = people.get(i).getPhone();
					System.out.println(people.get(i).getKclass()+"\t"+count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" );
					count++;            }
			}
			count =1;
			System.out.println("����������������������������������������������������������������������������������������������������������������");
			for (int i = 0; i < people.size(); i++) {
				if(people.get(i).getKclass().equals("����")) {
					String Ph = people.get(i).getPhone();
					System.out.println(people.get(i).getKclass()+"\t"+count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" );
					count++;            }
			}
			System.out.println("����������������������������������������������������������������������������������������������������������������");
		}
	}

	//������ �����ϴ� �޼ҵ�
	public void delete(    ) {
		String deletename;
		System.out.print("�������� ����� �̸��� �Է��ϼ���.");
		deletename = sc.next();
		for (int i = 0; i < people.size(); i++) {
			if(people.get(i).getName().equals(deletename)) {
				if(people.get(i).getAdminNum() <= getAdmiNnum()) {
					people.remove(i);
				}else {
					System.out.println("���ش� ������ �����ϴ١�");
				}
			}
		}
	}

	//������ �޼ҵ�
	public void data() {
		people.add(new Person());
		people.get(0).setName("����");
		people.get(0).setAge(29);
		people.get(0).setPhone("26633818");
		people.get(0).setKclass("Java");
		people.get(0).setAdminNum(2);
		people.get(0).setAdminName();
		people.add(new Person());
		people.get(1).setName("������");
		people.get(1).setAge(27);
		people.get(1).setPhone("12345678");
		people.get(1).setKclass("C���");
		people.get(1).setAdminNum(2);
		people.get(1).setAdminName();
		people.add(new Person());
		people.get(2).setName("������");
		people.get(2).setAge(25);
		people.get(2).setPhone("87654321");
		people.get(2).setKclass("Python");
		people.get(2).setAdminNum(2);
		people.get(2).setAdminName();
		people.add(new Person());
		people.get(3).setName("������");
		people.get(3).setAge(29);
		people.get(3).setPhone("10041004");
		people.get(3).setKclass("����");
		people.get(3).setAdminNum(2);
		people.get(3).setAdminName();
		people.add(new Person());
		people.get(4).setName("������");
		people.get(4).setAge(24);
		people.get(4).setPhone("06060606");
		people.get(4).setKclass("Java");
		people.get(4).setAdminNum(2);
		people.get(4).setAdminName();
	}

	//���� ��ȣ ���
	public int getAdmiNnum() {
		return adminnum;
	}
	//���� ��ȣ �Է�
	public void setAdminNum(int adminnum) {
		this.adminnum = adminnum;
	}

	public String getNamecode() {
		return namecode;
	}

	public void setNamecode(String namecode) {
		this.namecode = namecode;
	}
}