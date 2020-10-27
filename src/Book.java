import java.util.*;

public class Book {

	//변수 설정
	private int adminnum, count, checknum, selectnum;
	private String namecode;
	Scanner sc = new Scanner(System.in);
	ArrayList<Person> people;   
	private String regExp;


	//생성자 생성 완료, 초깃값 설정
	public Book() {
		adminnum = 0;
		checknum = 0;
		people = new ArrayList<>();
		count =5;
		regExp = "^[0-9]+$";
		data();
	}

	//정보 입력 메소드
	public void add() {
		int checknum =0 ;
		while(true) {
			people.add(new Person());

			//이름을 입력하는 반복문
			while(true) {
				System.out.print("이름을 입력하세요.>>  ");
				people.get(count).setName(sc.next());
				if(people.get(count).getName().length() < 3) {
					System.out.println("3글자 이상 입력하셔야 합니다. 다시 입력하세요.");
				}
				for(int i = 0; i<people.get(count).getName().length();i++) {
					char ch = people.get(count).getName().charAt(i);
					if(Character.isDigit(ch) == true) { 
						System.out.println("숫자가 입력되었습니다.다시 입력하세요.");
						checknum = 1;
						break;
					}
				}
				if(checknum == 1) {
					checknum = 0;
					continue;
				}
				if(checknum == 0) {
					System.out.println("입력되었습니다.");
					break;
				}
			}

			//나이를 입력하는 반복문 try-catch문을 통해 int 타입에 문자 데이터 타입이 입력되었을 때 오류를 처리했습니다.
			while(true) {
				try {
					System.out.print("나이를 입력하세요.>>  ");
					people.get(count).setAge(sc.nextInt());   
					System.out.println("입력되었습니다.");
					break;
				}
				catch(InputMismatchException e) {  
					sc = new Scanner(System.in);
					System.out.println("숫자만 입력 가능합니다. 다시 입력하세요.");
				}
			}

			//전화번호를 입력하는 반목문
			while(true) {
				System.out.println("전화번호를 010과 (-) 입력없이 8자리로 입력하세요.  ");
				people.get(count).setPhone(sc.next());

				/*문자가 입력되었을 때 리턴시키는 if문. int타입으로 정보를 받게 되면 맨 앞에 0을 받을 수 없기 때문에, 
            String타입으로 정보를 받았습니다.*/
				if(!people.get(count).getPhone().matches(regExp)) { 
					System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
					continue;
				}

				//8자 이상 숫자를 입력 시 리턴시키는 if문.
				else if(people.get(count).getPhone().length() > 8) {
					System.out.println("8자리 이상 입력하셨습니다. 다시 입력하세요.");   
					continue;
				}

				else if(people.get(count).getPhone().length() < 8) {
					System.out.println("8자리 이하로 입력하셨습니다. 다시 입력하세요.");   
					continue;
				}

				//ArrayList의 첫 번째 객체를 받았을 때 입력받는 if문.
				else if(count == 0) {
					System.out.println("입력되었습니다.");
					break;
				}

				//ArrayList에 등록되어 있는 번호와 새로 입력한 번호를 대조하는 if문.
				else if(count != 0) {
					for(int i = 0; i<count;i++) {
						if(people.get(count).getPhone().equals(people.get(i).getPhone())) {
							checknum = 1;
						}
					}
				}
				if(checknum == 1) {
					System.out.println("이미 등록된 번호입니다. 다시 입력하세요.");
					checknum = 0;
					continue;
				}
				System.out.println("입력되었습니다.");
				people.get(count).setAdminNum(getAdmiNnum());
				people.get(count).setAdminName();
				break;
			}
			while(true) {
				System.out.println("과목명을 선택해주세요.");
				System.out.println("(1) Java");
				System.out.println("(2) C언어");
				System.out.println("(3) Python");
				System.out.println("(4) 미정");
				int selectnum = sc.nextInt();

				if(selectnum == 1) {
					people.get(count).setKclass("Java");
					System.out.println("입력되었습니다.");
					break;
				}
				else if(selectnum == 2) {
					people.get(count).setKclass("C언어");
					System.out.println("입력되었습니다.");
					break;            
				}
				else if(selectnum == 3) {
					people.get(count).setKclass("Python");
					System.out.println("입력되었습니다.");
					break;
				}
				else if(selectnum == 4) {
					people.get(count).setKclass("미정");
					System.out.println("입력되었습니다.");
					break;
				}else {
					continue;
				}
			}
			count++;

			while(true) {
				System.out.println("추가로 입력하시겠습니까? 네/아니오");
				String answer = sc.next();

				if(answer.equals("네")) {
					break;
				}
				if (answer.equals("아니오")) {
					return;
				}else
				{
					System.out.println("네/아니오로만 입력가능합니다");
					continue;
				}
			}
		}
	}

	//정보를 수정하는 메소드입니다.
	public void modify() {
		while(true) {
			int temp = 0;
			String selectname;
			int peoplecount = 0;
			System.out.println("수정하실 자료의 이름을 입력하세요. (이전 메뉴로 돌아가시려면, 0을 눌러주세요.)");
			selectname = sc.next();
			if(selectname.equals("0")) {
				break;
			}
			System.out.println("No\t 이름\t 나이\t 전화번호        작성자\t 과목명");                  
			System.out.println("------------------------------------------------------------");

			for (int i = 0; i < people.size(); i++) { 
				if(people.get(i).getName().equals(selectname)) { //관리자의 권한 번호와 정보를 입력한 작성자 번호는 대조하는 if문.
					String Ph = people.get(i).getPhone();
					System.out.println(++peoplecount+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ namecode +"\t|" +people.get(i).getKclass());
					temp = i;
				}
			}

			if(peoplecount >1) {
				while(true) {
					System.out.println("동일인물이 있습니다. 전화번호를 입력해주세요.");
					String newphone = sc.next();
					for(int j = 0; j<people.size();j++) {
						if(people.get(j).getName().equals(selectname) && people.get(j).getPhone().equals(newphone)) {
							if(!(people.get(j).getAdminNum() <= getAdmiNnum())) {
								System.out.println("현재 로그인한 권한자는 수정할 수 없습니다.");
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
				System.out.println("입력하신 이름의 정보가 없습니다.");
				return;
			}
			else if(peoplecount == 1) {
				if(people.get(temp).getAdminNum() > getAdmiNnum()) {
					System.out.println("현재 로그인한 권한자는 수정할 수 없습니다.");
					return;
				}
			}

			System.out.println("메뉴");
			System.out.println("(1) 이름 수정");
			System.out.println("(2) 나이 수정");
			System.out.println("(3) 전화번호 수정");
			System.out.println("(4) 과목 수정");
			System.out.println("(5) 이름 입력창으로 돌아가기");

			selectnum = sc.nextInt();

			if(selectnum == 1) {
				while(true) {
					int checknum = 0;
					String newname;
					System.out.println("변경하실 이름를 입력하세요.(기존 이름 정보: "+people.get(temp).getName()+")");
					newname = sc.next();

					if(newname.length() < 3) {
						System.out.println("3글자 이상 입력하셔야 합니다. 다시 입력하세요.");
						continue;
					}
					
					for(int i = 0; i<newname.length();i++) {
						char ch = newname.charAt(i);
						if(Character.isDigit(ch) == true) { 
							System.out.println("숫자가 입력되었습니다.다시 입력하세요.");
							checknum = 1;
							break;
						}
					}
					if(checknum == 1) {
						continue;
					}
					if(checknum == 0) {
						if( people.get(temp).getName().equals(newname)) {
							System.out.println("기존의 나이와 동일하게 입력되었습니다. 다시 입력하시겠습니까? 네/아니오");
							String answer = sc.next();
							if (answer.equals("아니오")) {
								System.out.println("수정되었습니다.");
								return;
							}
							else if(answer.equals("네")) {
								continue;
							}
						}
						else {
							people.get(temp).setName(newname);
							System.out.println("입력되었습니다.");
							return;
						}
					}
				}
			}
			else if(selectnum == 2) {
				while(true) {
					int age = 0;
					System.out.println("변경하실 나이를 입력하세요.(기존 나이 정보: "+people.get(temp).getAge()+")");
					age = sc.nextInt();
					if(age == people.get(temp).getAge()) {
						System.out.println("기존의 나이와 동일하게 입력되었습니다. 다시 입력하시겠습니까? 네/아니오");
						String answer = sc.next();
						if (answer.equals("아니오")) {
							System.out.println("수정되었습니다.");
							break;
						}
						else if(answer.equals("네")) {
							continue;
						}
					}
					else {
						people.get(temp).setAge(age);
						System.out.println("수정되었습니다.");
						break;
					}
				}
				break;
			}

			else if(selectnum == 3) {
				while(true) {
					System.out.println("전화번호를 010과 (-) 입력없이 8자리로 입력하세요.(기존 전화번호: "+people.get(temp).getPhone()+")");
					String newnum = sc.next();

					if(!newnum.matches(regExp)) {
						System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
						continue;
					}
					else if(newnum.length() > 8) {
						System.out.println("8자리 이상 입력하셨습니다. 다시 입력하세요.");   
						continue;
					}
					else if(newnum.equals(people.get(temp).getPhone())) {
						System.out.println("기존의 번호와 동일하게 입력되었습니다. 다시 입력하시겠습니까? 네/아니오");
						String answer = sc.next();
						if (answer.equals("아니오")) {
							people.get(checknum-1).setPhone(newnum);
							System.out.println("수정되었습니다.");
							break;
						}
						else if(answer.equals("네")) {
							continue;
						}
					}
					people.get(temp).setPhone(newnum);
					System.out.println("수정되었습니다.");
					break;
				}
				break;
			}
			else if(selectnum == 4) {

				System.out.println("수정하실 과목을 선택해주세요.(기존 과목: "+people.get(temp).getKclass()+")");
				System.out.println("(1) Java");
				System.out.println("(2) C언어");
				System.out.println("(3) Python");
				System.out.println("(4) 미정");
				System.out.println("(5) 이전 메뉴로 돌아가기");
				int selectnum = sc.nextInt();

				if(selectnum == 1) {
					people.get(temp).setKclass("Java");
					System.out.println("변경되었습니다.");
					break;
				}

				else if(selectnum == 2) {
					people.get(temp).setKclass("C언어");
					System.out.println("변경되었습니다.");
					break;
				}
				else if(selectnum == 3) {
					people.get(temp).setKclass("Python");
					System.out.println("변경되었습니다.");
					break;
				}
				else if(selectnum == 4)  {
					people.get(temp).setKclass("미정");
					System.out.println("변경되었습니다.");
					break;
				}
			}
			else if(selectnum == 5) {

			}

		}
	}

	//정보를 검색하는 메소드
	public void search() {
		int count = 1;
		for(;;) {
			try {
				System.out.println("\n\n");
				System.out.println("――――――――――――――――――――――――");
				System.out.println("         SEARCH");
				System.out.println("――――――――――――――――――――――――");

				System.out.println("(1) 이름으로 검색");
				System.out.println("(2) 나이로 검색");
				System.out.println("(3) 전화번호로 검색");
				System.out.println("(4) 뒤로 가기");
				System.out.println("――――――――――――――――――――――――");

				System.out.print("▶원하시는 메뉴선택 : ");

				selectnum = sc.nextInt();

				if (selectnum == 1) {
					System.out.print("▶이름 입력 : ");
					String sreachname = sc.next();//이름입력받기
					System.out.println("No\t 이름\t 나이\t 전화번호        작성자\t 과목명");                  
					System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
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
							System.out.println("※검색결과 없음※");
							break;
						}
					} //for
				}//if (selectnum == 1)


				if (selectnum == 2) {
					count = 1;
					System.out.print("▶나이 입력 : ");
					int srAge = sc.nextInt();//나이입력받기
					System.out.println("No\t 이름\t 나이\t 전화번호        작성자\t 과목명");                  
					System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
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
							System.out.println("※검색결과 없음※");
							break;
						}
					} //for
				}// if (selectnum == 2)

				if (selectnum == 3) {
					count = 1;
					String srPhone;

					while(true) {
						System.out.print("▶전화번호 입력(뒤4자리를 입력해주세요) : ");
						srPhone = sc.next();//전화번호입력받기

						if(!srPhone.matches(regExp)) { //문자입력했을때 다시입력하게 처리
							System.out.println("※숫자만 입력 가능합니다. 다시 입력해주세요※");
							continue;
						}else if (srPhone.length() != 4) { //길이가 4가 아닐경우 다시 입력하게 처리
							System.out.println("※네자리를 입력해주세요※");
							continue;
						}else  {
							break;
						}
					}//while(True)

					System.out.println("No\t 이름\t 나이\t 전화번호        작성자\t 과목명");                  
					System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
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
							System.out.println("※검색결과 없음※");
							break;
						}
					} //for
				}//if (selectnum == 3)


				if (selectnum ==4) {
					continue;
				}




				else {//1~3아닐 경우 다시입력
					System.out.println("※다시입력해주세요※");
				}
				//menu if문 종료


			} catch (InputMismatchException  e) {//문자입력시 오류처리
				sc = new Scanner(System.in);
				System.out.println("※숫자만 입력 가능합니다. 다시 입력해주세요※");
			}
		}
	}

	//입력된 정보를 전체 출력하는 메소드
	public void print() {
		System.out.println("(1) 순번별 출력");
		System.out.println("(2) 과목별 출력");
		int tmpselect = sc.nextInt();
		if(tmpselect == 1) {
			System.out.println("\n\n");
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("                     Phone List                           ");
			System.out.println("No\t 이름\t 나이\t 전화번호        작성자\t 과목명");
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

			for (int i = 0; i < people.size(); i++) {
				String Ph = people.get(i).getPhone();
				System.out.println((i+1)+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" +people.get(i).getKclass());

			}
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		}
		else if(tmpselect ==2){
			System.out.println("\n\n");
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("                     Phone List                           ");
			System.out.println("과목명\t No\t 이름\t 나이\t 전화번호        작성자\t ");
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

			int count =1;
			for (int i = 0; i < people.size(); i++) {
				if(people.get(i).getKclass().equals("Java")) {
					String Ph = people.get(i).getPhone();
					System.out.println(people.get(i).getKclass()+"\t"+count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" );
					count++;
				}
			} 
			count =1;
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			for (int i = 0; i < people.size(); i++) {
				if(people.get(i).getKclass().equals("C언어")) {
					String Ph = people.get(i).getPhone();
					System.out.println(people.get(i).getKclass()+"\t"+count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" );
					count++;         }
			}
			count =1;
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			for (int i = 0; i < people.size(); i++) {
				if(people.get(i).getKclass().equals("Python")) {
					String Ph = people.get(i).getPhone();
					System.out.println(people.get(i).getKclass()+"\t"+count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" );
					count++;            }
			}
			count =1;
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			for (int i = 0; i < people.size(); i++) {
				if(people.get(i).getKclass().equals("미정")) {
					String Ph = people.get(i).getPhone();
					System.out.println(people.get(i).getKclass()+"\t"+count+"\t" +people.get(i)+(Ph.substring(0,4))+ "-" +(Ph.substring(4,8))+"|"+ people.get(i).getAdminName() +"\t|" );
					count++;            }
			}
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		}
	}

	//정보를 삭제하는 메소드
	public void delete(    ) {
		String deletename;
		System.out.print("▶삭제할 사람의 이름을 입력하세요.");
		deletename = sc.next();
		for (int i = 0; i < people.size(); i++) {
			if(people.get(i).getName().equals(deletename)) {
				if(people.get(i).getAdminNum() <= getAdmiNnum()) {
					people.remove(i);
				}else {
					System.out.println("※해당 권한이 없습니다※");
				}
			}
		}
	}

	//데이터 메소드
	public void data() {
		people.add(new Person());
		people.get(0).setName("정희석");
		people.get(0).setAge(29);
		people.get(0).setPhone("26633818");
		people.get(0).setKclass("Java");
		people.get(0).setAdminNum(2);
		people.get(0).setAdminName();
		people.add(new Person());
		people.get(1).setName("정해준");
		people.get(1).setAge(27);
		people.get(1).setPhone("12345678");
		people.get(1).setKclass("C언어");
		people.get(1).setAdminNum(2);
		people.get(1).setAdminName();
		people.add(new Person());
		people.get(2).setName("김재현");
		people.get(2).setAge(25);
		people.get(2).setPhone("87654321");
		people.get(2).setKclass("Python");
		people.get(2).setAdminNum(2);
		people.get(2).setAdminName();
		people.add(new Person());
		people.get(3).setName("강성연");
		people.get(3).setAge(29);
		people.get(3).setPhone("10041004");
		people.get(3).setKclass("미정");
		people.get(3).setAdminNum(2);
		people.get(3).setAdminName();
		people.add(new Person());
		people.get(4).setName("전예린");
		people.get(4).setAge(24);
		people.get(4).setPhone("06060606");
		people.get(4).setKclass("Java");
		people.get(4).setAdminNum(2);
		people.get(4).setAdminName();
	}

	//권한 번호 출력
	public int getAdmiNnum() {
		return adminnum;
	}
	//권한 번호 입력
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