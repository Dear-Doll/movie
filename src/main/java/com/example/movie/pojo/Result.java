package com.example.movie.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 这是一个封装好的,用来对信息进行统一调用管理的类
 * <T>:表示泛型,那么在类名上面定义了这个T之后其余的类只要想要调用这个类,T的部分就是这个类的
 *     对象名.这个类中所有的方法中凡是涉及到T的部分就全部都会统一进行管理
 * @param <T>
 */
@Data
@Accessors(chain = true)//链式调用,在一个方法中可以表示多个状态
public class Result<T> {
    private Boolean success;//表示成功 true  表示失败 false
    private Integer code;//状态码 404 200 500 405
    private String message;//消息 "登录成功" "登录失败"等
    private T data;//传输数据.比如对象信息

    /**
     * 这是一个创建消息结果的一个类
     * @param success 是否成功
     * @param code 状态信息
     * @param message 传输字符串信息
     * @param data 数据对象
     * @param <T> 类型
     * @return
     */
    public static <T> Result<T> createResult(Boolean success,Integer code,String message,T data){
        //创建一个对象用来将状态信息返回
        Result<T> result = new Result<>();
        //对象信息的赋值
        result.setSuccess(success);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    //分组,分情况进行讨论

    /**
     * 传入对象之后判断对象信息是否成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return createResult(true,200,"请求成功!",data);
    }

    /**
     * 传入对象和信息,进行判断
     * @param msg 比如:登录成功,请求成功...
     * @param data 对象信息
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(String msg,T data){
        return createResult(true,200,msg,data);
    }

    public static <T> Result<T> fail(String msg){
        return createResult(false,400,msg,null);
    }

    public static <T> Result<T> fail(Integer code,String msg){
        return createResult(false,code,msg,null);
    }

    public static <T> Result<T> fail(Integer code,String msg, T data){
        return createResult(false,code,msg,data);
    }

}
