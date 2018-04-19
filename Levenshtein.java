package edit;

public class Levenshtein {
	
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t0 = System.currentTimeMillis();
		String a="abcdef";
		String b="abcd";
		arr=new int[b.length()+1][a.length()+1];
		
		for(int i=0;i<b.length()+1;i++)
		{
			for(int j=0;j<a.length()+1;j++)
			{
				arr[i][j]=i+j;
				
				
			}
			
		}
		
		
		System.out.println("the edit distance is:"+lev(a,b));
		long t1 = System.currentTimeMillis();
        long t = t1 - t0;
        System.out.println("returned in " + t + " msec");

	}

	private static int lev(String a, String b) {
		
		
		// TODO Auto-generated method stub
			if(a.isEmpty())
			{
				return b.length();
			}
			 if(b.isEmpty())
			 {
				 return a.length();
			 }
		 
		 else
		 {
			for(int i=1;i<b.length()+1;i++)
			{
				for(int j=1;j<a.length()+1;j++)
				{
					
					
					if(a.charAt(j-1)==b.charAt(i-1))
					{
						arr[i][j]=arr[i-1][j-1];
						
					}
					
					else
					{
						
						arr[i][j]=min(arr[i-1][j-1],arr[i-1][j],arr[i][j-1])+1;
						
					}
					
				}
			}
		 }
		 
			 
		 
		 
		 return arr[b.length()][a.length()];
		
		
		
	}
	
public static int min(int x, int y, int z) {
		
		int m = Math.min(x,y);
		return Math.min(m,z);
		
	}

public static void print_arr(String a,String b)
{
	for(int i=0;i<b.length()+1;i++)
	{
		for(int j=0;j<a.length()+1;j++)
		{
			
			System.out.print(arr[i][j]+" ");
			
		}
		System.out.println();
	}
}

}
