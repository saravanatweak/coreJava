package CoreJava.newBoatsMan.Time;

public class TimeSubClass {

	private int hour =1; 
	private int minute = 2;
	private int second = 3;
		
	//using this keyword
	public void setTimeWithoutThisKeyWord(int hour, int minute, int second){
		hour = ((hour>0 && hour<24) ? hour : 0);
		minute = ((minute>0 && minute<60) ? minute : 0);
		second = ((second>0 && second<60) ? second : 0);
	}
	
	public void setTimeWithUsingThisKeyword(int hour, int minute, int second)
	{
		this.hour = ((hour>0 && hour<24) ? hour : 0);
		this.minute = ((minute>0 && minute<60) ? minute : 0);
		this.second = ((second>0 && second<60) ? second : 0);
	}
	
	public String to24Formate(){
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	public String to12Formate(){
		return String.format("%d:%02d:%02d %s", 
				((hour==0 || hour==12) ? 12 : hour%12), 
				minute, second, hour<12 ? "AM" : "PM");
	}
}
