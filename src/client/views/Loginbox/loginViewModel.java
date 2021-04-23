package client.views.Loginbox;

import client.core.ViewHandler;
import client.model.ClientText;
import client.views.chat.chatViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class loginViewModel {
    private ClientText clientText;
    private StringProperty navn;
    private StringProperty kode;
    private StringProperty error;

    public StringProperty errorProperty() {
        return error;
    }
    public StringProperty navnProperty() {
        return navn;
    }
    public StringProperty kodeProperty() {
        return kode;
    }

    public loginViewModel(ClientText clientText) {
        this.clientText = clientText;
        navn = new SimpleStringProperty();
        kode = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    public void printNavn() {
        String navn = this.navn.getValue();
        String kode = this.kode.getValue();

        if (navn != null && !"".equals(navn) && kode != null && !"".equals(kode)) {
            clientText.username(navn, kode);
            error.set("korrekt oprettet");
        } else {
            error.set("Feltet kan ikke være tomt");
        }
        this.kode.set("");
    }

}
