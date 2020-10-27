import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

   //변수 설정
   Scanner sc = new Scanner(System.in);
   Book book = new Book();
   int selectnum;

   //생성자 생성
   public Menu() {
   }

   //정보와 관련된 작동 메소드
   public void menu() {
      while(true) {
         try {
           System.out.println("\n\n");
            System.out.println("-----------------------");
            System.out.println("                          ☎  MAIN  ☎");
            System.out.println("(1) 정보 입력");
            System.out.println("(2) 정보 수정");
            System.out.println("(3) 정보 검색");
            System.out.println("(4) 정보 출력");
            System.out.println("(5) 정보 삭제");
            System.out.println("(6) 로그인 메뉴로 돌아가기");
            System.out.println("-----------------------");
            System.out.print("원하시는 메뉴선택 : ");
            int selectnum = sc.nextInt();
            if (selectnum ==1) {
               book.add();
            }else if (selectnum ==2) {
               book.modify();
            }else if (selectnum ==3) {
               book.search();
            }else if (selectnum ==4) {
               book.print();
            }else if (selectnum ==5) {
               book.delete();
            }else if (selectnum ==6) {
               System.out.println("로그인 메뉴로 돌아갑니다.");
               break;
            }else {
               System.out.println("다시입력해주세요");
            }
         }
         catch (InputMismatchException e) {
            sc = new Scanner(System.in);
            System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
            //continue;
         }

      }
   }

}