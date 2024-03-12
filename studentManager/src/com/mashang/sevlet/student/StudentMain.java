package com.mashang.sevlet.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashang.model.pub.ResultMainView;
import com.mashang.model.student.StudentListInfo;
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

@WebServlet("/student1")
public class StudentMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");

        Connection conn = null;
        PreparedStatement statementMain = null;
        ResultSet rs = null;

        try {
            String querySql = "SELECT * FROM t_student WHERE student_id = " + studentId;

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(querySql);
            rs = statementMain.executeQuery();

            StudentListInfo studentListInfo = new StudentListInfo();
            while (rs.next()) {
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
            }

            ResultMainView<StudentListInfo> resultMainView = new ResultMainView<>();

            resultMainView.setData(studentListInfo);

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
        String name = req.getParameter("name");
        String studentNo = req.getParameter("studentNo");
        String age = req.getParameter("age");
        String classId = req.getParameter("classId");
        String phone = req.getParameter("phone");
        String remark = req.getParameter("remark");
        String sex = req.getParameter("sex");
        Long studentId = IdGen.gen();

        Connection conn = null;
        PreparedStatement statementMain = null;
        ResultSet rs = null;

        try {
            String updSql = "INSERT INTO t_student(student_id,student_no,name,age,sex,class_id,phone,remark) VALUE(?,?,?,?,?,?,?,?)";

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(updSql);
            statementMain.setLong(1, studentId);
            statementMain.setString(2, studentNo);
            statementMain.setString(3, name);
            statementMain.setString(4, age);
            statementMain.setString(5, sex);
            statementMain.setString(6, classId);
            statementMain.setString(7, phone);
            statementMain.setString(8, remark);
            int rsInt = statementMain.executeUpdate();

            if (rsInt == 1) {
                System.out.println("Success");
            } else {
                System.out.println("Error");
                resp.getWriter().write("Error");

                return;
            }

            ResultMainView<StudentListInfo> resultMainView = new ResultMainView<>();
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

            StudentListInfo studentListInfo = new StudentListInfo();

            for (String sParameterStr : sParameterStrArr) {
                String[] ssParameterStrArr = sParameterStr.split("=");

                switch (ssParameterStrArr[0]) {
                    case "name":
                        studentListInfo.setName(ssParameterStrArr[1]);
                        break;
                    case "studentId":
                        studentListInfo.setStudentId(Long.valueOf(ssParameterStrArr[1]));
                        break;
                    case "studentNo":
                        studentListInfo.setStudentNo(ssParameterStrArr[1]);
                        break;
                    case "age":
                        if (ssParameterStrArr.length == 2) {
                            studentListInfo.setAge(Integer.valueOf(ssParameterStrArr[1]));
                        }
                        break;
                    case "classId":
                        if (ssParameterStrArr.length == 2) {
                            studentListInfo.setClassId(Long.valueOf(ssParameterStrArr[1]));
                        }
                        break;
                    case "phone":
                        if (ssParameterStrArr.length == 2) {
                            studentListInfo.setPhone(ssParameterStrArr[1]);
                        }
                        break;
                    case "remark":
                        if (ssParameterStrArr.length == 2) {
                            studentListInfo.setRemark(ssParameterStrArr[1]);
                        }
                        break;
                    case "sex":
                        if (ssParameterStrArr.length == 2) {
                            studentListInfo.setSex(ssParameterStrArr[1]);
                        }
                        break;
                }
            }

            conn = JDBCUtils.getConnection();
            String updSql = "UPDATE t_student SET student_no = ?, name = ?, age = ?, sex = ?, phone = ?, class_id = ?, remark = ? WHERE student_id = ?";
            statementMain = conn.prepareStatement(updSql);
            statementMain.setString(1, studentListInfo.getStudentNo());
            statementMain.setString(2, studentListInfo.getName());
            statementMain.setInt(3, studentListInfo.getAge());
            statementMain.setString(4, studentListInfo.getSex());
            statementMain.setString(5, studentListInfo.getPhone());
            statementMain.setLong(6, studentListInfo.getClassId());
            statementMain.setString(7, studentListInfo.getRemark());
            statementMain.setLong(8, studentListInfo.getStudentId());
            int rsInt = statementMain.executeUpdate();

            if (rsInt == 1) {
                System.out.println("Success");
            } else {
                System.out.println("Error");

                return;
            }

            ResultMainView<StudentListInfo> resultMainView = new ResultMainView<>();

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
        String studentId = req.getParameter("studentId");

        // 校验参数
        if (studentId == null || "".equals(studentId)) {
            resp.getWriter().write("Student ID Lost");
        }

        Connection conn = null;
        PreparedStatement statementMain = null;
        ResultSet rs = null;

        try {
            String updSql = "DELETE FROM t_student WHERE student_id = ?";

            conn = JDBCUtils.getConnection();
            statementMain = conn.prepareStatement(updSql);
            statementMain.setString(1, studentId);
            int rsInt = statementMain.executeUpdate();

            if (rsInt == 1) {
                System.out.println("Success");
            } else {
                System.out.println("Error");

                return;
            }

            ResultMainView<StudentListInfo> resultMainView = new ResultMainView<>();

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
