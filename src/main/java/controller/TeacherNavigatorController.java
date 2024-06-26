package controller;
import app.Navigator;
import app.SessionManager.StudentSession;
import app.SessionManager.TeacherSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.Students;
import model.Teacher;
import service.GradeLevelService;
import service.GradeService;
import service.SchoolService;
import service.TeacherService;

public class TeacherNavigatorController {
    @FXML
    private HBox root;

    @FXML
    private AnchorPane dashBo;



    @FXML
    void dashboard(MouseEvent event) {
        Navigator.navigate(dashBo,Navigator.TEACHER_DASHBOARD);

    }
    @FXML
    void addgrade(MouseEvent event) {
        Navigator.navigate(dashBo,Navigator.TEACHER_TABLE);


    }

    @FXML
    void help(MouseEvent event) {

        Navigator.navigate(dashBo,Navigator.HELP_PAGE);
    }

    @FXML
    void profile(MouseEvent event) {
        Navigator.navigate(dashBo,Navigator.TEACHER_PROFILE);

    }
    @FXML
    private Label navName;{

    }

    @FXML
    void handleLogOutCLick(ActionEvent event) {
        TeacherSession.setTeacher(null);
        Navigator.navigate(event, Navigator.LOGIN_PAGE);
    }

    public void initialize() {

        navName.setText(TeacherSession.getTeacher().getFirstName()+ " "+TeacherSession.getTeacher().getLastName());


    }


}
