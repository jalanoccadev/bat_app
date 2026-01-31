package com.jalanocca.bat_backend.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface ExcelChecklistService {
    public ByteArrayInputStream generateExcel() throws IOException;
}
