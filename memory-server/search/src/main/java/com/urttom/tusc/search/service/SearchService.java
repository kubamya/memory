package com.urttom.tusc.search.service;

import java.io.IOException;
import java.util.Map;

public interface SearchService {

    Map<String, Object> searchPassaageByTitleAndContent(String keyword) throws IOException;
}
