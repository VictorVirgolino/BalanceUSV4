package ultrasomma;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {

    private List<List<String>> data;

    @FXML
    ListView<String> listaArquivos;

    @FXML
    Button iniciarBtn;

//    @FXML
//    private TextField quantV5;
//
//    @FXML
//    private TextField filmeV5;
//
//    @FXML
//    private TextField totalV5;

    @FXML
    private void iniciar() throws IOException, SQLException, ClassNotFoundException {

        ExcelRW.lerExcels(listaArquivos.getItems());
        data =  new ArrayList<>();
        data.addAll(ExcelRW.getData());
        App.setRoot("secondary", data);


//        unimedTab = ExcelRW.getData();
//        insertData(unimedTab);


    }

    @FXML
    private void selecionarArquivos(ActionEvent event){
        FileChooser fc = new FileChooser();
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        List<File> files = fc.showOpenMultipleDialog(window);
        if(files != null){
            for (File file : files) {
                listaArquivos.getItems().add(file.getAbsolutePath());
            }
        }
        else{
            Alert error = new Alert(Alert.AlertType.ERROR, "Arquivos não foram selecionados corretamente", ButtonType.OK);
            error.showAndWait();

            if(error.getResult() == ButtonType.OK){
                error.close();
            }
        }
        if(!listaArquivos.getItems().isEmpty()) {
            System.out.println("Arquivos Selecionados");
            iniciarBtn.setDisable(false);
        }
    }

//    @FXML
//    private void switchToPrimary() throws IOException {
//        App.setRoot("primary","BalanceUS.css", 800, 500);
//
//    }

//    public void insertData(List<String> data)  {
//        quantV5.setText(data.get(0));
//        filmeV5.setText(data.get(1));
//        totalV5.setText(data.get(2));
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        quantV5.setText("10");
    }

//    @FXML
//    private void switchToPrimary() throws IOException {
//        App.setRoot("primary","BalanceUS.css", 800, 500);
//    }
//
//    private void insertData() throws SQLException {
//        unimedTab.addAll(Arrays.asList(quantV5, filmeV5, totalV5));
////        ExcelRW.calculateData(unimedTab);
//        testetxt5.setText("teste 10");
//    }

}
