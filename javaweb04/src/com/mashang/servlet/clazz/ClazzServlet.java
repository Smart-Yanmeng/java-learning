package com.mashang.servlet.clazz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashang.model.clazzModel.ClazzView;
import com.mashang.model.clazzModel.Data;
import com.mashang.util.DateUtil;
import com.mashang.util.IdGen;
import com.mashang.util.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/class")
public class ClazzServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classId = req.getParameter("classId");

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection();
            String querySql = "SELECT * FROM t_class WHERE class_id = " + classId;
            statement = conn.prepareStatement(querySql);
            resultSet = statement.executeQuery();

            Data data = new Data(null, null, null, null, null, null);

            while (resultSet.next()) {
                data.setClassId(resultSet.getLong("class_id"));
                data.setClassNo(resultSet.getString("class_no"));
                data.setCreateTime(resultSet.getString("create_time"));
                data.setName(resultSet.getString("name"));
                data.setRemark(resultSet.getString("remark"));
                data.setType(resultSet.getString("type"));
            }

            ClazzView clazzView = new ClazzView();
            clazzView.setData(data);

            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String result = objectMapper.writeValueAsString(clazzView);
            resp.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement, resultSet);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String classNo = req.getParameter("classNo");
        String createTime = DateUtil.formatDate();
        String name = req.getParameter("name");
        String remark = req.getParameter("remark");
        String type = req.getParameter("type");

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection();

            Long classId = IdGen.gen();
            String insertSql = "insert into t_class(class_id,class_no,create_time,name,remark,type) value(?,?,?,?,?,?)";

            statement = conn.prepareStatement(insertSql);
            statement.setLong(1, classId);
            statement.setString(2, classNo);
            statement.setString(3, createTime);
            statement.setString(4, name);
            statement.setString(5, remark);
            statement.setString(6, type);

            int resultUpd = statement.executeUpdate();

            if (resultUpd == 1) {
                System.out.println("Done!");
            } else {
                System.out.println("Error!");
                resp.getWriter().write("Error!");

                return;
            }

            Data data = new Data(null, null, null, null, null, null);
            ClazzView clazzView = new ClazzView();
            clazzView.setData(data);

            // 返回数据给前端
            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String result = objectMapper.writeValueAsString(clazzView);
            resp.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement, resultSet);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = req.getReader();
            String parameterStr = bufferedReader.readLine();

            String decodeParameterStr = URLDecoder.decode(parameterStr, "utf-8");

            String[] sParameterStrArr = decodeParameterStr.split("&");
            Data data = new Data(null, null, null, null, null, null);
            for (String sParameterStr : sParameterStrArr) {
                String[] ssParameterStrArr = sParameterStr.split("=");

                switch (ssParameterStrArr[0]) {
                    case "classId":
                        data.setClassId(Long.valueOf(ssParameterStrArr[1]));
                        break;
                    case "classNo":
                        data.setClassNo(ssParameterStrArr[1]);
                        break;
                    case "createTime":
                        data.setCreateTime(ssParameterStrArr[1]);
                        break;
                    case "name":
                        data.setName(ssParameterStrArr[1]);
                        break;
                    case "remark":
                        data.setRemark(ssParameterStrArr[1]);
                        break;
                    case "type":
                        data.setType(ssParameterStrArr[1]);
                        break;
                }
            }

            conn = JDBCUtils.getConnection();
            String updSql = "UPDATE t_class SET class_no = ?, name = ?, remark = ?, type = ? WHERE class_id = ?";
            statement = conn.prepareStatement(updSql);
            statement.setString(1, data.getClassNo());
            statement.setString(2, data.getName());
            statement.setString(3, data.getRemark());
            statement.setString(4, data.getType());
            statement.setLong(5, data.getClassId());

            int res = statement.executeUpdate();
            System.out.println(res);

            ClazzView clazzView = new ClazzView();

            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String result = objectMapper.writeValueAsString(clazzView);
            resp.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement, resultSet);
            bufferedReader.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classId = req.getParameter("classId");

        // 校验参数
        if (classId == null || "".equals(classId)) {
            resp.getWriter().write("classId is NULL");
            return;
        }

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection();
            String delSql = "DELETE FROM t_class WHERE class_id = ?";
            statement = conn.prepareStatement(delSql);

            statement.setString(1, classId);

            int res = statement.executeUpdate();
            System.out.println(res);

            ClazzView clazzView = new ClazzView();

            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String result = objectMapper.writeValueAsString(clazzView);
            resp.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement, resultSet);
        }

    }
}