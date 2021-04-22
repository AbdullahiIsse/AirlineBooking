package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Scene chatScene, loginScene, myflightplanScene, seatScene, passengerScene, paymentScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openToDashView();
    }

    public void openToDashView() {
        try {
            Parent root = loadFXML("../views/dashboard/dashboard.fxml");
            Scene logScene = new Scene(root);
            stage.setTitle("Dashboard");
            stage.setScene(logScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openLoginView() {
        if (loginScene == null) {
            try {
                Parent root = loadFXML("../views/Loginbox/login.fxml");

                stage.setTitle("Login");
                loginScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(loginScene);
        stage.show();
    }

    public void openToMyFlightPlan() {
        if (myflightplanScene == null) {
            try {
                Parent root = loadFXML("../views/myflightplan/myflightplan.fxml");

                stage.setTitle("MyFlightPlan");
                myflightplanScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(myflightplanScene);
        stage.show();
    }

    public void openSeat() {
        if (seatScene == null) {
            try {
                Parent root = loadFXML("../views/seat/seat.fxml");

                stage.setTitle("seat");
                seatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(seatScene);
        stage.show();
    }


    public void openToChatView() {
        if (chatScene == null) {
            try {
                Parent root = loadFXML("../views/chat/chat.fxml");

                stage.setTitle("Chat");
                chatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(chatScene);
        stage.show();
    }

    public void openPassengerView() {
        if (passengerScene == null) {
            try {
                Parent root = loadFXML("../views/passenger/passenger.fxml");

                stage.setTitle("passenger");
                passengerScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(passengerScene);
        stage.show();
    }

    public void openPaymentView() {
        if (paymentScene == null) {
            try {
                Parent root = loadFXML("../views/Payment/payment.fxml");

                stage.setTitle("payment");
                paymentScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(paymentScene);
        stage.show();
    }


    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController vc = loader.getController();
        vc.init(this, vmf);
        return root;
    }
}
