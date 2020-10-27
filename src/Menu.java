import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

   //���� ����
   Scanner sc = new Scanner(System.in);
   Book book = new Book();
   int selectnum;

   //������ ����
   public Menu() {
   }

   //������ ���õ� �۵� �޼ҵ�
   public void menu() {
      while(true) {
         try {
           System.out.println("\n\n");
            System.out.println("-----------------------");
            System.out.println("                          ��  MAIN  ��");
            System.out.println("(1) ���� �Է�");
            System.out.println("(2) ���� ����");
            System.out.println("(3) ���� �˻�");
            System.out.println("(4) ���� ���");
            System.out.println("(5) ���� ����");
            System.out.println("(6) �α��� �޴��� ���ư���");
            System.out.println("-----------------------");
            System.out.print("���Ͻô� �޴����� : ");
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
               System.out.println("�α��� �޴��� ���ư��ϴ�.");
               break;
            }else {
               System.out.println("�ٽ��Է����ּ���");
            }
         }
         catch (InputMismatchException e) {
            sc = new Scanner(System.in);
            System.out.println("���ڸ� �Է� �����մϴ�. �ٽ� �Է����ּ���.");
            //continue;
         }

      }
   }

}