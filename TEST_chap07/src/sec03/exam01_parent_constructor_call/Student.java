package sec03.exam01_parent_constructor_call;

public class Student extends People{
	
	public int studentNo;	//field
	
	public Student(String name,String ssn, int studentNo) {
		super(name,ssn);		// 항상 생성자 첫줄에 명시해야함 !!
		this.studentNo = studentNo;
		System.out.println("자식 객체 생성 완료");
		
	}
}
