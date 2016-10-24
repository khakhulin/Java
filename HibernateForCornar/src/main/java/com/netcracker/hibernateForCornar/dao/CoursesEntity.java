package com.netcracker.hibernateForCornar.dao;

import javax.persistence.*;

/**
 * Created by Taras on 24.10.2016.
 */
@Entity
@Table(name = "COURSES", schema = "JAVA_PROJECT")
public class CoursesEntity {
    private long courseId;
    private String courseName;
    private long userId;
    private String cDescription;

    @Id
    @Column(name = "COURSE_ID", nullable = false, precision = 0)
    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "COURSE_NAME", nullable = false, length = 120)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "USER_ID", nullable = false, precision = 0)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "C_DESCRIPTION", nullable = true, length = 200)
    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursesEntity that = (CoursesEntity) o;

        if (courseId != that.courseId) return false;
        if (userId != that.userId) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (cDescription != null ? !cDescription.equals(that.cDescription) : that.cDescription != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (courseId ^ (courseId >>> 32));
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (cDescription != null ? cDescription.hashCode() : 0);
        return result;
    }
}
