package walkieTalkie;

public class Hirer {
	//variables declaration
	
	Applicants a2;
	private int noOfApplicants;
	private int noOfJobs;
	
	//constructor declaration
	public Hirer(int noOfApplicants, int noOfJobs, Applicants another) {
		this.setNoOfApplicants(noOfApplicants);
		this.setNoOfJobs(noOfJobs);
		this.a2 = another;
	}
	
	//methods declaration
	public int getNoOfApplicants() {
		return noOfApplicants;
	}
	
	public void setNoOfApplicants(int noOfApplicants) {
		this.noOfApplicants = noOfApplicants;
	}
	
	public int getNoOfJobs() {
		return noOfJobs;
	}
	
	public void setNoOfJobs(int noOfJobs) {
		this.noOfJobs = noOfJobs;
	}
	
	public boolean linkJobs(boolean bpGraph[][], int u, boolean seen[], int matchR[])
 {
     for (int i = 0; i < noOfJobs; i++)
     {
         if (bpGraph[u][i] && !seen[i])
         {
             seen[i] = true; 

             if (matchR[i] < 0 || linkJobs(bpGraph, matchR[i],
                                      seen, matchR))
             {
                 matchR[i] = u;
                 return true;
             }
         }
     }
     return false;
 }

	 public int assignJob(boolean bpGraph[][])
	    {
	        int matchR[] = new int[noOfJobs];

	        for(int i = 0; i < noOfJobs; ++i)
	            matchR[i] = -1;
	        
	        int result = 0; 
	        for (int u = 0; u < noOfApplicants; u++)
	        {
	            boolean seen[] =new boolean[noOfJobs] ;
	            for(int i = 0; i < noOfJobs; ++i)
	                seen[i] = false;

	            if (linkJobs(bpGraph, u, seen, matchR))
	                result++;
	        }
	        return result;
	    }
}
