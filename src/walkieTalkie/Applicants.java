package walkieTalkie;

public class Applicants {
	//variables declaration
	protected boolean jobChoice[][];
	protected String[] applicantName;
	private String[] skill;
	
	public Applicants(boolean[][] jobChoice, String[] applicantName, String[] skill) {
		this.jobChoice = jobChoice;
		this.applicantName = applicantName;
		this.skill = skill;
	}

	//methods
	public String[] getSkill() {
		return skill;
	}
}
