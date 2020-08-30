package cn.wf.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Order {

    private String accountid;
    private String goodtype;
    private Date time;

}
