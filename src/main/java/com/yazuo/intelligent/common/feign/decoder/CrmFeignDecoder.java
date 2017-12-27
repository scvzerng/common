package com.yazuo.intelligent.common.feign.decoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yazuo.intelligent.common.exception.BusinessException;
import com.yazuo.intelligent.common.exception.HttpException;
import com.yazuo.intelligent.common.exception.utils.ExceptionUtils;
import com.yazuo.intelligent.common.response.GenericResponse;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * description
 * <p>
 * 2017-12-27 11:19
 *
 * @author scvzerng
 **/
public class CrmFeignDecoder implements Decoder {
    @Override
    public Object decode(Response response, Type type) throws IOException,DecodeException, FeignException {
        if(response.status()!=200){
            throw new HttpException(response.status(),response.reason(),null);
        }
        try {
            GenericResponse<String> result = JSONObject.parseObject(response.body().asInputStream(), Charset.forName("UTF-8"),        new TypeReference<GenericResponse<String>>(){}.getType());
            if(result.getCode()==200){
                return JSON.parseObject(result.getData(),type);
            }else{
                BusinessException businessException = new BusinessException(result.getCode(),result.getMessage(),null);
                businessException.setStackInfo(result.getStackInfo());
                businessException.setTradeId(result.getTradeId());

                throw businessException;
            }
        }catch (Exception e){
            throw new DecodeException(ExceptionUtils.exceptionToString(e));
        }

    }
}
