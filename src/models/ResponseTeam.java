package models;

public class ResponseTeam {
    private String teamName;
    private String specialty;

    public ResponseTeam(String teamName, String specialty) {
        this.teamName = teamName;
        this.specialty = specialty;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "ResponseTeam{" +
                "teamName='" + teamName + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
