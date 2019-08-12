package com.qa.portal.feedback.persistence.entity;

import com.qa.portal.common.persistence.entity.QuestionCategoryResponseEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(schema="training", name="question_category_response")
@DiscriminatorValue(value = "EVALUATION")
public class EvalQuestionCategoryResponseEntity extends QuestionCategoryResponseEntity 
{

    @ManyToOne
    @JoinColumn(name = "cohort_course_evaluation_id")
    private CohortCourseEvaluationEntity courseEvaluation;

    public CohortCourseEvaluationEntity getCourseEvaluation() {
        return courseEvaluation;
    }

    public void setCourseEvaluation(CohortCourseEvaluationEntity courseEvaluation) {
        this.courseEvaluation = courseEvaluation;
    }
}
