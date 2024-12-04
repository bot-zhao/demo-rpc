package com.demo.common.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaocc
 * @version 1.0
 * @date 2024-12-04 19:05
 */
@Builder
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
