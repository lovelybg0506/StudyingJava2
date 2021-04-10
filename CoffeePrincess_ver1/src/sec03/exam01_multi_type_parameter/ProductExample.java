package sec03.exam01_multi_type_parameter;

public class ProductExample {

	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<Tv, String>();
//		Product<Tv, String> product1 = new Product<자바7부터 이부분 생략가능>();
		
		product1.setKind(new Tv());
		product1.setModel("스마트TV");
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		
		
		Product<Car, String> product2 = new Product<>();
		
		product2.setKind(new Car());
		product2.setModel("디젤");
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
		System.out.println(product1.getKind());
		System.out.println(product1.getModel());
		System.out.println(product2.getKind());
		System.out.println(product2.getModel());
		
		System.out.println("==================");
		
		System.out.println(tv);
		System.out.println(car);
		System.out.println(tvModel);
		System.out.println(carModel);
	
	}

}
