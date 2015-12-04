import java.util.Vector;
public class Graph
{
	public Vector<Node> edges=new Vector<Node>();
	public Vector<Vertex> vertices=new Vector<Vertex>();
	

	public void addVertex(String s)
	{
		Vertex v=new Vertex(s);
		vertices.add(v);
		System.out.println("Vertex added- "+s);
	}
	public Boolean containsvertex(String a)
	{
		for(int i=0;i<vertices.size();i++)
		{
			if(vertices.get(i).s.equals(a))
				{return true;}

		}
		return false;
	}
	public void addEdge(String s1,String s2,int w)
	{
          Vertex v1=vertices.get(0);
          Vertex v2=vertices.get(0);
          for(int i=0;i<vertices.size();i++)
          {
          	if(vertices.get(i).s.equals(s1))
          	{
          		v1=vertices.get(i);
          	}
          	if(vertices.get(i).s.equals(s2))
          	{
          		v2=vertices.get(i);
          	}
          }
          Node n=new Node(v1,v2,w);
          edges.add(n);
          System.out.println("edge added btw- "+s1+" and "+s2+" of cost "+w);
	}
	public void printGraph()
	{
		System.out.println("Graph formed so far ");
		System.out.println("Vertices--");
		for(int j=0;j<vertices.size();j++)
		{
			System.out.println(vertices.get(j).s);
		}
		System.out.println("Edges--");
		for(int k=0;k<edges.size();k++)
		{
			System.out.println("from "+edges.get(k).v1.s+" to "+edges.get(k).v2.s+" for cost "+edges.get(k).data);
		}
	}

	public Dnode ShortestPath(String src,String des)
	{
		Vertex v1=vertices.get(0);
          Vertex v2=vertices.get(0);
		int flag=0;
          for(int i=0;i<vertices.size();i++)
          {
          	if(vertices.get(i).s.equals(src))
          	{
          		v1=vertices.get(i);
          	}
          	if(vertices.get(i).s.equals(des))
          	{
          		v2=vertices.get(i);
          	}
          }

          Vector<Vertex> leftover=new Vector<Vertex>(vertices);
          for(int o=0;o<leftover.size();o++)
          {
          	if(leftover.get(o).s.equals(v1.s))
          	{
          		leftover.remove(o);
          		break;
          	}
          }
          
          Vector<Dnode> x=new Vector<Dnode>();
          Vector<Vertex> path=new Vector<Vertex>();
          path.add(v1);
          Dnode v=new Dnode(v1,0,path);
          x.add(v);
          int p=x.get(0).dis+edges.get(0).data;
          Vector<Vertex> pth;
          if(src.equals(des))
          {
          	return v;
          }
          
          
          while(x.size()!=vertices.size())
          {
          	/*System.out.println("Leftover-");
          	for(int o=0;o<leftover.size();o++)
            {
          	  System.out.println(leftover.get(o).s);
          	}
          	System.out.println("x-");
          	for(int o=0;o<x.size();o++)
            {
          	  System.out.println(x.get(o).v1.s);
          	}*/
          	
          	flag=1;
          	for(int i=0;i<x.size();i++)
          	{
          		for(int j=0;j<leftover.size();j++)
          		{
          			for(int k=0;k<edges.size();k++)
		             {
				       if(edges.get(k).contains(x.get(i).v1,leftover.get(j)))
				         {
					       p=x.get(0).dis+edges.get(k).data;
					      // System.out.println("-"+p);
				   		   pth=new Vector<Vertex>(x.get(0).path);
				  		   pth.add(leftover.get(0));
				  		   v=new Dnode(leftover.get(0),p,pth);
				  			flag=0;
					
					      break;
				          }
			 		 }
			 		 if(flag==0){break;}

          		}
          		 if(flag==0){break;}
          	}

          	flag=0;



          	

			 for(int i=0;i<x.size();i++)
			 {
			 	for(int j=0;j<leftover.size();j++)
			 	{
			 		for( int k=0;k<edges.size();k++)
		     		{
						if(edges.get(k).contains(x.get(i).v1,leftover.get(j)))
						{ //System.out.println(x.get(i).v1.s+"  to "+leftover.get(j).s);
							//System.out.println("p-"+p+" vs "+x.get(i).dis+"+"+edges.get(k).data);

							if(p>x.get(i).dis+edges.get(k).data)
							{
								
								p=x.get(i).dis+edges.get(k).data;
								 pth=new Vector<Vertex>(x.get(i).path);
								pth.add(leftover.get(j));
								 v=new Dnode(leftover.get(j),p,pth);
								flag=j;


							}
							break;

							
						}
			 		}

			 	}
			 }

			 x.add(v);
			 //System.out.println(flag+"  "+leftover.size());
			 leftover.remove(flag);
			 //System.out.println("dbg" +v.v1.s);
			 if(v.v1.s.equals(des))
			 {
			 	return v;
			 }


          }


          System.out.println("destination not found in graph");
          return null;
	}



}