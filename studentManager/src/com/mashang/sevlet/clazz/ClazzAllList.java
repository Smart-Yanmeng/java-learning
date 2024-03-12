package com.mashang.sevlet.clazz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashang.model.clazz.ClazzAllListInfo;
import com.mashang.model.clazz.ResultAllListView;
import com.mashang.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/class1/name")
public class ClazzAllList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement statementMain = null;
        ResultSet rs = null;

        try {
            String querySql = "SELECT class_id,name FROM t_class";

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(querySql);
            rs = statementMain.executeQuery();

            List<ClazzAllListInfo> clazzAllListInfoList = new ArrayList<>();
            while (rs.next()) {
                ClazzAllListInfo clazzAllListInfo = new ClazzAllListInfo();

                clazzAllListInfo.setClassId(rs.getLong("class_id"));
                clazzAllListInfo.setName(rs.getString("name"));

                clazzAllListInfoList.add(clazzAllListInfo);
            }

            ResultAllListView resultAllListView = new ResultAllListView();

            resultAllListView.setData(clazzAllListInfoList);

            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String rsStr = objectMapper.writeValueAsString(resultAllListView);
            resp.getWriter().write(rsStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statementMain, rs);
        }
    }
}
