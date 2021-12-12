package com.urttom.tusc.search.service;

import com.urttom.tusc.search.module.TstcPassage;

import java.io.IOException;

public interface DocumentService {

    void deletePassageFromEs(String id) throws IOException;

    TstcPassage getPassageFromEs(String id) throws IOException;

    void addPassage(TstcPassage passage) throws IOException;
}
