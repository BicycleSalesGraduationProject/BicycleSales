package com.hlbrc.bicyclesales.entity;

public class Feedback {
    private Integer feedbackid;

    private String name;

    private String tel;

    private String email;

    private String issue;

    private String voicemessage;

    public Integer getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(Integer feedbackid) {
        this.feedbackid = feedbackid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue == null ? null : issue.trim();
    }

    public String getVoicemessage() {
        return voicemessage;
    }

    public void setVoicemessage(String voicemessage) {
        this.voicemessage = voicemessage == null ? null : voicemessage.trim();
    }
}