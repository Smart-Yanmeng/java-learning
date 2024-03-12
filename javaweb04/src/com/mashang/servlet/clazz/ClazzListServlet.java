package com.mashang.servlet.clazz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashang.model.ResultListView;
import com.mashang.model.clazzModel.ClazzListInfo;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/class/list")
public class ClazzListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        String classNo = req.getParameter("classNo");
        String name = req.getParameter("name");
        String type = req.getParameter("type");

        Connection conn = null;
        PreparedStatement statementMain = null;
        PreparedStatement statementTol = null;
        ResultSet resultSet = null;
        String querySql = null;

        Integer total = 0;

        try {
            if (pageNum == null) {
                pageNum = "1";
            }
            int pageIndex = (Integer.valueOf(pageNum) - 1) * 10;

            String whereStr = " WHERE  1=1";
            if (classNo != null && !"".equals(classNo)) {
                whereStr = whereStr + " AND class_no LIKE '%" + classNo + "%'";
            }
            if (name != null && !"".equals(name)) {
                whereStr = whereStr + " AND name LIKE '%" + name + "%'";
            }
            if (type != null && !"".equals(type)) {
                whereStr = whereStr + " AND type = " + type;
            }

            querySql = "SELECT * FROM t_class " + whereStr + " LIMIT " + pageIndex + ", " + pageSize;
            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(querySql);
            resultSet = statementMain.executeQuery();

            List<ClazzListInfo> clazzListInfoList = new ArrayList<>();
            while (resultSet.next()) {
                ClazzListInfo clazzListInfo = new ClazzListInfo();
                clazzListInfo.setClassId(Long.valueOf(resultSet.getString("class_id")));
                clazzListInfo.setClassNo(resultSet.getString("class_no"));
                clazzListInfo.setCreateTime(resultSet.getString("create_time"));
                clazzListInfo.setName(resultSet.getString("name"));
                clazzListInfo.setRemark(resultSet.getString("remark"));
                clazzListInfo.setType(resultSet.getString("type"));

                clazzListInfoList.add(clazzListInfo);
            }

            querySql = "SELECT COUNT(class_id) FROM t_class " + whereStr;
            conn = JDBCUtils.getConnection();
            statementTol = conn.prepareStatement(querySql);
            resultSet = statementTol.executeQuery();

            while (resultSet.next()) {
                total = resultSet.getInt("COUNT(class_id)");
            }

            ResultListView<ClazzListInfo> resultListView = new ResultListView<>();
            resultListView.setRows(clazzListInfoList);
            resultListView.setTotal(total);

            // 返回数据给前端
            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String result = objectMapper.writeValueAsString(resultListView);
            resp.getWriter().write(result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, statementMain, resultSet);
            JDBCUtils.close(conn, statementTol, resultSet);
        }

    }
}