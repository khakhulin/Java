package com.netcracker.hibernateForCornar.dao;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Taras on 24.10.2016.
 */
@Entity
@Table(name = "LESSONS", schema = "JAVA_PROJECT")
public class LessonsEntity {
    private long lessonId;
    private String lessonName;
    private String courseId;
    private Long price;
    private Time dateCourse;

    @Id
    @Column(name = "LESSON_ID", nullable = false, precision = 0)
    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    @Basic
    @Column(name = "LESSON_NAME", nullable = false, length = 50)
    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Basic
    @Column(name = "COURSE_ID", nullable = false, length = 20)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "PRICE", nullable = true, precision = 0)
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "DATE_COURSE", nullable = true)
    public Time getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(Time dateCourse) {
        this.dateCourse = dateCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonsEntity that = (LessonsEntity) o;

        if (lessonId != that.lessonId) return false;
        if (lessonName != null ? !lessonName.equals(that.lessonName) : that.lessonName != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (dateCourse != null ? !dateCourse.equals(that.dateCourse) : that.dateCourse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (lessonId ^ (lessonId >>> 32));
        result = 31 * result + (lessonName != null ? lessonName.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (dateCourse != null ? dateCourse.hashCode() : 0);
        return result;
    }
}
