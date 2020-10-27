import java.util.*;

public class LoginMenu {

	//����ʵ� ���� ����
	Scanner scan  = new Scanner(System.in);
	Login login;
	Menu menu;
	private String loginid, loginpw;
	private int selectnum, checknum;

	//������ ����, �ʱ갪 ����
	public LoginMenu() {
		login = new Login();
		menu = new Menu();
		selectnum = 0;
		checknum = 0;
		logo();
		pageMain();
	}

	//���� �޴��� �����ϴ� �޼ҵ�
	public void pageMain() {
		while(true) {
			System.out.println();
			System.out.println("1. Login");
			System.out.println("2. ȸ������");
			System.out.println("3. ȸ�����Ѻ���");
			System.out.println("4. ���α׷� ����");
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

	//�α����� �����ϴ� �޼ҵ�
	   public void pageOne() {
		      checknum = 0;
		      while(checknum==0) {
		         System.out.println("ID�� �Է��ϼ���.");
		         loginid = scan.next();
		         for (int i = 0; i < login.arrmember.size(); i++) {
		            if(login.arrmember.get(i).getId().equals(loginid)) {
		               System.out.println("��й�ȣ�� �Է��ϼ���.");
		               loginpw = scan.next();
		               if(login.arrmember.get(i).getPassword().equals(loginpw)) {
		                  menu.book.setAdminNum(login.arrmember.get(i).getAdminnum()); //�α����� ����� ���� ��ȣ�� book Ŭ������ �ο�
		                  menu.book.setNamecode(login.arrmember.get(i).getId());
		                  menu.menu();
		                  checknum=1;
		               }else {
		                  System.out.println("��ġ���� �ʽ��ϴ�. �ٽ� �õ����ּ���.");
		                  checknum=1;
		               }
		            } else {
		               if(i == login.arrmember.size()-1) {
		               System.out.println("��ġ���� �ʽ��ϴ�. �ٽ� �õ����ּ���.");
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
