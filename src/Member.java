public class Member {
   
   //���� ����
   private String id;
   private String password;
   private String adminid;
   private int adminnum;

   //������ ����, �ʱ갪 ����
   public Member() {
   }

   //id ���
   public String getId() {
      return id;
   }
   
   //id ����
   public void setId(String id) {
      this.id = id;
   }
   
   public String getAdminid() {
	return adminid;
}

public void setAdminid(String adminid) {
	this.adminid = adminid;
}

//password ���
   public String getPassword() {
      return password;
   }
   
   //password ����
   public void setPassword(String password) {
      this.password = password;
   }
   
   //adminnum ���
   public int getAdminnum() {
      return adminnum;
   }
   
   //adminnum �ο�
   public void setAdminnum(int adminnum) {
      this.adminnum = adminnum;
   }
   
   //Ŭ���� ���� ���
   public String toString() {
      return "id: "+id+", password: "+password+", adminnum: "+adminnum;
   }
}