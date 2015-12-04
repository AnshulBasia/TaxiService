import java.util.Vector;
public class TaxiService
{
	public Graph g=new Graph();
	public Vector<Taxi> Taxis=new Vector<Taxi>();

	public TaxiService() 
	{
		g=new Graph();
		Taxis=new Vector<Taxi>();
	}

	public void performAction(String actionMessage) 
	{
		System.out.println("action to be performed: " + actionMessage);
		int u=actionMessage.indexOf(32);
		switch(actionMessage.substring(0,u))
		{
			case"edge":
							int x=5;
							while((int)actionMessage.charAt(x)!=32)
							 {
								x++;
							 }
							 String s1=actionMessage.substring(5,x);
							 int y=x+1;
							 x++;
							 while((int)actionMessage.charAt(x)!=32)
							 {
								x++;
							 }
							 String s2=actionMessage.substring(y,x);
							 int t=Integer.parseInt(actionMessage.substring(x+1));
							 int mh=0;
							 int h=0;
							 for(int i=0;i<g.vertices.size();i++)
          					 {
          					  if(g.vertices.get(i).s.equals(s1))
          						{
          							mh=1;
          						}
          						if(g.vertices.get(i).s.equals(s2))
          						{
          							h=1;
          						}
          					 }
							 if(mh==0){g.addVertex(s1);}
							 if(h==0){g.addVertex(s2);}
							 g.addEdge(s1,s2,t);
							 g.printGraph();
							 break;

			case"taxi":
							 x=5;
							while((int)actionMessage.charAt(x)!=32)
							 {
								x++;
							 }
							 String taxi=actionMessage.substring(5,x);
							 String loc=actionMessage.substring(x+1);
							 if(g.containsvertex(loc)==false)
							 {
							 	System.out.println("Error--location doesn't exist");
							 }
							 Taxi r=new Taxi(taxi,loc);
							 Taxis.add(r);
							 break;

			case"customer":

							x=9;
							while((int)actionMessage.charAt(x)!=32)
							 {
								x++;
							 }
							 String src=actionMessage.substring(9,x);
							 y=x+1;
							 x++;
							 while((int)actionMessage.charAt(x)!=32)
							 {
								x++;
							 }
							 String des=actionMessage.substring(y,x);
							  t=Integer.parseInt(actionMessage.substring(x+1));
							 System.out.println("Available Taxis ");
							 Dnode m=g.ShortestPath(Taxis.get(0).loc,src);
							 int a=0;
							 int huff=0;
							 for(x=0;x<Taxis.size();x++)
							 {
							 	if(Taxis.get(x).availability(t)==true)
							 		{a=x;break;}
							 }
							 for(x=0;x<Taxis.size();x++)
							 {
							 	if(Taxis.get(x).availability(t)==true)
							 	{   
							 	System.out.print("Path of Taxi "+Taxis.get(x).s+": ");
							 	Dnode d=g.ShortestPath(Taxis.get(x).loc,src);
							 	for(y=0;y<d.path.size();y++)
							 	{
							 		System.out.print(" "+d.path.get(y).s+" ");
							 	}
							 	System.out.println(". Time taken is "+d.dis);
							 	if(m.dis>d.dis)
							 	{
							 		a=x;
							 		huff=d.dis;
							 	}

							   }

							 }
							 System.out.println("taxis chosen is "+Taxis.get(a).s);
							 System.out.print("Path of customer ");
							  Dnode d=g.ShortestPath(Taxis.get(a).loc,src);
							 for( y=0;y<d.path.size();y++)
							 	{
							 		System.out.print(" "+d.path.get(y).s+" ");
							 	}
							 d=g.ShortestPath(src,des);
							 for( y=0;y<d.path.size();y++)
							 	{
							 		System.out.print(" "+d.path.get(y).s+" ");
							 	}
							 System.out.println(". Time taken will be "+d.dis);
							 huff=t+d.dis+huff;
							 Taxis.get(a).setavailability(t,huff);
							 
							 System.out.println("Taxi "+Taxis.get(a).s+" is busy from "+t+" to "+huff);
							 Taxis.get(a).setlocation(des);
							 break;

			case "printTaxiPosition":


							 t=Integer.parseInt(actionMessage.substring(18));
							 int xyz=0;
							for(x=0;x<Taxis.size();x++)
							 {
							 	if(Taxis.get(x).availability(t)==true)
							 	{  xyz=1;
							 		System.out.println(Taxis.get(x).s+": "+Taxis.get(x).loc);
							 	}
							 }
							 if(xyz==0)
							 {

							 System.out.println("No taxis available at this point of time");
							 }
							 break;


		}
		

	}
}
