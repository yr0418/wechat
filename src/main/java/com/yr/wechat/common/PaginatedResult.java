package com.yr.wechat.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.Hashtable;

@Accessors(chain = true)
@NoArgsConstructor
@Data
@ToString
public class PaginatedResult implements Serializable {
    private int currentPage; // Current page number
    private int count; // Number of total pages
    private Object data; // Paginated resources
    private Dictionary<String, Object> dictionary = new Hashtable<>(); // dictionary of related result
}
