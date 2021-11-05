package com.project1.Services;

import com.project1.models.gradingFormat;
import com.project1.repository.GradingFormatHBRepo;
import com.project1.repository.gradingFormatRepo;

import java.util.List;

public class GradingFormatServiceImpl implements GradingFormatService{

    gradingFormatRepo gf;

    public GradingFormatServiceImpl(gradingFormatRepo gf) { this.gf = gf;
    }

    @Override
    public gradingFormat getGradingFormat(int id) {
        return gf.getGradingFormat(id);
    }

    @Override
    public gradingFormat addGradingFormat(gradingFormat GF) {
        return gf.addGradingFormat(GF);
    }

    @Override
    public gradingFormat deleteGradingFormat(int id) {
        return gf.deleteGradingFormat(id);
    }

    @Override
    public gradingFormat updateGradingFormat(gradingFormat change) {
        return gf.updateGradingFormat(change);
    }

    @Override
    public List<gradingFormat> getAllFormats() {
        return gf.getAllFormats();
    }
}
