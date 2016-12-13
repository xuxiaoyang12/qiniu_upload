package com.mxiaixy.web;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mxia on 2016/12/13.
 */
@WebServlet("/qiniuCallback")
public class QiniuCallbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadRet = req.getParameter("upload_ret");

        if(StringUtils.isEmpty(uploadRet)){
            resp.sendError(404);
        }else{
            //base64解密
            String result = new String(Base64.decodeBase64(uploadRet));
            //吧获取的JSON转换成map集合
            Gson gson = new Gson();
            Map<String ,Object> map = gson.fromJson(result, HashMap.class);
            //获取上传文件的名称
            String fileName = (String)map.get("key");
            req.setAttribute("fileName",fileName);
            req.getRequestDispatcher("qiniu.jsp").forward(req,resp);
        }
    }
}
