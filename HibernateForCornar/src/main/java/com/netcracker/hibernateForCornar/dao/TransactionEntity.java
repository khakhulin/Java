package com.netcracker.hibernateForCornar.dao;

import javax.persistence.*;

/**
 * Created by Taras on 24.10.2016.
 */
@Entity
@Table(name = "TRANSACTION", schema = "JAVA_PROJECT")
@IdClass(TransactionEntityPK.class)
public class TransactionEntity {
    private long transactionId;
    private long lessonId;
    private long studentId;

    @Id
    @Column(name = "TRANSACTION_ID", nullable = false, precision = 0)
    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "LESSON_ID", nullable = false, precision = 0)
    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    @Id
    @Column(name = "STUDENT_ID", nullable = false, precision = 0)
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (transactionId != that.transactionId) return false;
        if (lessonId != that.lessonId) return false;
        if (studentId != that.studentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (transactionId ^ (transactionId >>> 32));
        result = 31 * result + (int) (lessonId ^ (lessonId >>> 32));
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        return result;
    }
}
