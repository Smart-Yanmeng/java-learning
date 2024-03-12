package com.mashang.sevlet.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashang.model.student.StudentListInfo;
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

@WebServlet("/student1/list")
public class StudentList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        String name = req.getParameter("name");
        String studentNo = req.getParameter("studentNo");

        Integer total = 0;

        if (pageNum == null) {
            pageNum = "1";
        }
        if (pageSize == null) {
            pageSize = "10";
        }

        Connection conn = null;
        PreparedStatement statementMain = null;
        PreparedStatement statementTol = null;
        ResultSet rs = null;

        try {
            Integer pageIndex = (Integer.parseInt(pageNum) - 1) * 10;

            String whereSql = " WHERE 1=1";

            if (studentNo != null && !"".equals(studentNo)) {
                whereSql = whereSql + " AND student_no LIKE '%" + studentNo + "%'";
            }
            if (name != null && !"".equals(name)) {
                whereSql = whereSql + " AND name LIKE '%" + name + "%'";
            }

            String querySql = "SELECT * FROM t_student" + whereSql + " LIMIT " + pageIndex + ", " + pageSize;

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(querySql);
            rs = statementMain.executeQuery();

            List<StudentListInfo> studentListInfoList = new ArrayList<>();
            while (rs.next()) {
                StudentListInfo studentListInfo = new StudentListInfo();

                studentListInfo.setAge(rs.getInt("age"));
                studentListInfo.setClassId(rs.getLong("class_id"));
                studentListInfo.setClassName(rs.getString("class_name"));
                studentListInfo.setCreateTime(rs.getString("create_time"));
                studentListInfo.setName(rs.getString("name"));
                studentListInfo.setPhone(rs.getString("phone"));
                studentListInfo.setRemark(rs.getString("remark"));
                studentListInfo.setSex(rs.getString("sex"));
                studentListInfo.setStudentId(rs.getLong("student_id"));
                studentListInfo.setStudentNo(rs.getString("student_no"));

                studentListInfoList.add(studentListInfo);
            }

            querySql = "SELECT COUNT(student_id) FROM t_student" + whereSql;

            conn = JDBCUtils.getConnection();
            statementTol = conn.prepareStatement(querySql);
            rs = statementTol.executeQuery();

            while (rs.next()) {
                total = rs.getInt("COUNT(student_id)");
            }

            ResultListView<StudentListInfo> resultListView = new ResultListView<>();
            resultListView.setRows(studentListInfoList);
            resultListView.setTotal(total);

            // 返回数据给前端
            ObjectMapper objectMapper = new ObjectMapper();
            resp.setContentType("text/html;charset=utf-8");
            String rsStr = objectMapper.writeValueAsString(resultListView);
            resp.getWriter().write(rsStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statementMain, rs);
        }
    }
}
