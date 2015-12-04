public class Taxi
{
	public String s;
	public String loc;
	int a,b;
	int c=0;
	public Taxi(String a,String b)
	{
		s=a;
		loc=b;
		System.out.println("New Taxi "+s+" at location "+loc);
	}
	public void setavailability(int t1,int t2)
	{
		a=t1;
		b=t2;
		c=1;
	}
	public Boolean availability(int t)
	{
		if(c==0){return true;}
		if(t>=a&&t<=b)
			{return false;}
		return true;
	}
	public void setlocation(String s)
	{
		loc=s;
	}

}