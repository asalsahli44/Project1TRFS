package com.project1.Services;

import com.project1.models.gradingFormat;

import java.util.List;

public interface GradingFormatService {
    public gradingFormat getGradingFormat(int id);
    public gradingFormat addGradingFormat(gradingFormat GF);
    public gradingFormat deleteGradingFormat(int id);
    public gradingFormat updateGradingFormat(gradingFormat change);
    public List<gradingFormat> getAllFormats();
}
