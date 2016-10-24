package com.netcracker.hibernateForCornar.dao;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Taras on 24.10.2016.
 */
public class TransactionEntityPK implements Serializable {
    private long transactionId;
    private long studentId;

    @Column(name = "TRANSACTION_ID", nullable = false, precision = 0)
    @Id
    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    @Column(name = "STUDENT_ID", nullable = false, precision = 0)
    @Id
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

        TransactionEntityPK that = (TransactionEntityPK) o;

        if (transactionId != that.transactionId) return false;
        if (studentId != that.studentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (transactionId ^ (transactionId >>> 32));
        result = 31 * result + (int) (studentId ^ (studentId >>> 32));
        return result;
    }
}
