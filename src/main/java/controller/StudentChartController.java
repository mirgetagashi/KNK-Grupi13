package controller;

import app.SessionManager.StudentSession;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import model.Students;
import service.GradeService;
import service.StudentService;
import service.TeacherDashboardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentChartController {

    @FXML
    private Label studentNameLabel;

    @FXML
    private LineChart<String, Number> gradesLineChart;

    @FXML
    private PieChart gradeChart;

    @FXML
    private Label avGrade;

    @FXML
    private Label passedSubjects;





    public void initialize() {
        studentNameLabel.setText(StudentSession.getStudent().getFirstName());

        Students loggedStudent=StudentSession.getStudent();
        int loggedStudentId=loggedStudent.getId();
        String studentName=loggedStudent.getFirstName();
        studentNameLabel.setText(studentName);

        List<Integer> gradeList = StudentService.getGradesByStudent(loggedStudentId);

        int length = gradeList.size();
        passedSubjects.setText(String.valueOf(length));


         double averageGrade= GradeService.calculateAverageFinalGradeStudent(loggedStudentId);
         avGrade.setText(String.format("%.2f",averageGrade));
        int[] gradeCounts = new int[6];
        for (int grade : gradeList) {
            gradeCounts[grade]++;
        }

        List<PieChart.Data> pieChartData = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            pieChartData.add(new PieChart.Data("Grade " + i, gradeCounts[i]));
        }

        gradeChart.getData().addAll(pieChartData);


    }


}
