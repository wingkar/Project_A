package com.example.project_a;

public class QnAListDTO {
    //조회수랑 내용이랑 빼고 일단 제목만
    String subject;
    String id;
    String date;
    String readCount;
    int resId;

    public QnAListDTO(String subject, String id, String date, String readCount, int resId) {
        this.subject = subject;
        this.id = id;
        this.date = date;
        this.readCount = readCount;
        this.resId = resId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }
    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
