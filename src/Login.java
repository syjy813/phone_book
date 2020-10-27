import java.util.*;

public class Login {

	//변수 설정
	Scanner scan = new Scanner(System.in);
	ArrayList<Member> arrmember ;
	Member member;
	private String memid, mempw;
	private int  memad, count, checknum;

	//생성자 생성, 초기값 설정
	public Login() {
		arrmember = new ArrayList<>();
		count =1;
		member = new Member();
		member.setId("admin");
		member.setPassword("1234");
		member.setAdminnum(2);
		arrmember.add(member);
	}

	//회원가입을 수행하는 메소드
	public void addMember() {
		checknum = 0;
		System.out.println("회원가입 페이지 입니다.");
		while(checknum==0) {
			System.out.println("아이디를 입력하세요.");
			memid = scan.next();
			for (int i = 0; i < count; i++) {
				if(arrmember.get(i).getId().equals(memid)) {
					System.out.println("이미 존재하는 ID입니다. 다시 입력하세요.");
					checknum = 1;
					break;
				}
			}
			while(checknum==0) {
				member = new Member();
				member.setId(memid);
				System.out.println("비밀번호를 입력하세요.");
				mempw = scan.next();
				member.setPassword(mempw);

				System.out.println("권한번호를 입력하세요. (일반회원은 0)");
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
				System.out.println("@@@@회원가입 완료@@@@");
				checknum=1;
				break;
			}
		}
	}

	public void changeAdmin() {
		checknum = 0;
		while(checknum==0) {
			System.out.println("ID를 입력하세요.");
			memid = scan.next();
			for (int i = 0; i < arrmember.size(); i++) {
				if(arrmember.get(i).getId().equals(memid)) {
					System.out.println("비밀번호를 입력하세요.");
					mempw = scan.next();
					if(arrmember.get(i).getPassword().equals(mempw)) {
						System.out.println("권한번호를 입력하세요. (일반회원은 0)");
						memad = scan.nextInt();
						if(memad == 2222) {
							arrmember.get(i).setAdminnum(2);
						}else if(memad == 1111) {
							arrmember.get(i).setAdminnum(1);
						}else {
							arrmember.get(i).setAdminnum(0);
						}
						System.out.println("@@@@권한 변경 완료@@@@");
						checknum=1;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
	}
}