package com.urttom.tusc.search.consts;

import java.util.HashMap;
import java.util.Map;

public class TstcEsMappingTemplate {

    public static final Map<String, Object> PASSAGE_MAPPING_TEMPLATE = new HashMap<String, Object>(){{
        put("mappings", new HashMap<String, Object>(){{
            put("properties", new HashMap<String, Object>(){{
                put("id", new HashMap<String, String>(){{
                    put("type", "keyword");
                }});
                put("title", new HashMap<String, String>(){{
                    put("type", "text");
                    put("analyzer", "standard");
                }});
                put("content", new HashMap<String, Object>(){{
                    put("type", "text");
                    put("analyzer", "standard");
                }});
            }});
        }});
    }};
}
