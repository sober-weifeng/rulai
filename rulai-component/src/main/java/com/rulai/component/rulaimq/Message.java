package com.rulai.component.rulaimq;

import lombok.Data;

import java.io.Serializable;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/10 15:41
 */
@Data
public class Message<T> implements Serializable {

    private static final long serialVersionUID = -6639671827455299399L;
    
    private String topic;
    
    private String content;
    
    private T body;
    
}
