public class Node
{
	public int data;

	public Vertex v1;
	public Vertex v2;
	
	public Node(Vertex x,Vertex y,int w)
	{
             data=w;
             v1=x;
             v2=y;
	}
	public Boolean contains(Vertex a,Vertex b)
	{
		if(v1.s.equals(a.s)&&v2.s.equals(b.s))
			{return true;}
		if(v1.s.equals(b.s)&&v2.s.equals(a.s))
			{return true;}
		return false;
	}
	
	
 }