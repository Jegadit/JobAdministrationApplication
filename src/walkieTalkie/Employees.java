package walkieTalkie;

public abstract class Employees implements EmpDetails, EmpQualifications {
protected String workerName;
protected int workerId;
protected int[] workerTime;
protected double Salary;
protected boolean priority;
protected String skill;


	@Override public void setName(String name) {
		this.workerName = name;
	}
	@Override public String getName() {
		return workerName;
	}
	
	@Override public void setId(int id) {
		this.workerId=id;
		System.out.println("insetid");
	}
	@Override public int getId() {
		System.out.println("ingetid");
		return workerId;
	}
	
	@Override public void setSalary(double sal) {
		this.Salary=sal;
	}
	@Override public double getSalary() {
		return Salary;
	}
	
	@Override public void setSkill(String skil) {
		this.skill=skil;
	}
	@Override public String getSkill() {
		return skill;
	}
	
	@Override public void setPriority(boolean sp) {
		this.priority=sp;
	}
	@Override public boolean getPriority() {
		return priority;
	}
	
	@Override public void setWorkerTime(int[] time) {
		this.workerTime=time;
	}
	@Override public int[] getWorkerTime() {
		return workerTime;
	}
	
}

