package com.mashang.servlet.clazz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashang.model.clazzModel.ClazzAllListInfo;
import com.mashang.model.clazzModel.ClazzAllListView;
import com.mashang.util.JDBCUtils;
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

@WebServlet("/class/name")
public class ClazzAllListServlet extends HttpServlet {

    public static List<ClazzAllListInfo> clazzAllListInfoList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String querySql = "SELECT class_id,name FROM t_class";

            conn = JDBCUtils.getConnection();
            statement = conn.prepareStatement(querySql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClazzAllListInfo clazzAllListInfo = new ClazzAllListInfo();

                clazzAllListInfo.setClassId(resultSet.getLong("class_id"));
                clazzAllListInfo.setName(resultSet.getString("name"));

                clazzAllListInfoList.add(clazzAllListInfo);
            }

            ClazzAllListView clazzAllListView = new ClazzAllListView();
            clazzAllListView.setData(clazzAllListInfoList);

            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String result = objectMapper.writeValueAsString(clazzAllListView);
            resp.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement, resultSet);
        }

    }
}
