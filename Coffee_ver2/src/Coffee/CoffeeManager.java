//package controller;
//
//import java.util.ArrayList;
//
//import model.dao.CoffeeDao;
//import model.exception.CoffeeException;
//import model.vo.Coffee;
//import model.vo.Order;
//
//public class CoffeeManager {
//	private ArrayList<Order> orderList; 
//	private CoffeeDao coDao;
//	private Order od;  
//	
//	public CoffeeManager() {
//		coDao=new CoffeeDao(); 
//		orderList=coDao.openList();
//		od=new Order();
//	}
//	
//	public Order insertCoffee(Coffee coffee) { 
//		
//		switch(coffee.getCoffeeName()) {
//		case "아메리카노":
//			if(!(od.getHt().containsKey("아메리카노"))) {
//				od.getHt().put(coffee.getCoffeeName(), coffee);
//			}else {
//				od.getHt().get("아메리카노").plusCups(coffee.getCups());
//			}
//			break;
//		case "카페라테":
//			if(!(od.getHt().containsKey("카페라테"))) {
//				od.getHt().put(coffee.getCoffeeName(), coffee);
//			}else {
//				od.getHt().get("카페라테").plusCups(coffee.getCups());
//			}
//			break;
//		case "카푸치노":
//			if(!(od.getHt().containsKey("카푸치노"))) {
//				od.getHt().put(coffee.getCoffeeName(), coffee);
//			}else {
//				od.getHt().get("카푸치노").plusCups(coffee.getCups());
//			}
//			break;
//		}
//		return od;
//	}
//	
//	public void insertOrder() {
//		orderList.add(od);
//		od.setOrderNo2(orderList.size());
//	}
//	
//	public Order verifyCoffee(int orderNo)throws CoffeeException{
//		
//		if(orderNo > orderList.size()) {
//			throw new CoffeeException("잘못된 주문 정보입니다.");
//		}
//		
//		return orderList.get(orderNo-1);
//	}
//	
//	public void updateCoffee(int orderNo,Coffee coffee) {
//		coffee.setOrderNo(orderNo);
//		Order localOd=orderList.get(orderNo-1);
//		
//		switch(coffee.getCoffeeName()) {
//		case "아메리카노":
//			if(localOd.getHt().containsKey("아메리카노")) {
//				localOd.getHt().replace("아메리카노",coffee);
//			}else {
//				localOd.getHt().put("아메리카노",coffee);
//			}
//			break;
//		case "카페라떼":
//			if(localOd.getHt().containsKey("카페라떼")) {
//				localOd.getHt().replace("카페라떼",coffee);
//			}else {
//				localOd.getHt().put("카페라떼",coffee);
//			}
//			break;
//		case "카푸치노":
//			if(localOd.getHt().containsKey("카푸치노")) {
//				localOd.getHt().replace("카푸치노",coffee);
//			}else {
//				localOd.getHt().put("카푸치노",coffee);
//			}
//			break;
//		}
//		orderList.set(orderNo-1,localOd);//
//		localOd.editprice();//
//	}
//	
//	public void deleteCoffee(int idx) {
//		orderList.remove(idx);
//		for(int i=idx;i<orderList.size();i++) {
//				orderList.get(i).setOrderNo2(i+1);
//			}
//	}
//	
//	public boolean deleteSubCoffee(int idx,int sel) {
//		Order localOd=orderList.get(idx);
//		
//		switch(sel) {
//		case 1:
//			orderList.get(idx).getHt().remove("아메리카노");
//			break;
//		case 2:
//			orderList.get(idx).getHt().remove("카페라테");
//			break;
//		case 3:
//			orderList.get(idx).getHt().remove("카푸치노");
//			break;
//		}
//		
//		orderList.set(idx,localOd);//
//		localOd.editprice();//
//		
//		if(localOd.getHt().isEmpty()) {
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean check(int idx,int sel) {
//		
//		switch(sel) {
//		case 1:
//			if(orderList.get(idx).getHt().containsKey("아메리카노"))
//				return true;
//			else
//				return false;
//		case 2:
//			if(orderList.get(idx).getHt().containsKey("카페라떼"))
//				return true;
//			else
//				return false;
//		case 3:
//			if(orderList.get(idx).getHt().containsKey("카푸치노"))
//				return true;
//			else
//				return false;
//		default:
//			return false;
//		}
//	}
//	
//	public ArrayList<Order> getOrderList(){
//		
//		return orderList;
//	}
//	
//	public void setOrderList(ArrayList<Order> orderList) {
//		this.orderList=orderList;
//	}
//	
//	public void close() {
//		coDao.saveList(orderList);
//	}
//	
//	public Order getOrder() {
//		return od;
//	}
//	
//	public void clearOrder() {
//		od=new Order();
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
