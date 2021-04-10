package sec02.exam02_generic_type;

public class BoxExample {

	public static void main(String[] args) {
//		Box<꺽쇠기호가 없다면 T는 전부 Object로 들어간다.> box = new Box();
		
		Box<String> box = new Box<String>();	// <구체적인 타입명시>하게되면, T 자리에 전부 String이 들어간다
		
		Box<Integer> inti = new Box<Integer>();
		
		box.set("제네릭.test"); // box 변수에는 String만 저장가능.
		inti.set(4);	// inti 변수에는 Integer만 저장가능.
		
		String greet = box.get();
		int test = inti.get();
		
		System.out.println(box.get());
		System.out.println(inti.get());
		
		Box<Integer> box2 = new Box<Integer>();
		box2.set(99);
		System.out.println(box2.get());
		
		Box<Boolean> box3 = new Box<Boolean>();
		
		box3.set(box2.equals(inti));	// equals로 box2와 inti를 비교하면 false,  왜그럴까
		System.out.println(box3.get());	// .get() 으로 =을 사용해서 비교하면 오류가발생하지만 !=으로 비교하면 true , 값을 비교하는것같다
											// .get() 으로 ==을 사용해서 비교해도 false. 두 객체가 다른것을 가리킴 즉 다른 객체
		
//		== 연산자는 피연산자가 primitive type(int, double, boolean, ...)일 때는 값이 같은지 비교하고, 
//								피연산자가 그 외 객체, reference type일 때 가리키는 주소가 같은지를 검사한다.
		
//		equals는 default로 primitive type은 내용이 같은지 검사하고, reference type은 객체의 주소가 같은지 검사한다.

	}

}
