package com.codingbox.planner.domain.DTO;

public class ShareScheduleDTO {
    private Long scheduleId;
    private String colleagueId;

    public ShareScheduleDTO() {
    }

    public ShareScheduleDTO(Long scheduleId, String colleagueId) {
        this.scheduleId = scheduleId;
        this.colleagueId = colleagueId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getColleagueId() {
        return colleagueId;
    }

    public void setColleagueId(String colleagueId) {
        this.colleagueId = colleagueId;
    }

    @Override
    public String toString() {
        return "ShareScheduleRequest{" +
                "scheduleId=" + scheduleId +
                ", colleagueId='" + colleagueId + '\'' +
                '}';
    }
}
