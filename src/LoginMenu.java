import java.util.*;

public class LoginMenu {

	//멤버필드 변수 설정
	Scanner scan  = new Scanner(System.in);
	Login login;
	Menu menu;
	private String loginid, loginpw;
	private int selectnum, checknum;

	//생성자 생성, 초깃값 설정
	public LoginMenu() {
		login = new Login();
		menu = new Menu();
		selectnum = 0;
		checknum = 0;
		logo();
		pageMain();
	}

	//시작 메뉴를 선택하는 메소드
	public void pageMain() {
		while(true) {
			System.out.println();
			System.out.println("1. Login");
			System.out.println("2. 회원가입");
			System.out.println("3. 회원권한변경");
			System.out.println("4. 프로그램 종료");
			selectnum = scan.nextInt();
			if(selectnum ==1 ) {
				pageOne();
				selectnum = 0;
			}
			if(selectnum ==2 ) {
				login.addMember();
			}
			if(selectnum ==3 ) {
				login.changeAdmin();
			}
			if(selectnum ==4 ) {
				break;
			}
		}
	}

	//로그인을 실행하는 메소드
	   public void pageOne() {
		      checknum = 0;
		      while(checknum==0) {
		         System.out.println("ID를 입력하세요.");
		         loginid = scan.next();
		         for (int i = 0; i < login.arrmember.size(); i++) {
		            if(login.arrmember.get(i).getId().equals(loginid)) {
		               System.out.println("비밀번호를 입력하세요.");
		               loginpw = scan.next();
		               if(login.arrmember.get(i).getPassword().equals(loginpw)) {
		                  menu.book.setAdminNum(login.arrmember.get(i).getAdminnum()); //로그인한 사람의 권한 번호를 book 클래스에 부여
		                  menu.book.setNamecode(login.arrmember.get(i).getId());
		                  menu.menu();
		                  checknum=1;
		               }else {
		                  System.out.println("일치하지 않습니다. 다시 시도해주세요.");
		                  checknum=1;
		               }
		            } else {
		               if(i == login.arrmember.size()-1) {
		               System.out.println("일치하지 않습니다. 다시 시도해주세요.");
		               checknum=1;
		               };
		               continue;
		            }
		         }
		      }
		   }

	public void logo() {
		System.out.println("=========================================");
		System.out.println(" &&    &&  &&     &&    &&&&&&&&&&&&&");
		System.out.println(" &&   &&   &&     &&   &&           && ");
		System.out.println(" &&  &&    &&     &&  && &&&&&&&&&&& &&");
		System.out.println(" && &&     &&&   &&&    &&         && ");
		System.out.println(" &&&       &&&&&&&&&    &&         && ");
		System.out.println(" && &&     &&&   &&&    &&         && ");
		System.out.println(" &&  &&    &&     &&   &&           &&");
		System.out.println(" &&   &&   &&     &&  && &&&&&&&&&&& &&");
		System.out.println(" &&    &&  &&     &&  &&&&&&&&&&&&&&&&&");
		System.out.println("=========================================");
		System.out.println();
		System.out.println();
	}
}
