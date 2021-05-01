package org.csu.travelbyex.domain;

import java.util.Date;

public class AppointmentReply implements Comparable<AppointmentReply> {
    private Integer replyId;

    private Integer appointmentId;

    private String authorId;

    private Date time;

    private String contentEx;

    public AppointmentReply(Integer replyId, Integer appointmentId, String authorId, Date time, String contentEx) {
        this.replyId = replyId;
        this.appointmentId = appointmentId;
        this.authorId = authorId;
        this.time = time;
        this.contentEx = contentEx;
    }

    public AppointmentReply() {
        super();
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContentEx() {
        return contentEx;
    }

    public void setContentEx(String contentEx) {
        this.contentEx = contentEx == null ? null : contentEx.trim();
    }

    @Override
    public int compareTo(AppointmentReply o) {
        if (this.getTime() == null)
            return 1;
        if (o.getTime() == null)
            return -1;
        int a = this.getTime().compareTo(o.getTime());
        // list添加值时如果compareTo返回值为0就不添加了。
        if (a == 0)
            return 1;
        else
            return this.getTime().compareTo(o.getTime());
    }

}