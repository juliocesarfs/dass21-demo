package com.cis.dass21.domain.participant.utils;

import com.cis.dass21.domain.participant.enums.EnumDASS21Classification;

public class DASS21Classification {

    public String getDepressionScale(Integer depressionScore) {

        String scale = "";
        if (depressionScore >= 0 && depressionScore <= 4) {
            scale = EnumDASS21Classification.NO_SYMPTOMS.getClassification();
        } else if (depressionScore >= 5 && depressionScore <= 6) {
            scale = EnumDASS21Classification.MILD_SYMPTOMS.getClassification();
        } else if (depressionScore >= 7 && depressionScore <= 10) {
            scale = EnumDASS21Classification.MODERATE_SYMPTOMS.getClassification();
        } else if (depressionScore >= 11 && depressionScore <= 13) {
            scale = EnumDASS21Classification.SEVERE_SYMPTOMS.getClassification();
        } else if (depressionScore >= 14) {
            scale = EnumDASS21Classification.VERY_SERIOUS_SYMPTOMS.getClassification();
        }

        return scale;
    }

    public String getAnxietyScale(Integer anxietyScore) {

        String scale = "";
        if (anxietyScore >= 0 && anxietyScore <= 3) {
            scale = EnumDASS21Classification.NO_SYMPTOMS.getClassification();
        } else if (anxietyScore >= 4 && anxietyScore <= 5) {
            scale = EnumDASS21Classification.MILD_SYMPTOMS.getClassification();
        } else if (anxietyScore >= 6 && anxietyScore <= 7) {
            scale = EnumDASS21Classification.MODERATE_SYMPTOMS.getClassification();
        } else if (anxietyScore >= 8 && anxietyScore <= 9) {
            scale = EnumDASS21Classification.SEVERE_SYMPTOMS.getClassification();
        } else if (anxietyScore >= 10) {
            scale = EnumDASS21Classification.VERY_SERIOUS_SYMPTOMS.getClassification();
        }

        return scale;
    }

    public String getStressScale(Integer stressScore) {

        String scale = "";
        if (stressScore >= 0 && stressScore <= 7) {
            scale = EnumDASS21Classification.NO_SYMPTOMS.getClassification();
        } else if (stressScore >= 8 && stressScore <= 9) {
            scale = EnumDASS21Classification.MILD_SYMPTOMS.getClassification();
        } else if (stressScore >= 10 && stressScore <= 12) {
            scale = EnumDASS21Classification.MODERATE_SYMPTOMS.getClassification();
        } else if (stressScore >= 13 && stressScore <= 16) {
            scale = EnumDASS21Classification.SEVERE_SYMPTOMS.getClassification();
        } else if (stressScore >= 17) {
            scale = EnumDASS21Classification.VERY_SERIOUS_SYMPTOMS.getClassification();
        }

        return scale;
    }
}
