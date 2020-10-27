public class Member {
   
   //변수 설정
   private String id;
   private String password;
   private String adminid;
   private int adminnum;

   //생성자 생성, 초깃값 설정
   public Member() {
   }

   //id 출력
   public String getId() {
      return id;
   }
   
   //id 설정
   public void setId(String id) {
      this.id = id;
   }
   
   public String getAdminid() {
	return adminid;
}

public void setAdminid(String adminid) {
	this.adminid = adminid;
}

//password 출력
   public String getPassword() {
      return password;
   }
   
   //password 설정
   public void setPassword(String password) {
      this.password = password;
   }
   
   //adminnum 출력
   public int getAdminnum() {
      return adminnum;
   }
   
   //adminnum 부여
   public void setAdminnum(int adminnum) {
      this.adminnum = adminnum;
   }
   
   //클래스 정보 출력
   public String toString() {
      return "id: "+id+", password: "+password+", adminnum: "+adminnum;
   }
}