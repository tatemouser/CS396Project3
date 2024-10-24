// src/main/models/MedicalTeam.java
package main.models;

import java.util.ArrayList;
import java.util.List;

public class MedicalTeam {
    private String teamId;
    private String teamName;
    private String specialty;
    private List<String> memberIds;
    private boolean isOnCall;

    public MedicalTeam(String teamId, String teamName, String specialty) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.specialty = specialty;
        this.memberIds = new ArrayList<>();
        this.isOnCall = false;
    }

    public String getTeamId() {
        return teamId;
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

    public List<String> getMemberIds() {
        return new ArrayList<>(memberIds);
    }

    public void addMember(String memberId) {
        if (!memberIds.contains(memberId)) {
            memberIds.add(memberId);
        }
    }

    public void removeMember(String memberId) {
        memberIds.remove(memberId);
    }

    public boolean isOnCall() {
        return isOnCall;
    }

    public void setOnCall(boolean onCall) {
        isOnCall = onCall;
    }

    @Override
    public String toString() {
        return "MedicalTeam{" +
                "teamId='" + teamId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", memberCount=" + memberIds.size() +
                ", isOnCall=" + isOnCall +
                '}';
    }
}