package walkieTalkie;

class Mrudhun extends Thread
{
	static int maxapp;
	
	static boolean bpfinGraph[][];
			
	public void run()
	{
		synchronized(this)
		{
		boolean bpGraph[][] = new boolean[][]{
			// -> workers
                  {false, true, true, false, false, false},
                  {true, false, false, true, false, false},//	|
                  {false, false, true, false, false, false},//	v
                  {false, false, true, true, false, false}, //	job
                  {false, false, false, false, false, false},
                  {false, false, false, false, false, true}};
                  
        bpfinGraph = bpGraph;
        String Name[] = {"J","e","g","a","d","i"};
        String Skill[] = {"a","b","c","d","e","f"};
        Applicants a1 = new Applicants(bpGraph, Name, Skill);

        Hirer m = new Hirer(6, 6, a1);
        this.maxapp =  m.assignJob(bpGraph);
	}
	}
	
	@SuppressWarnings("null")
	public int retMaxNoAppl()
	{
		return this.maxapp;
	}
	
}


class Jegadit extends Thread
{
	int TimeLimit;
	
	Jegadit(int t)
	{
		this.TimeLimit = t;
	}
	
	public void run()
	{
		synchronized(this)
		{		
		int n = 6;
		Job[] jobs = new Job[n];
		jobs[0] = new Job(1,"Job1",10,5);
		jobs[1] = new Job(2,"Job2",7,5);
		jobs[2] = new Job(3,"Job3",8,5);
		jobs[3] = new Job(4,"Job4",12,5);
		jobs[4] = new Job(5,"Job5",6,5);
		jobs[5] = new Job(6,"Job6",8,5);

		@SuppressWarnings("unused")
		WorkerJobAllocate wja1 = new WorkerJobAllocate(jobs, n);
		
		int job[] = new int[n];
		job = WorkerJobAllocate.giveArrJob();
		int k = 4, // no of assignees available 
				T = 5; // time taken by each assignee
		
		int ans = WorkerJobAllocate.findMinTime(k, T, job, n);
		
		int flag = 1;
		Mrudhun m1 = new Mrudhun();
		if(ans > this.TimeLimit)
		{
			System.out.println("The minimum time to finish all jobs with given number of workers is "+ans + " units of time");
			System.out.println("but "+ans+" is > "+TimeLimit);
			System.out.println("So we are Hiring necessary amt of new workers");
			System.out.println();
			System.out.println( "Maximum number of workers that can be hired is " + m1.retMaxNoAppl());
	        System.out.println();
		}
		while(ans > this.TimeLimit)
		{
			if(flag <= m1.retMaxNoAppl() )
			{
				k++;
				System.out.println("New person is hired!!!");
				ans = WorkerJobAllocate.findMinTime(k, T, job, n);
				flag++;
			}
		}
		
		System.out.println();
		System.out.println("The minimum time to finish all jobs with given number of workers is "+ans + " units of time");
		WorkerJobAllocate.assignJob(k, T, job, n, ans);
		System.out.println();
		}
	}
}

class Akhil extends Thread
{
	@SuppressWarnings({ "unused" })
	public void run()
	{
		synchronized(this)
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
			
			SequenceManager seq=new SequenceManager();
			WorkerJobAllocate j3 = null;
			SequenceManager.V = merged;
			double P = seq.loss; // assigning loss per day
			seq.optimum_sequence_jobs(P);
			System.out.println();
		}
	}
}

class Vindhya extends Thread
{
	public void run()
	{
		synchronized(this)
		{
		//find optimal assignment
    	PriorityJobAllocation ha = new PriorityJobAllocation();
    	int[][] assignment = ha.assignjob();

		System.out.println("Jobs assigned on priority basis : ");
		if (assignment.length > 0) {
			// print assignment
			for (int i = 0; i < assignment.length; i++) {
				System.out.print("job " + (assignment[i][0]+1) + " => Worker " + (assignment[i][1]+1));
				System.out.println();
			}
		} 
		else {
		System.out.println("no assignment found!");
		}
		
		System.out.println();
		//------------------------------------------------------------------------------------------------------------------------------------------
		}
	}
}

public class threadedTestDriver {

		public static void main(String arg[])
		{
			int timelimit = 75;		//TEST CASE 1 (without using hiring)
			//int timelimit = 60;	//TEST CASE 2 (using hiring)
			
			Mrudhun sm = new Mrudhun();
			Jegadit j = new Jegadit(timelimit);
			Akhil a = new Akhil();
			Vindhya v = new Vindhya();
			
			sm.setPriority(3);
			j.setPriority(4);
			a.setPriority(2);
			v.setPriority(1);
			
			sm.start();
			try {
				sm.join();
			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted");
			}
			
			j.start();
			try {
				j.join();
			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted");
			}
			
			a.start();
			try {
				a.join();
			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted");
			}
			
			v.start();
			try {
				v.join();
			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted");
			}
		}

	}

