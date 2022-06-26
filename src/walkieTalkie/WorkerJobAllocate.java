package walkieTalkie;

public class WorkerJobAllocate extends Thread implements jobAssigner{
	
	private Applicants Applicants;

	Hirer h1 = new Hirer(10, 5, Applicants);
	
	public static int n;
	static Job[] jj2 = new Job[n];
	
	public WorkerJobAllocate(Job[] q1, int n)
	{
		WorkerJobAllocate.n = n;
		WorkerJobAllocate.jj2 = q1;
	}
	
	public static int[] giveArrJob()
	{
		int[] testarr = new int[n];
		for(int i = 0; i < n; i++)
		{
			testarr[i] = jj2[i].getUnitsOfJob();
		}
		return testarr;
	}

	static int getMax(int arr[], int n)
	{
	int result = arr[0];
	for (int i=1; i<n; i++)
		if (arr[i] > result)
			result = arr[i];
		return result;
	}
	
	static boolean isPossible(int time, int K,
									int job[], int n)
	{
		int cnt = 1;		
		int curr_time = 0;
	
		for (int i = 0; i < n;)
		{
			if (curr_time + job[i] > time) {
				curr_time = 0;
				cnt++;
			}
			
			else
			{
				curr_time += job[i];
				i++;
			}
		}
	
		return (cnt <= K);
	}
	
	static int findMinTime(int K, int T, int job[], int n)
	{
		// Set start and end for binary search end provides an upper limit on time
		int end = 0, start = 0;
		for (int i = 0; i < n; ++i)
			end += job[i];
			
		// Initialize answer
		int ans = end;
	
		// Find the job that takes maximum time
		int job_max = getMax(job, n);
	
		// Do binary search for minimum feasible time
		while (start <= end)
		{
			int mid = (start + end) / 2;
	
			// If it is possible to finish jobs in mid time
			if (mid >= job_max && isPossible(mid, K, job, n))
			{
				// Update answer
				ans = Math.min(ans, mid);
				
				end = mid - 1;
			}

			else
				start = mid + 1;
		}		
	
		return (ans * T);
	}
	
	public static void assignJob(int k, int T, int[] job, int n, int ans)
	{
		int curr_time = 0;
		int pc = 0;
		String[] jpp = new String[k];
		
		for(int loop1 = 0; loop1 < k; loop1++)
		{
			jpp[loop1] = "{";
		}
			
		int i = 0;
		while(i < n)
		{
			// If time assigned to current assignee exceeds max, increment count of assignees.
			if (curr_time + T*job[i] > ans) {
				curr_time = 0;
				pc = pc + 1;
			}
			// Else add time of job to current time and move to next job.
			else
			{
				jpp[pc] = jpp[pc] + Integer.toString(job[i]) + ", " ;
				curr_time += T*job[i];
				i++;
			}
		}
		
		for(int loop1 = 0; loop1 < k; loop1++)
		{
			jpp[loop1] = jpp[loop1].substring(0, jpp[loop1].length() - 2);
			jpp[loop1] = jpp[loop1] + "}";
			System.out.println("Job assigned to worker "+(loop1+1)+" is "+jpp[loop1]);
		}
	}
	
	public static int[] Akhilgetjob()
	{
		int jooob[];
		jooob = WorkerJobAllocate.giveArrJob();
		int jooob2[] = {-1};
		
		int merged[] = new int[(jooob.length+1)];
		
		for(int i = 0; i < (jooob.length+1);i++)
		{
			if(i == 0)
			{
				merged[i] = jooob2[0];
			}
			else
			{
				merged[i] = jooob[i-1];
			}
		}
		
		return merged;
	}
}
