package com.mxiaixy.web;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Mxia on 2016/12/13.
 */
@WebServlet("/qiniu")
public class qiniuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置ak sk bucketName
        String ak = "VGkEeKQ26PznIkzDDayCWBNOLoIr7w0P2bypouQI";
        String sk = "QTkDDpA8qEDf8ADqz-6RUUvOOjcfYYAF7u94-te2";

        String bucketName = "qiniu";


        Auth auth = Auth.create(ak,sk);//
        System.out.println(auth);

       // String token = auth.uploadToken(bucketName);//获取上传token
        //创建一个map集合  传入回掉函数
        StringMap map = new StringMap();
        map.put("returnUrl","http://localhost:8080/qiniuCallback");
        String token = auth.uploadToken(bucketName,null,5200,map);

        System.out.println(token);

       req.setAttribute("token",token);
       req.getRequestDispatcher("qiniu.jsp").forward(req,resp);
    }
}
