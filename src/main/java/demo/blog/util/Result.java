package demo.blog.util;

import lombok.Data;

import java.util.Objects;

@Data
public class Result<T> {
    private String message;
    private int rtnCode;
    private T data;

    public Result(){

    }
    public Result(int rtnCode,String message){
        this.message = message;
        this.rtnCode = rtnCode;
    }
    public Result(int rtnCode,String message,T data){
        this(rtnCode,message);
        this.data = data;
    }
}
