import java.util.*;

public class Login {

	//���� ����
	Scanner scan = new Scanner(System.in);
	ArrayList<Member> arrmember ;
	Member member;
	private String memid, mempw;
	private int  memad, count, checknum;

	//������ ����, �ʱⰪ ����
	public Login() {
		arrmember = new ArrayList<>();
		count =1;
		member = new Member();
		member.setId("admin");
		member.setPassword("1234");
		member.setAdminnum(2);
		arrmember.add(member);
	}

	//ȸ�������� �����ϴ� �޼ҵ�
	public void addMember() {
		checknum = 0;
		System.out.println("ȸ������ ������ �Դϴ�.");
		while(checknum==0) {
			System.out.println("���̵� �Է��ϼ���.");
			memid = scan.next();
			for (int i = 0; i < count; i++) {
				if(arrmember.get(i).getId().equals(memid)) {
					System.out.println("�̹� �����ϴ� ID�Դϴ�. �ٽ� �Է��ϼ���.");
					checknum = 1;
					break;
				}
			}
			while(checknum==0) {
				member = new Member();
				member.setId(memid);
				System.out.println("��й�ȣ�� �Է��ϼ���.");
				mempw = scan.next();
				member.setPassword(mempw);

				System.out.println("���ѹ�ȣ�� �Է��ϼ���. (�Ϲ�ȸ���� 0)");
				memad = scan.nextInt();
				if(memad == 2222) {
					member.setAdminnum(2);
				}else if(memad == 1111) {
					member.setAdminnum(1);
				}else {
					member.setAdminnum(0);
				}
				arrmember.add(member);
				count++;
				System.out.println("@@@@ȸ������ �Ϸ�@@@@");
				checknum=1;
				break;
			}
		}
	}

	public void changeAdmin() {
		checknum = 0;
		while(checknum==0) {
			System.out.println("ID�� �Է��ϼ���.");
			memid = scan.next();
			for (int i = 0; i < arrmember.size(); i++) {
				if(arrmember.get(i).getId().equals(memid)) {
					System.out.println("��й�ȣ�� �Է��ϼ���.");
					mempw = scan.next();
					if(arrmember.get(i).getPassword().equals(mempw)) {
						System.out.println("���ѹ�ȣ�� �Է��ϼ���. (�Ϲ�ȸ���� 0)");
						memad = scan.nextInt();
						if(memad == 2222) {
							arrmember.get(i).setAdminnum(2);
						}else if(memad == 1111) {
							arrmember.get(i).setAdminnum(1);
						}else {
							arrmember.get(i).setAdminnum(0);
						}
						System.out.println("@@@@���� ���� �Ϸ�@@@@");
						checknum=1;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
	}
}