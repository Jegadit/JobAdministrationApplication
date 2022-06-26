package walkieTalkie;

public class Job implements jobi {
	//variables declaration
	public int jobId;
	public String jobName;
	public int unitsOfJob;
	public int unitsOfTime;
	
	//new
	public Job(int jobId, String jobName, int unitsOfJob, int unitsOfTime) {
		this.jobId = jobId;
		this.jobName = jobName;
		this.unitsOfJob = unitsOfJob;
		this.unitsOfTime = unitsOfTime;
	}
	// end new

	public int getUnitsOfJob() {
		return this.unitsOfJob;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getUnitsOfTime() {
		return unitsOfTime;
	}

	public void setUnitsOfTime(int unitsOfTime) {
		this.unitsOfTime = unitsOfTime;
	}

	public void setUnitsOfJob(int unitsOfJob) {
		this.unitsOfJob = unitsOfJob;
	}
	
	public static void main(String args[])
	{
		System.out.println("NAME"+"\t\t\t"+"ID"+"\t\t\t"+"SALARY"+"\t\t\t"+"SKILL"+"\t\t\t"+"PRIORITY WORKER");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		@SuppressWarnings("unused")
		Workers wk1=new Workers("Akhil",123,2000.00, "Faster   ", false);
		@SuppressWarnings("unused")
		Workers wk2=new Workers("Mrudhun",456,2500.00, "Experienced", false);
		@SuppressWarnings("unused")
		Workers wk3=new Workers("Sai",789, 10000.00, "communication", false);
		@SuppressWarnings("unused")
		Workers wk4=new Workers("Jegadit",101, 20060.00, "problem solving", false);
		@SuppressWarnings("unused")
		Workers wk5=new Workers("Vindhya",136, 2300.00, "Experience", false);
		@SuppressWarnings("unused")
		Workers wk6=new Workers("Vasini",178, 2090.00, "Faster   ", false);
		@SuppressWarnings("unused")
		Workers wk7=new Workers("Saravan",980, 1000.00, "Thinker  ", false);
		@SuppressWarnings("unused")
		Workers wk8=new Workers("Meena",100, 5000.00, "Faster   ", false);
		@SuppressWarnings("unused")
		Workers wk9=new Workers("Teena",390, 8000.00, "Communication", false);
		@SuppressWarnings("unused")
		Workers wk10=new Workers("Jiya",896, 9000.00, "Faster   ", false);
		
	}
	
}
