package com.mashang.sevlet.clazz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashang.model.clazz.ClazzListInfo;
import com.mashang.model.pub.ResultListView;
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

@WebServlet("/class1/list")
public class ClazzList extends HttpServlet {
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
        ResultSet rs = null;

        Integer total = 0;

        if (pageNum == null) {
            pageNum = "1";
        }
        if (pageSize == null) {
            pageSize = "10";
        }

        try {
            Integer pageIndex = (Integer.parseInt(pageNum) - 1) * 10;

            String whereSql = " WHERE 1=1";

            if (classNo != null && !"".equals(classNo)) {
                whereSql = whereSql + " AND class_no LIKE '%" + classNo + "%'";
            }
            if (name != null && !"".equals(name)) {
                whereSql = whereSql + " AND name LIKE '%" + name + "%'";
            }

            String querySql = "SELECT * FROM t_class" + whereSql + " LIMIT " + pageIndex + ", " + pageSize;

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(querySql);
            rs = statementMain.executeQuery();

            List<ClazzListInfo> clazzListInfoList = new ArrayList<>();
            while (rs.next()) {
                ClazzListInfo clazzListInfo = new ClazzListInfo();

                clazzListInfo.setClassId(rs.getLong("class_id"));
                clazzListInfo.setClassNo(rs.getString("class_no"));
                clazzListInfo.setCreateTime(rs.getString("create_time"));
                clazzListInfo.setName(rs.getString("name"));
                clazzListInfo.setRemark(rs.getString("remark"));
                clazzListInfo.setType(rs.getString("type"));

                clazzListInfoList.add(clazzListInfo);
            }

            querySql = "SELECT COUNT(class_id) FROM t_class" + whereSql;

            conn = JDBCUtils.getConnection();
            statementTol = conn.prepareStatement(querySql);
            rs = statementTol.executeQuery();

            while (rs.next()) {
                total = rs.getInt("COUNT(class_id)");
            }

            ResultListView<ClazzListInfo> resultListView = new ResultListView<>();
            resultListView.setTotal(total);
            resultListView.setRows(clazzListInfoList);

            // 返回数据给前端
            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String rsStr = objectMapper.writeValueAsString(resultListView);
            resp.getWriter().write(rsStr);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statementMain, rs);
            JDBCUtils.close(conn, statementTol, rs);
        }
    }
}
