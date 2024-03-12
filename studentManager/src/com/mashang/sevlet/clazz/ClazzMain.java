package com.mashang.sevlet.clazz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashang.model.clazz.ClazzListInfo;
import com.mashang.model.pub.ResultMainView;
import com.mashang.utils.DateUtil;
import com.mashang.utils.IdGen;
import com.mashang.utils.JDBCUtils;
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

@WebServlet("/class1")
public class ClazzMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classId = req.getParameter("classId");

        Connection conn = null;
        PreparedStatement statementMain = null;
        ResultSet rs = null;

        try {
            String querySql = "SELECT * FROM t_class WHERE class_id = ?";

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(querySql);
            statementMain.setString(1, classId);
            rs = statementMain.executeQuery();

            ClazzListInfo clazzListInfo = new ClazzListInfo();

            while (rs.next()) {
                clazzListInfo.setClassId(rs.getLong("class_id"));
                clazzListInfo.setClassNo(rs.getString("class_no"));
                clazzListInfo.setCreateTime(rs.getString("create_time"));
                clazzListInfo.setName(rs.getString("name"));
                clazzListInfo.setRemark(rs.getString("remark"));
                clazzListInfo.setType(rs.getString("type"));
            }

            ResultMainView<ClazzListInfo> resultMainView = new ResultMainView<>();

            resultMainView.setData(clazzListInfo);

            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String rsStr = objectMapper.writeValueAsString(resultMainView);
            resp.getWriter().write(rsStr);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statementMain, rs);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classNo = req.getParameter("classNo");
        String name = req.getParameter("name");
        String remark = req.getParameter("remark");
        String type = req.getParameter("type");
        Long classId = IdGen.gen();
        String createTime = DateUtil.formatDate();

        Connection conn = null;
        PreparedStatement statementMain = null;
        ResultSet rs = null;

        try {
            String updSql = "INSERT INTO t_class(class_id,class_no,create_time,name,remark,type) VALUE(?,?,?,?,?,?)";

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(updSql);
            statementMain.setString(1, String.valueOf(classId));
            statementMain.setString(2, classNo);
            statementMain.setString(3, createTime);
            statementMain.setString(4, name);
            statementMain.setString(5, remark);
            statementMain.setString(6, type);
            int rsInt = statementMain.executeUpdate();

            if (rsInt == 1) {
                System.out.println("Success");
            } else {
                System.out.println("Error");

                return;
            }

            ResultMainView<ClazzListInfo> resultMainView = new ResultMainView<>();

            resultMainView.setData(null);

            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String rsStr = objectMapper.writeValueAsString(resultMainView);
            resp.getWriter().write(rsStr);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statementMain, rs);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement statementMain = null;
        ResultSet rs = null;

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = req.getReader();
            String parameterStr = bufferedReader.readLine();

            String decodeParameterStr = URLDecoder.decode(parameterStr, "utf-8");

            String[] sParameterStrArr = decodeParameterStr.split("&");

            ClazzListInfo clazzListInfo = new ClazzListInfo();

            for (String sParameterStr : sParameterStrArr) {
                String[] ssParameterStrArr = sParameterStr.split("=");

                switch (ssParameterStrArr[0]) {
                    case "classId":
                        clazzListInfo.setClassId(Long.valueOf(ssParameterStrArr[1]));
                        break;
                    case "classNo":
                        clazzListInfo.setClassNo(ssParameterStrArr[1]);
                        break;
                    case "name":
                        clazzListInfo.setName(ssParameterStrArr[1]);
                        break;
                    case "remark":
                        if (ssParameterStrArr.length == 2) {
                            clazzListInfo.setRemark(ssParameterStrArr[1]);
                        }
                        break;
                    case "type":
                        if (ssParameterStrArr.length == 2) {
                            clazzListInfo.setType(ssParameterStrArr[1]);
                        }
                        break;
                }
            }

            String updSql = "UPDATE t_class SET class_no = ?, name = ?, type = ?, remark = ? WHERE class_id = ?";

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(updSql);
            statementMain.setString(1, clazzListInfo.getClassNo());
            statementMain.setString(2, clazzListInfo.getName());
            statementMain.setString(3, clazzListInfo.getType());
            statementMain.setString(4, clazzListInfo.getRemark());
            statementMain.setLong(5, clazzListInfo.getClassId());
            int rsInt = statementMain.executeUpdate();

            if (rsInt == 1) {
                System.out.println("Success");
            } else {
                System.out.println("Error");

                return;
            }

            ResultMainView<ClazzListInfo> resultMainView = new ResultMainView<>();

            resultMainView.setData(null);

            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String rsStr = objectMapper.writeValueAsString(resultMainView);
            resp.getWriter().write(rsStr);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statementMain, rs);
            bufferedReader.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classId = req.getParameter("classId");

        Connection conn = null;
        PreparedStatement statementMain = null;
        ResultSet rs = null;

        // 校验参数
        if (classId == null || "".equals(classId)) {
            System.out.println("Class ID Lost");

            return;
        }

        try {
            String updSql = "DELETE FROM t_class WHERE class_id = ?";

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(updSql);
            statementMain.setString(1, classId);
            int rsInt = statementMain.executeUpdate();

            if (rsInt == 1) {
                System.out.println("Success");
            } else {
                System.out.println("Error");

                return;
            }

            ResultMainView<ClazzListInfo> resultMainView = new ResultMainView<>();

            resultMainView.setData(null);

            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String rsStr = objectMapper.writeValueAsString(resultMainView);
            resp.getWriter().write(rsStr);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statementMain, rs);
        }
    }
}
