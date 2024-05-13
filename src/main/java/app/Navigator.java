package app;

import controller.NextStudentController;
import controller.NextTeacherController;
import controller.TeacherSignUpController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.dto.UserDto;

import java.io.IOException;

public class Navigator {
    public final static String LOGIN_PAGE = "login_form.fxml";
    public final static String SIGN_UP_PAGE = "sign_up_form.fxml";
    public  final static String NEXT_STUDENT="next_student.fxml";
    public final static String REGISTER_PAGE="register.fxml";
    public final static String ADMIN_STUDENT_PAGE="admin_students_table.fxml";
    public  final static String NEXT_TEACHER="next_teacher.fxml";




    public static void navigate(Event event, String form){
        Node eventNode = (Node) event.getSource();
        Stage stage = (Stage) eventNode.getScene().getWindow();
        navigate(stage, form);
    }

    public static void navigate(Stage stage, String form){
        Pane formPane = loadPane(form);
        Scene newScene = new Scene(formPane);
        stage.setScene(newScene);
        stage.show();
    }


    public static void navigateWithUserDto( VBox vPane, String form, UserDto userDto) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(form));
            Parent root = loader.load();
            if(userDto.getEmail().contains("@student")){
                NextStudentController controller = loader.getController();
                controller.setUserDto(userDto);
            }else{
                NextTeacherController controller= loader.getController();
                controller.setUserDto(userDto);
            }

            // Merr kontrollin e vPane nga skena aktuale
            vPane.getChildren().setAll(root.getChildrenUnmodifiable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void navigateee(Pane pane, String form, UserDto userDto){
        Pane formPane = loadPaneee(form, userDto);
        if(formPane != null){
            pane.getChildren().clear();
            pane.getChildren().add(formPane);
        }
    }

    private static Pane loadPaneee(String form, UserDto userDto){
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(form));
            Pane formPane = loader.load();

            if(userDto.getEmail().contains("@student")){
                NextStudentController controller = loader.getController();
                controller.setUserDto(userDto);
            } else {
                NextTeacherController controller = loader.getController();
                controller.setUserDto(userDto);
            }

            return formPane;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }




      /*      public static void navigateWithUserDto(ActionEvent event, String form, UserDto userDto) {
                try {
                    FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(form));
                    Parent root = loader.load();
                    if(userDto.getEmail().contains("@student")){
                        NextStudentController controller = loader.getController();
                        controller.setUserDto(userDto);
                    }else{
                        NextTeacherController controller= loader.getController();
                        controller.setUserDto(userDto);
                    }

                    // Skena e re
                    Scene scene = new Scene(root);
                    //Skena e skenës së vjetër
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/

    public static void navigate(Pane pane, String form){
        Pane formPane = loadPane(form);
        pane.getChildren().clear();
        pane.getChildren().add(formPane);
    }

    private static Pane loadPane(String form){
        FXMLLoader loader = new FXMLLoader(
                Navigator.class.getResource(form)
        );
        try {
            return loader.load();
        }catch (IOException ioe){
            return null;
        }
    }


}