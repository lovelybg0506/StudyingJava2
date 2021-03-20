package sec02.exam01_inheritance;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		DmbCellPhone dmbcellphone = new DmbCellPhone("자바폰","검정",10);

		System.out.println("모델: " + dmbcellphone.model);
		System.out.println("색상: " + dmbcellphone.color);
		
		System.out.println("채널: " + dmbcellphone.channel);
		
		
		dmbcellphone.powerOn();
		dmbcellphone.bell();
		dmbcellphone.sendVoice("여보세요");
		dmbcellphone.receiveVoice("안녕하세요 저는 엄민성입니다.");
		dmbcellphone.sendVoice("아 이름이 엄민성인가요?");
		dmbcellphone.hangUp();
		
		
		dmbcellphone.turnOnDmb();
		dmbcellphone.changeChannelDmb(12);
		dmbcellphone.turnOffDmb();
	
	}

}
