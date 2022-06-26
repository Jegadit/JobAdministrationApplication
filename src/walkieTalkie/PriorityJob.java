package walkieTalkie;

public class PriorityJob implements jobi{
private int jobId;
public String jobName;
public int UnitsOfJob;
public int UnitsOfTime;
public boolean JobPriority;
	
	public void setJobName(String name) {
	this.jobName=name;
	}

	public String getJobName() {
		return jobName;
		
	}

	public void setJobId(int jid) {
		this.jobId=jid;
		
	}
	
	public int getJobId() {
		return jobId;
	}
	
	public void setUnitsOfTime(int times) {
		UnitsOfTime=times;	

	}

	
	public int getUnitsOfTime() {
		return UnitsOfTime;
	}

	
	public void setUnitsOfJob(int jobunit) {
		this.UnitsOfJob=jobunit;	

	}
	
	public int getUnitsOfJob() {
		return UnitsOfJob;		
	}
	//overriding ends
	public void setJobPriority(boolean pri) {
		this.JobPriority=pri;
		System.out.println(jobName+"\t\t\t"+jobId+"\t\t\t"+UnitsOfTime+"\t\t\t"+UnitsOfJob+"\t\t\t"+JobPriority+"\n");

	}
	public boolean getJobPriority() {
		return JobPriority;
		
	}
	public int[][] getmatrix(){
		 int[][] dataMatrix = {
			      //col0  col1  col2  col3 job
			        {70,  40,   20,   55},  //row0 workers time units
			        {65,  60,   45,   90},  //row1
			        {30,  45,   50,   75},  //row2
			        {25,  30,   55,   40}   //row3
			        
			        /*{60,  40,   20,   45},  //row0 workers time units
			          {35,  60,   55,   90},  //row1
			          {10,  45,   40,   65},  //row2
			          {25,  30,   25,   40}*/
			      };
		 return dataMatrix;
		 	}
	
	public static void main(String args[])
	{
		//test driver code for Priority job allocation skilled workers and priority job and has the list of jobs and workers details
		
		PriorityJob job1=new PriorityJob();
		PriorityJob job2=new PriorityJob();
		PriorityJob job3=new PriorityJob();
		PriorityJob job4=new PriorityJob();
		PriorityJob job5=new PriorityJob();
		PriorityJob job6=new PriorityJob();
		PriorityJob job7=new PriorityJob();
		PriorityJob job8=new PriorityJob();
		PriorityJob job9=new PriorityJob();
		PriorityJob job10=new PriorityJob();
		
		System.out.println("JOB NAME"+"\t\t\t"+"JOB ID"+"\t\t\t"+"UNITS OF JOB"+"\t\t"+"UNITS OF TIME"+"\t\t"+"PRIORITY");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			
		
		job1.setJobName("Sales   ");job1.setJobId(10); job1.setUnitsOfJob(20);job1.setUnitsOfTime(40);job1.setJobPriority(true);
		job2.setJobName("Purchasing");job2.setJobId(20); job2.setUnitsOfJob(30);job2.setUnitsOfTime(20);job2.setJobPriority(true);
		job3.setJobName("Manufacture");job3.setJobId(30); job3.setUnitsOfJob(25);job3.setUnitsOfTime(45);job3.setJobPriority(true);
		job4.setJobName("Customer Care");job4.setJobId(40); job4.setUnitsOfJob(40);job4.setUnitsOfTime(50);job4.setJobPriority(true);
		job5.setJobName("Sales   ");job5.setJobId(10); job5.setUnitsOfJob(10);job5.setUnitsOfTime(50);job5.setJobPriority(true);
		job6.setJobName("Purchasing");job6.setJobId(20); job6.setUnitsOfJob(20);job6.setUnitsOfTime(45);job6.setJobPriority(true);
		job7.setJobName("Manufacture");job7.setJobId(30); job7.setUnitsOfJob(40);job7.setUnitsOfTime(40);job7.setJobPriority(true);
		job8.setJobName("Customer Care");job8.setJobId(40); job8.setUnitsOfJob(50);job8.setUnitsOfTime(30);job8.setJobPriority(true);
		job9.setJobName("Sales   ");job9.setJobId(10); job9.setUnitsOfJob(20);job9.setUnitsOfTime(40);job9.setJobPriority(true);
		job10.setJobName("Customer Care");job10.setJobId(40); job10.setUnitsOfJob(20);job10.setUnitsOfTime(40);job10.setJobPriority(true);
		System.out.println("\n");
		System.out.println("NAME"+"\t\t\t"+"ID"+"\t\t\t"+"SALARY"+"\t\t\t"+"SKILL"+"\t\t\t"+"PRIORITY WORKER");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				
		@SuppressWarnings("unused")
		SkilledWorkers wk1=new SkilledWorkers("Akhil",123,2000.00, "Faster   ", true);
		@SuppressWarnings("unused")
		SkilledWorkers wk2=new SkilledWorkers("Mrudhun",456,2500.00, "Experienced", true);
		@SuppressWarnings("unused")
		SkilledWorkers wk3=new SkilledWorkers("Sai",789, 10000.00, "communication", true);
		@SuppressWarnings("unused")
		SkilledWorkers wk4=new SkilledWorkers("Jegadit",101, 20060.00, "problem solving", true);
		@SuppressWarnings("unused")
		SkilledWorkers wk5=new SkilledWorkers("Vindhya",136, 2300.00, "Experience", true);
		@SuppressWarnings("unused")
		SkilledWorkers wk6=new SkilledWorkers("Vasini",178, 2090.00, "Faster   ", true);
		@SuppressWarnings("unused")
		SkilledWorkers wk7=new SkilledWorkers("Saravan",980, 1000.00, "Thinker  ", true);
		@SuppressWarnings("unused")
		SkilledWorkers wk8=new SkilledWorkers("Meena",100, 5000.00, "Faster   ", true);
		@SuppressWarnings("unused")
		SkilledWorkers wk9=new SkilledWorkers("Teena",390, 8000.00, "Communication", true);
		@SuppressWarnings("unused")
		SkilledWorkers wk10=new SkilledWorkers("Jiya",896, 9000.00, "Faster   ", true);
	}

}
