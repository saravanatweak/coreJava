package CoreJava.newBoatsMan.Time;

public class TimeNormalRailWay {
	
	public static void main(String args[]){
		TimeSubClass miltary = new TimeSubClass();
		
		System.out.println("Default timings for both case");
		System.out.println(miltary.to24Formate());
		System.out.println(miltary.to12Formate());
		
		miltary.setTimeWithoutThisKeyWord(15, 15, 15);
		System.out.println("\n User defined timings Without THIS keyword");
		System.out.println(miltary.to24Formate());
		System.out.println(miltary.to12Formate());
		
		miltary.setTimeWithUsingThisKeyword(15, 15, 15);
		System.out.println("\n User defined timings With THIS keyword");
		System.out.println(miltary.to24Formate());
		System.out.println(miltary.to12Formate());
		
	}

}
