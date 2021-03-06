package client.views.createUser;

import client.model.ClientModel;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.InputUser;

public class createUserViewModel  {

   private ClientModel clientModel;
    private StringProperty CreateUser;
    private StringProperty CreatePassword;
    private StringProperty Error;

    public createUserViewModel(ClientModel clientModel) {
        this.clientModel = clientModel;
        CreateUser = new SimpleStringProperty();
        CreatePassword = new SimpleStringProperty();
        Error = new SimpleStringProperty();

    }

    public void createUser() {
        String CreateUser = this.CreateUser.getValue();
        String CreatePassword = this.CreatePassword.getValue();

        if (CreateUser != null && !"".equals(CreateUser) && CreatePassword != null && !"".equals(CreatePassword)  ) {
            InputUser username = clientModel.username(CreateUser, CreatePassword);
            SaveInfo.getInstance().setUser(username);

            Error.set("successful");
        }

    }

    public boolean userValidation(){
      SaveInfo.getInstance().setUser(clientModel.readUsername(this.CreateUser.getValue()));
      InputUser user = SaveInfo.getInstance().getUser();
      if (user != null){

        if (CreateUser.getValue().equals(user.getOutput())){

            Error.set("Username already exist");
            return false;
        }
      }
        return true;
    }

    public void clearFields() {
        CreateUser.setValue("");
        CreatePassword.setValue("");
        Error.setValue("");

    }

    public boolean validateSignUp(){
        if (attemptCreateUser() && validatePasswords() && validateCreateUserAndCreatePassword() && userValidation()){

            Error.set("successful");
            return true;

        }
        return false;

    }

    public boolean validateCreateUserAndCreatePassword(){
        if (CreatePassword.getValue() == null && CreateUser.getValue() == null) {
            Error.set("Username/password cannot be empty");
            return false;
        }
        if(CreateUser.getValue().contains("#") && CreatePassword.getValue().contains("#")) {
            Error.set("Password/Username cannot contain #");
            return false;
        }else{


            return true;
        }


    }

    public boolean attemptCreateUser() {

        if(CreateUser.getValue() == null) {
            Error.set("Username cannot be empty");
            return false;

        }
        if(CreateUser.getValue().contains("#")) {
           Error.set("Username cannot contain #");
            return false;
        }
        if(CreateUser.getValue().length() < 4) {
            Error.set("Username must contain more than 3 characters");
            return false;
        }
        if(CreateUser.getValue().length() > 14) {
          Error.set("Username must contain less than 15 characters");
            return false;
        } else {

            return true;
        }
    }

    public boolean validatePasswords() {

        if (CreatePassword.getValue() == null && CreateUser.getValue() == null) {
            Error.set("Password cannot be empty");
            return false;
        }
        if (CreatePassword.getValue().length() < 8) {
            Error.set("Password length must be 8 or more");
            return false;
        }
        if (CreatePassword.getValue().length() > 14) {
            Error.set("Password length must be 14 or less");
            return false;
        }

        if (CreatePassword.getValue().contains("#")) {
            Error.set("Password cannot contain #");
            return false;
        }

        if (!CreatePassword.getValue().matches(".*\\d.*")) {
            Error.set("Password must contain at least one number");
            return false;
        } else {

            return true;

        }


    }

    public String getCreateUser() {
        return CreateUser.get();
    }
    public StringProperty createUserProperty() {
        return CreateUser;
    }
    public StringProperty createPasswordProperty() {
        return CreatePassword;
    }
    public StringProperty errorProperty() {
        return Error;
    }



}
