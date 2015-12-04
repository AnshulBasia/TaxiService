import java.util.Vector;
public class Dnode
{
	public Vertex v1;
	public int dis;
	public Vector<Vertex> path=new Vector<Vertex>();
	public Dnode(Vertex v,int p,Vector<Vertex>d)
	{
		v1=v;
		dis=p;
	    path=new Vector<Vertex>(d);
	}
}