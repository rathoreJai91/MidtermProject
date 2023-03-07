package com.medicorps.service;

import com.medicorps.dto.ReportsDto;

public interface ReportService {

	ReportsDto generateReport(ReportsDto reportsDto);
	ReportsDto viewFullReportbyPatientId(int id);
	
	
}
