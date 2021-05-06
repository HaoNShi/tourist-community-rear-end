package org.csu.travel.domain;

import java.util.Date;

public class Reply implements Comparable<Reply> {
    private Integer replyId;

    private String authorId;

    private Integer commentId;

    private String toUserId;

    private Date replyTime;

    private String contentEx;

    public Reply(Integer replyId, String authorId, Integer commentId, String toUserId, Date replyTime, String contentEx) {
        this.replyId = replyId;
        this.authorId = authorId;
        this.commentId = commentId;
        this.toUserId = toUserId;
        this.replyTime = replyTime;
        this.contentEx = contentEx;
    }

    public Reply() {
        super();
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId == null ? null : toUserId.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getContentEx() {
        return contentEx;
    }

    public void setContentEx(String contentEx) {
        this.contentEx = contentEx == null ? null : contentEx.trim();
    }

    @Override
    public int compareTo(Reply o) {
        if (this.getReplyTime() == null)
            return 1;
        if (o.getReplyTime() == null)
            return -1;
        int a = this.getReplyTime().compareTo(o.getReplyTime());
        // list添加值时如果compareTo返回值为0就不添加了。
        if (a == 0)
            return 1;
        else
            return this.getReplyTime().compareTo(o.getReplyTime());
    }
}