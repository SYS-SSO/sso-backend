package com.example.wcnm.DTO;

//import com.github.pagehelper.Page;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
public class ResultDTO<T> {

//    @Tolerate
//    public ResultDTO(){}
    private Integer code=200;
    private String msg;
    private T body;

    private Page page;
}
